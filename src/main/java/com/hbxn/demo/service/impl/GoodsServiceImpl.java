package com.hbxn.demo.service.impl;

import com.hbxn.demo.dao.GoodsMapper;
import com.hbxn.demo.entity.Goods;
import com.hbxn.demo.service.GoodsService;
import com.hbxn.demo.utils.RedisCacheUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import redis.clients.jedis.Jedis;


/**
 * GoodsServiceImpl
 *
 * @author SQiang
 * @create 2018-05-17 11:49
 **/
@Service
public class GoodsServiceImpl implements GoodsService {
	private Logger logger =LoggerFactory.getLogger(GoodsServiceImpl.class);
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private RedisCacheUtils redisCacheUtils;
	@Override
	public Goods seleteGoodsInfo(String goodsName) {

		return goodsMapper.seleteGoodsInfo(goodsName);
	}

	@Override
	public boolean updateGoodsNum(String goodsName,String userName) {

		//有些人通过脚本攻击URL,解决策略：限制用户操作频率，10S内只能操作一次
		Jedis jedis = redisCacheUtils.getJedis();
        //NX表示当key不存在时才会设置成功，EX 设置过期时间
		String value=jedis.set(userName,"","NX","EX",10);
		logger.warn("设置redis返回的值："+value);
		if (!"OK".equals(value)){
			logger.warn("用户"+userName+"操作太频繁了");
			return false;
		}
		//拿到令牌的用户才允许操作数据
		String token=jedis.lpop("token_list");
		if(StringUtils.isEmpty(token)){
			logger.warn("没抢到token令牌的用户："+userName);
			return false;
		}
		int a =goodsMapper.updateGoodsNum(goodsName);
		if(a ==1){
			logger.warn("减库存成功！");
			return true;
		}
		return false;
	}
}

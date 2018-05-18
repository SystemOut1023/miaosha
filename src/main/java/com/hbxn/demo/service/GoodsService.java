package com.hbxn.demo.service;

import com.hbxn.demo.entity.Goods;

/**
 * @author SQiang
 * @create 2018-05-17 11:04
 **/
public interface GoodsService {
	/**
	 * 查询秒杀商品信息
	 * @return
	 */
	Goods seleteGoodsInfo(String goodsName);
	/**
	 * 更新商品库存
	 * @param goodsName
	 * @return
	 */
	boolean updateGoodsNum(String goodsName,String userName);

}

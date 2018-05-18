package com.hbxn.demo.dao;

import com.hbxn.demo.entity.Goods;

/**
 * @author SQiang
 * @create 2018-05-17 11:56
 **/
public interface GoodsMapper {
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
	int updateGoodsNum(String goodsName);
}

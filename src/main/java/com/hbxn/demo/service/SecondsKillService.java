package com.hbxn.demo.service;

import com.hbxn.demo.entity.SecondsKill;

/**
 * @author SQiang
 * @create 2018-05-17 11:39
 **/
public interface SecondsKillService {
	/**
	 * 成功秒杀商品信息入库
	 * @param secondsKill
	 * @return
	 */
   int insertSecondsKillGoods(SecondsKill secondsKill);
}

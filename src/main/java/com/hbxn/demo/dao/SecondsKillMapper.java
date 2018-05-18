package com.hbxn.demo.dao;

import com.hbxn.demo.entity.SecondsKill;

public interface SecondsKillMapper {
	/**
	 * 成功秒杀商品信息入库
	 * @param secondsKill
	 * @return
	 */
	int insertSecondsKillGoods(SecondsKill secondsKill);
}

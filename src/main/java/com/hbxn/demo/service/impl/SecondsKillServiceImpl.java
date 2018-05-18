package com.hbxn.demo.service.impl;

import com.hbxn.demo.dao.SecondsKillMapper;
import com.hbxn.demo.entity.SecondsKill;
import com.hbxn.demo.service.SecondsKillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SecondsKillServiceImpl
 *
 * @author SQiang
 * @create 2018-05-17 11:48
 **/
@Service
public class SecondsKillServiceImpl implements SecondsKillService {
	@Autowired
	private SecondsKillMapper secondsKillMapper;
	@Override
	public int insertSecondsKillGoods(SecondsKill secondsKill) {

		return secondsKillMapper.insertSecondsKillGoods(secondsKill);
	}
}

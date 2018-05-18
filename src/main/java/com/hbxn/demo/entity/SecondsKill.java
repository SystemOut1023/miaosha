package com.hbxn.demo.entity;

import java.util.Date;

/**
 * @author SQiang
 * @create 2018-05-17 11:00
 **/
public class SecondsKill {
	private Integer id;
	private String userName;
	private String goodsName;
	private Date carateTime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public Date getCarateTime() {
		return carateTime;
	}

	public void setCarateTime(Date carateTime) {
		this.carateTime = carateTime;
	}
}

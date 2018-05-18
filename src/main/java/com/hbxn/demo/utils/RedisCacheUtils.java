package com.hbxn.demo.utils;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author SQiang
 * @create 2018-05-17 14:33
 **/
public class RedisCacheUtils {
	private JedisPool jedisPool;

	/**
	 * 建立连接池，把配置参数抽取出来
	 * @param host
	 * @param port
	 */
	public RedisCacheUtils(String host,int port){
		//建立连接池参数配置
		JedisPoolConfig config = new JedisPoolConfig();
		//设置最大连接数
		config.setMaxTotal(10000);
		//设置最大阻塞时间，一般是毫秒
		config.setMaxWaitMillis(10000);
		//设置空间连接
		config.setMaxIdle(1000);
		jedisPool = new JedisPool(config,host,port);
	}

	/**
	 * 获得一个jedis对象
	 * @return
	 */
	public Jedis getJedis(){
		return jedisPool.getResource();
	}

}

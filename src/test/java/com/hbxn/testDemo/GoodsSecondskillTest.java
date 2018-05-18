package com.hbxn.testDemo;

import com.hbxn.demo.entity.UserInfo;
import com.hbxn.demo.service.GoodsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.concurrent.CountDownLatch;

/**
 * @author SQiang
 * @create 2018-05-17 15:16
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:/springmvc.xml","classpath*:/spring-mybatis.xml"})
public class GoodsSecondskillTest {
	@Autowired
	private GoodsService goodsService;

	//秒杀商品名称
	private static final String GOODS_NAME="mobile";

	//模拟的请求数量
	private static final int THREAD_NUM = 1000;

	//用来模拟高并发
	private CountDownLatch cd = new CountDownLatch(THREAD_NUM);

	long time = 0L;

	@Before
	public void start(){
		//预先生成token
		Jedis jedis = new Jedis();
		for(int i= 0;i<100;i++){
			jedis.lpush("token_list","SQ-"+i);
		};
		jedis.close();
		System.out.println("开始测试.....");
	}

	@After
	public void end(){
		System.out.println("结束测试，执行时长："+(System.currentTimeMillis()-time));
	}

	@Test
	public void test() throws InterruptedException {
		 Thread[] thread = new Thread[THREAD_NUM];
		 for (int i = 0 ;i< THREAD_NUM;i++){
		 	String userName = "Tom"+i;
		 	Thread thread1 = new Thread(new UserRequest(userName));
			 thread[i]=thread1;
			 thread1.start();
			 //倒计时器倒计时一次
			 cd.countDown();
		 }
		 //等待上面所有线程执行完毕后，结束测试
		for (Thread thread2:thread){
		 	thread2.join();
		}
	}
	private  class UserRequest implements Runnable {
		String userName;

		public UserRequest(String userName) {
			this.userName = userName;
		}

		@Override
		public void run() {
			try {
				cd.await();//等待其他线程就绪后，再运行后续的代码
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//http请求实际上就是多线程调用的这个方法
			goodsService.updateGoodsNum(GOODS_NAME,userName);
		}
	}

}

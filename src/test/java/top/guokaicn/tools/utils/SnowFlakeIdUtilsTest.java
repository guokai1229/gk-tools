package top.guokaicn.tools.utils;

import junit.framework.TestCase;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public class SnowFlakeIdUtilsTest extends TestCase
{

	public void testUniqueLong() throws InterruptedException
	{
		//计时开始时间
		long start = System.currentTimeMillis();
		//让100个线程同时进行
		final CountDownLatch latch = new CountDownLatch(100);
		//判断生成的20万条记录是否有重复记录
		final ConcurrentHashMap<Long, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			//创建100个线程
			new Thread(() -> {
				for (int s = 0; s < 2000; s++) {
					long snowID = SnowFlakeIdUtils.uniqueLong();
					System.out.println(snowID);
					Integer put = map.put(snowID, 1);
					if (put != null) {
						throw new RuntimeException("主键重复");
					}
				}
				latch.countDown();
			}).start();
		}
		//让上面100个线程执行结束后，在走下面输出信息
		latch.await();

		long end = System.currentTimeMillis();

		System.out.println("执行间隔为："+(end - start));
	}

	public void testUniqueLongHex()
	{
		for(int i=0;i<100;i++)
		{
			System.out.println(SnowFlakeIdUtils.uniqueLongHex());
		}
	}
}
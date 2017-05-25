package com.mangocity.guava.cas;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * CAS 底层使用了cmpxchg指令
 * @author Jerrik
 *
 */
public class AtomicLongTest {
	static int index = 0;

	public static void main(String[] args) throws InterruptedException {
		final AtomicLongDefinition counter = new AtomicLongDefinition();
		
		/*counter.compareAndSet(0, 2);
		System.out.println(counter.get());*/

		final ExecutorService executor = Executors.newCachedThreadPool();

		
		for (int i = 0; i < 2000; i++) {
			executor.execute(new Runnable() {
				@Override
				public void run() {
					for (int j = 0; j < 100; j++) {
						counter.getAndIncrement();//修改了里面的实现
						//index++;
					}
				}
			});
		}

		TimeUnit.SECONDS.sleep(7);
		System.out.println("总次数: " + counter.get());
		System.out.println("i: " +counter.getI());
		System.out.println("index: " + index);

		executor.shutdown();
	}

}

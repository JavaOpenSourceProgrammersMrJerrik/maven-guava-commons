package com.mangocity.guava.concurrent;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import com.google.common.util.concurrent.SettableFuture;

public class SettableFutureTest {

	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		final SettableFuture<String> future = SettableFuture.create();

		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					// 模拟耗时操作
					System.out.println("系统休眠三秒");
					TimeUnit.SECONDS.sleep(3);
					future.set("hello");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();

		//同步变异步 
		System.out.println("获取结果: " + future.get(1, TimeUnit.SECONDS));
	}

}

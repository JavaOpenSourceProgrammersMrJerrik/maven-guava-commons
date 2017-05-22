package com.mangocity.guava.concurrent;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;

public class ListenableFutureTester {

	static ExecutorService executor = Executors.newFixedThreadPool(10);
	
	static Random random = new Random();
	
	public static void main(String[] args) {
		ListeningExecutorService listenExecutorService = MoreExecutors.listeningDecorator(executor);
		
		ListenableFuture<String> listenFuture = listenExecutorService.submit(new Callable<String>(){
			@Override
			public String call() throws Exception {
				int sleep = random.nextInt(5);
				System.out.println("当前线程: " + Thread.currentThread().getId() + "休眠->" + sleep + "秒");
				TimeUnit.SECONDS.sleep(sleep);
				//throw new NullPointerException("空指针");
				return Thread.currentThread().getName() + "#" + UUID.randomUUID().toString().substring(1, 5);
			}
		});
		
		Futures.addCallback(listenFuture, new FutureCallback<String>() {
			@Override
			public void onSuccess(String result) {
				System.out.println("回调成功-> " + result);
			}

			@Override
			public void onFailure(Throwable t) {
				System.out.println("回调失败-> " + t);
			}
		});
		
		System.out.println("over()");
		listenExecutorService.shutdown();
	}

}

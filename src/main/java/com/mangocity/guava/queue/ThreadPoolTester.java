package com.mangocity.guava.queue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class ThreadPoolTester {
	private static ExecutorService executor = Executors.newSingleThreadExecutor();
	private static Semaphore semaphore = new Semaphore(1);

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 2000; i++) {
			kickOffEntry(i);
			Thread.sleep(200);
		}

		executor.shutdown();
	}

	private static void kickOffEntry(final int index) {
		if (!semaphore.tryAcquire()) {
			System.out.println("系统自动拦截");
			return;
		}
		
		executor.submit(new Callable<Void>() {
			public Void call() throws InterruptedException {
				try {
					System.out.println("start " + index);
					Thread.sleep(3000); // pretend to do work
					System.out.println("stop " + index);
					return null;

				} finally {
					semaphore.release();
				}
			}
		});
	}
}

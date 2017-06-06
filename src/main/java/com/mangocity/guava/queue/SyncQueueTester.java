package com.mangocity.guava.queue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SyncQueueTester {
	private static ExecutorService executor = new ThreadPoolExecutor(1, 1, 1000, TimeUnit.SECONDS,
			new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.DiscardPolicy());

	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 200; i++) {
			kickOffEntry(i);
			Thread.sleep(200);
		}

		executor.shutdown();
	}

	private static void kickOffEntry(final int index) {
		executor.submit(new Callable<Void>() {
			public Void call() throws InterruptedException {
				System.out.println("start " + index);
				Thread.sleep(2000); // pretend to do work
				//System.out.println("stop " + index);
				return null;
			}
		});
	}
}

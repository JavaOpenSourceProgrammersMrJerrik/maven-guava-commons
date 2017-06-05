package com.mangocity.guava.queue;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueApplication {

	public static void main(String[] args) {
		/*
		 * ExecutorService executorService = new ThreadPoolExecutor(0,
		 * Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new
		 * SynchronousQueue<Runnable>());
		 * 
		 * for(int i=0;i<100;i++){ executorService.submit(new Callable<String>()
		 * {
		 * 
		 * @Override public String call() throws Exception {
		 * TimeUnit.SECONDS.sleep(10); return null; } }); }
		 */

		SynchronousQueue<Object> queue = new SynchronousQueue<Object>();
		for (int i = 0; i < 5; i++) {
			Thread t = new SQThread(queue, 1);
			t.start();
		}
		// Thread.sleep(1000);
		for (int i = 0; i < 10; i++) {
			if (!queue.offer(new Object())) {
				System.out.println("Failure");
			}
		}
	}

	public static class SQThread extends Thread {
		private SynchronousQueue<Object> queue;
		int mode;

		SQThread(SynchronousQueue<Object> queue, int mode) {
			this.queue = queue;
			this.mode = mode;
		}

		@Override
		public void run() {
			Object item = null;
			try {
				System.out.println(Thread.currentThread().getId());
				if (mode == 1) {
					while ((item = queue.take()) != null) {
						System.out.println(item.toString());
					}
				} else {
					//
				}
			} catch (Exception e) {
				//
			}
			System.out.println("end");
		}
	}
}

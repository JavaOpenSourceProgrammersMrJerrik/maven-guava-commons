package com.mangocity.guava.queue;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueTester {

	public static void main(String[] args) throws InterruptedException {
		final SynchronousQueue<String> sQueue = new SynchronousQueue<String>(false);
		
	/*	Thread producer = new Thread(new Producer(sQueue));
		Thread consumer = new Thread(new Consumer(sQueue));

		producer.start();
		consumer.start();*/
	}

	private static void offerElement(final SynchronousQueue<String> sQueue) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(sQueue.offer("hello world"));
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					sQueue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
	}

	private static class Producer implements Runnable {

		private SynchronousQueue<String> sQueue;

		public Producer(SynchronousQueue<String> sQueue) {
			this.sQueue = sQueue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					System.out.println("往队列投递一个消息");
					sQueue.put("message_" + i);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}
		}

	}

	private static class Consumer implements Runnable {

		private SynchronousQueue<String> sQueue;

		public Consumer(SynchronousQueue<String> sQueue) {
			super();
			this.sQueue = sQueue;
		}

		@Override
		public void run() {
			for (int i = 0; i < 5; i++) {
				try {
					TimeUnit.SECONDS.sleep(2);
					String takeMsg = sQueue.take();
					System.out.println("take message: " + takeMsg);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

}

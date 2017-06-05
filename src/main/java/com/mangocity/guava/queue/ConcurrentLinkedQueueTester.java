package com.mangocity.guava.queue;

import java.util.concurrent.ConcurrentLinkedQueue;

public class ConcurrentLinkedQueueTester {

	public static void main(String[] args) {
		ConcurrentLinkedQueue<String> queue = new ConcurrentLinkedQueue<String>();
		
		queue.offer("A");
		
		queue.offer("B");
		
		queue.offer("C");
		
		queue.offer("D");
		
		System.out.println(queue);
		
		queue.peek();
		
		System.out.println(queue);
		
		queue.poll();
		
		System.out.println(queue);
	}

}

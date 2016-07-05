package com.mangocity.guava.eventbus.multi;

import java.util.concurrent.atomic.AtomicLong;

import com.google.common.eventbus.Subscribe;

public class NumberListener {

	public static AtomicLong counter = new AtomicLong(0);
	
	@Subscribe
	public void listen(Integer _integer){
		counter.incrementAndGet();
		System.out.println("Integer: " + _integer);
	}
	
	@Subscribe
	public void listen(Float _float){
		counter.incrementAndGet();
		System.out.println("Float: " + _float);
	}
	
	@Subscribe
	public void listen(Double _double){
		counter.incrementAndGet();
		System.out.println("Double: " + _double);
	}
	
	@Subscribe
	public void listen(String _str){
		counter.incrementAndGet();
		System.out.println("String: " + _str);
	}
	
}

package com.mangocity.guava.eventbus.multi;

import com.google.common.eventbus.EventBus;

public class NumberClient {
	static int CYCLE_NUM = 5000;

	public static void main(String[] args) {
		EventBus bus = new EventBus();

		bus.register(new NumberListener());

		for (int i = 0; i < CYCLE_NUM; i++) {
			if (i % 5 == 0) {
				bus.post(i + "");
			} else if (i % 2 == 0) {
				bus.post(Integer.parseInt(i + ""));
			} else if (i % 3 == 0) {
				bus.post(Double.parseDouble(i + ""));
			} else {
				bus.post(i);
			}
		}

		System.out.println("执行次数: " + NumberListener.counter.get());
	}

}

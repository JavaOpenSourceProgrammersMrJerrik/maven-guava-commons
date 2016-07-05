package com.mangocity.guava.eventbus.point;

import com.google.common.eventbus.Subscribe;

public class PointSubscriber {
	SyncPointHandler pointHandler = new SyncPointHandler();

	@Subscribe
	public void sync(final PointEvent pointEvent) {
		System.out.println("getMessage: mbrId: " + pointEvent.getMbrId() + " ,points: " + pointEvent.getPoints()
				+ " ,desc: " + pointEvent.getDesc());
		System.out.println("begin to handle sysn.");
		new Thread(new Runnable() {
			@Override
			public void run() {
				pointHandler.handle(pointEvent.getMbrId(), pointEvent.getPoints());
			}
		}).start();
		System.out.println("sync point success.");
	}
}

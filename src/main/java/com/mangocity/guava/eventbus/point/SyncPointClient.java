package com.mangocity.guava.eventbus.point;

import java.util.concurrent.TimeUnit;

import com.google.common.eventbus.EventBus;

public class SyncPointClient {

	static EventBus eventBus = new EventBus("Point_Sync");

	static PointSubscriber pointSubscriber;
	
	static PointDescSubscriber pointDescscriber;
	static {
		pointSubscriber = new PointSubscriber();
		pointDescscriber = new PointDescSubscriber();
		eventBus.register(pointSubscriber);
		eventBus.register(pointDescscriber);
	}

	public static void main(String[] args) {
		System.out.println("begin syncData");
		syncData(23423L, 23423D, "商业旅行");
		System.out.println("stop syncData");
	}

	public static void syncData(Long mbrId, Double points, String desc) {
		long start = System.currentTimeMillis();

		eventBus.post(new PointEvent(mbrId, points, desc));
		
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		eventBus.post("HelloWorld");
		System.out.println("CostTime: " + (System.currentTimeMillis() - start) / 1000.0);
	}

}

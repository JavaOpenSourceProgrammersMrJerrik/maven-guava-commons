package com.mangocity.guava.eventbus.point;

import com.google.common.eventbus.EventBus;

public class SyncPointClient {

	static EventBus eventBus = new EventBus("Point_Sync");

	static PointSubscriber pointSubscriber;
	static {
		pointSubscriber = new PointSubscriber();
		eventBus.register(pointSubscriber);
	}

	public static void main(String[] args) {
		System.out.println("begin syncData");
		syncData(23423L, 23423D, "商业旅行");
		System.out.println("stop syncData");
	}

	public static void syncData(Long mbrId, Double points, String desc) {
		long start = System.currentTimeMillis();

		eventBus.post(new PointEvent(mbrId, points, desc));
		/*
		 * eventBus.post(new PointEvent(234234L, 134764D, "购买机票"));
		 * eventBus.post(new PointEvent(4412312L, 434332D, "购买邮轮"));
		 */

		System.out.println("CostTime: " + (System.currentTimeMillis() - start) / 1000.0);
	}

}

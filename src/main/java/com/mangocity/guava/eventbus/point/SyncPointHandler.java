package com.mangocity.guava.eventbus.point;

import java.util.concurrent.TimeUnit;

public class SyncPointHandler {

	void handle(Long mbrId,Double points){
		System.out.println("sync points begin{}");
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
		}
	}
}

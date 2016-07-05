package com.mangocity.guava.eventbus.point;

import com.google.common.eventbus.Subscribe;

public class PointDescSubscriber {

	@Subscribe
	public void onMessage(String textMessage){
		System.out.println("PointDescSubscriber begin{} " + textMessage);
	}
}

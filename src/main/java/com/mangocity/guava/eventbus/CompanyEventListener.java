package com.mangocity.guava.eventbus;

import com.google.common.eventbus.Subscribe;

public class CompanyEventListener {

	@Subscribe
	public void onMessage(CompanyEvent event){
		System.out.println("message: " + event.getMessage());
	}
}

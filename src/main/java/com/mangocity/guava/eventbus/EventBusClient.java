package com.mangocity.guava.eventbus;

import com.google.common.eventbus.EventBus;

public class EventBusClient {

	public static void main(String[] args) {
		EventBus eventBus = new EventBus("company Event.");
		
		CompanyEventListener listener = new CompanyEventListener();
		
		eventBus.register(listener);
		
		eventBus.post(new CompanyEvent("IBM"));
		eventBus.post(new CompanyEvent("Google"));
		eventBus.post(new CompanyEvent("SUN"));
		
	}

}

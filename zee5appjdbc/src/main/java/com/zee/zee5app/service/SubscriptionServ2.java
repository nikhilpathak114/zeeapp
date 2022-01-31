package com.zee.zee5app.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepo2;
@Component
@Service
public class SubscriptionServ2 {
	private SubscriptionRepo2 repository;
	
	private static SubscriptionServ2 service = null;
	
//	public static SubscriptionServ2 getInstance() {
//		if (service ==null)
//			service = new SubscriptionServ2();
//		return service;
//	}
	
	public String addSubscription(Subscription subscription) {
		return this.repository.addSubscription(subscription);
	}
	
	public Subscription getSubscriptionById(String id) {
		return this.repository.getSubscriptionById(id);
	}
	
	public Subscription[] getAllSubscriptions() {
		return repository.getAllSubscription();
	}
	

}
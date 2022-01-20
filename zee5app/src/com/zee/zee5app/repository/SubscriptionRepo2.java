package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;

public interface SubscriptionRepo2 {

	public String addSubscription(Subscription subscriber);
	public String updateSubscription(String id, Subscription subscriber);
	public Subscription getSubscription(String id);
	public Subscription[] getSubscriptions();
	public String deleteSubscriptionById(String id); 
}

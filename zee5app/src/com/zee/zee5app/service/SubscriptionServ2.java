package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;

public interface SubscriptionServ2 {

	public String addSubscription(Subscription subscriber);
	public String updateSubscription(String id, Subscription subscriber);
	public Subscription getSubscriptionById(String id);
	public Subscription[] getSubscription();
	public String deleteSubscriptionById(String id);
}

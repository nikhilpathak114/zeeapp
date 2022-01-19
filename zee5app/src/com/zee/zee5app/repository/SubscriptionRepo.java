package com.zee.zee5app.repository;

import com.zee.zee5app.dto.Subscription;

public class SubscriptionRepo {
	
	private Subscription[] subscribe = new Subscription[20];
	private static int count = -1;
	
	public Subscription[] getSubscriptions() {
		return subscribe;
	}
	
	public String addSubscription(Subscription subscriber) {
		if(count == subscribe.length-1) {
			 Subscription temp[] = new Subscription[subscribe.length*2];
			
			System.arraycopy(subscribe, 0, temp, 0, subscribe.length);
			subscribe = temp;
			subscribe[++count] = subscriber;
			
			
			return "success";
		}
		subscribe[++count] = subscriber;
		return "success";
	}
	
	public Subscription getSubscriptionById(String id) {
		
		//we need to traverse the array
		
		for (Subscription subscription : subscribe) {
			if(subscription != null && subscription.getId().equals(id)) {
				return subscription;
			}
		}
		
		return null;
	}
	
	public String getupdateSubscription(String id, Subscription subscription) {
		for(Subscription currSubscription : subscribe) {
			if( currSubscription != null) {
				if(currSubscription.getId().equals(id)) {
					currSubscription.setAutoRenewal(subscription.getAutoRenewal());
					currSubscription.setExpiryDate(subscription.getExpiryDate());
					currSubscription.setPackCountry(subscription.getPackCountry());
					currSubscription.setPaymentMode(subscription.getPaymentMode());
					currSubscription.setPurchaseDate(subscription.getPurchaseDate());
					currSubscription.setStatus(subscription.getStatus());
					currSubscription.setType(subscription.getType());
					return "updated";
				}
			}
		}
		
		return null;
	}
	
	public String getdeleteSubscription(String id, Subscription subscription) {
		for (Subscription delSubscription : subscribe) {
			if(delSubscription != null) {
				if(delSubscription.getId().equals(id)) {
					continue;
				}
				Subscription temp1[] = new Subscription[subscribe.length];
				
				//we need to copy contents from old to new
				System.arraycopy(subscribe, 0, temp1, 0, subscribe.length);
				subscribe = temp1;
				subscribe[++count] = subscription;
				
				
				return "success";
			}
		}
		return null;
	}
	
	private static SubscriptionRepo subsRepository;
	public static SubscriptionRepo getInstance() {
		if(subsRepository == null)
			subsRepository = new SubscriptionRepo();
		return subsRepository;
	}
	
}

package com.zee.zee5app.repository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.Subscription;

@Component
@Repository
public class SubscriptionRepo2 {
	
	private Subscription[] subscriptions = new Subscription[10];
	private static int count = -1;
	
	private static SubscriptionRepo2 subscriptionRepository;
//	public static SubscriptionRepo2 getInstance() {
//		if(subscriptionRepository==null)
//			subscriptionRepository = new SubscriptionRepo2();
//		
//		return subscriptionRepository;
//	
//	}

	public String addSubscription(Subscription subscription) {
		if(count == subscriptions.length-1) {
			Subscription temp[] = new Subscription[subscriptions.length*4];
		    System.arraycopy(subscription, 0, temp, 0, subscriptions.length);
		    subscriptions = temp;
		    subscriptions[++count] = subscription;
		    
		    return "success1";
		}
		subscriptions[++count] = subscription;
	    return "success1";
		
	}
	
	public String deleteSubscription(String id) {
		return null;
	}
	
	public String modifySubscription(String id, Subscription subscription) {
		return null;
	}
	
	public Subscription getSubscriptionById(String id) {
		for (Subscription subscription : subscriptions) {
			if(subscription!=null && subscription.getId().equals(id))
				return subscription;		
		}
		return null;
	}
	
	public Subscription[] getAllSubscription() {
		return subscriptions;
	}
	
	
}
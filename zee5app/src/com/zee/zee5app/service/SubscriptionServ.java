package com.zee.zee5app.service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepo;

public class SubscriptionServ {

	private SubscriptionRepo subrepository = SubscriptionRepo.getInstance();
	//service is consuming the repository
	
	private SubscriptionServ(){
		// TODO Auto-generated constructor stub
	}
	//if we want to create that single object then we have to create it
	//inside the same class'
	//and we have to share ref with others
	//to do the same we have to declare a method.
	private static SubscriptionServ subservice = null;
	// this would be a static ref
	//only one copy
	
	public static SubscriptionServ getInstance() {
		//it becomes object independent??
		// static will make it independent on the object for execution.
		
		// static method will only acces static ref
		if(subservice == null)
			subservice = new SubscriptionServ();
		return subservice;
		
	}
	
	public String addSubscription(Subscription subscriber) {
		//we need to consume the adduser method from repo.
		return this.subrepository.addSubscription(subscriber);
	}
	
	public Subscription getSubscriptionById(String id) {
		return this.subrepository.getSubscriptionById(id);
	}
	
	public Subscription[] getSubscription(){
		return subrepository.getSubscriptions();
	}
	
	public Subscription getupdateSubscription(String id, Subscription subscription) {
		return this.subrepository.getupdateSeries(id, subscription);
	}
	
	public Subscription getdeleteSubscription(String id, Subscription subscription) {
		return subrepository.getdeleteSeries(id, subscription);
	}
	
}

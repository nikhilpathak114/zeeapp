package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.repository.SubscriptionRepo;
import com.zee.zee5app.service.SubscriptionServ;
import com.zee.zee5app.service.impl.*;
import com.zee.zee5app.repository.impl.*;

public class SubscriptionServImpl implements SubscriptionServ {

	private SubscriptionRepo repository = SubscriptionRepoImpl.getInstance();
	private static SubscriptionServ service;	
	
	public static SubscriptionServ getInstance() {
		if(service == null)
			service = new SubscriptionServImpl();
		return service;
	}
	
    private SubscriptionServImpl() {
		
	}
    
	@Override
	public String addSubscription(Subscription subscription) throws InvalidAmountException {
		// TODO Auto-generated method stub
		return this.repository.addSubscription(subscription);
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.deleteSubscription(id);
	}

	@Override
	public String modifySubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return this.repository.modifySubscription(id, subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		return this.repository.getSubscriptionById(id);
	}

	@Override
	public List<Subscription> getAllSubscription() {
		// TODO Auto-generated method stub
		return this.repository.getAllSubscription();
	}

}

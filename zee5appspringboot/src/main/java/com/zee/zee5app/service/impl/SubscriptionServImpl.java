package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.AlreadyExistsException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepo;
import com.zee.zee5app.service.SubscriptionServ;

@Service
public class SubscriptionServImpl implements SubscriptionServ {

	@Autowired
	private SubscriptionRepo repository;
    
	@Override
	public Subscription addSubscription(Subscription subscription) throws AlreadyExistsException {
		// TODO Auto-generated method stub
		if(repository.existsById(subscription.getSubid())) {
			throw new AlreadyExistsException("This record already exists");
		}
		Subscription subscription2 = repository.save(subscription);
		return subscription2;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional = repository.findById(id);
		if (optional.isEmpty()) {
			throw new IdNotFoundException("Id does not exist");
		}
		return optional;
	}

	@Override
	public Subscription[] getAllSubscriptions() {
		// TODO Auto-generated method stub
		List<Subscription> list = repository.findAll();
		Subscription[] subscriptions = new Subscription[list.size()];
		return list.toArray(subscriptions);
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional = this.getSubscriptionById(id);
		if (optional.isEmpty())
			throw new IdNotFoundException("Record not found");
		else {
			repository.deleteById(id);
			return "Success";
		}
	}

	@Override
	public Optional<List<Subscription>> getAllSubscriptionDetails() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

}

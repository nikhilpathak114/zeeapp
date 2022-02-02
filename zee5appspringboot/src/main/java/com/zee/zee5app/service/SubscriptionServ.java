package com.zee.zee5app.service;
import java.util.List;
import java.util.Optional;

import javax.naming.InvalidNameException;

import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.repository.SubscriptionRepo;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidAmountException;
import com.zee.zee5app.exception.InvalidEmailException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidPasswordException;

public interface SubscriptionServ {
	
	public String addSubscription(Subscription subscription) throws InvalidAmountException;
	public String deleteSubscription(String id) throws IdNotFoundException;
	public String modifySubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException;
	public Subscription[] getAllSubscription();
	Optional<List<Subscription>> getAllSubscriptionDetails() throws InvalidNameException, IdNotFoundException,
			InvalidPasswordException, InvalidEmailException, InvalidIdLengthException;


}
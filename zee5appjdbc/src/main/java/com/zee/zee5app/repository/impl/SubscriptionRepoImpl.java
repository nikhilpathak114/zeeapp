package com.zee.zee5app.repository.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.zee.zee5app.dto.Register;
import com.zee.zee5app.dto.Subscription;
import com.zee.zee5app.exception.NameNotFoundException;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.repository.SubscriptionRepo;

@Component
public class SubscriptionRepoImpl implements SubscriptionRepo {
	
	//AL will hold 10 elements of type subscription
	private ArrayList<Subscription> arrayList = new ArrayList<>();
//	private Subscription[] subscriptions = new Subscription[10];
//	private static int count = -1;
	
    private SubscriptionRepoImpl() {
		
	}
	
    
    //singleton instance
	private static SubscriptionRepoImpl subscriptionRepository;
	public static SubscriptionRepoImpl getInstance() {
		if(subscriptionRepository==null)
			subscriptionRepository = new SubscriptionRepoImpl();
		
		return subscriptionRepository;
	
	}
	
    
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		boolean result = this.arrayList.add(subscription);
		if(result)
		{
			return "successfully added subscription";
		}
		else
		{
			return "failed to add subscription";
		}
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<Subscription> optional = this.getSubscriptionById(id);
		
		if(optional.isPresent())
		{
			boolean result = arrayList.remove(optional.get());
			if(result)
			{
				return "subscription successfully deleted";
			}
			else
			{
				return "subscription failed to delete";
			}
		}

		return "fail";
	}

	@Override
	public String modifySubscription(String id, Subscription subscription){
		// TODO Auto-generated method stub
		String result = null;
		try {
			result = this.deleteSubscription(id);
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(result=="Failed")
			return "Failed to delete subscription";
		result = this.addSubscription(subscription);
		if(result=="Fail")
			return "Failed to Add Subscription";
		return "Subscription Modified";
	}

	
	/*
	 * Optional is a class which is specifically designed to handle null pointer exception
	 * if we are total confident about the object(will surely get object =) then use optional.of()
	 */
	
	@Override
	public Optional<Subscription> getSubscriptionById(String id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		Subscription subscription2 = null;
		for (Subscription subscription : arrayList) {
			if(subscription.getId().equals(id))
			{
				//return Optional.of(subscription);
				subscription2 = subscription;
			}
		}
		return Optional.ofNullable(Optional.of(subscription2).orElseThrow(()-> new IdNotFoundException("subscription id not found")));
		/*Optional.ofNullable():
		 * if subscription2 is holding null it will act like an empty()
		 * if subscription2 is holding object it will act like of()
		 */
	}

	@Override
	public List<Subscription> getAllSubscription() {
		// TODO Auto-generated method stub
        List<Subscription> arrlist = new ArrayList(arrayList);
        Collections.sort(arrlist);
        return arrlist;
	}

}

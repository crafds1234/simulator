package com.simulator.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Publisher<T extends Subscriber> implements Serializable {
	
	/**	 * 	 */
	private static final long serialVersionUID = 2644311034408702582L;
	
	private List<T> subscribers;
	
	public Publisher() {
		super();
	}
	
	public void notifySubscribers() {
		for (T subscriber : subscribers) {
			subscriber.respond();
		}
	}
	
	public void addSubscriber(T subscriber) {
		if(subscribers == null) {
			subscribers = new ArrayList<>();
		}
		
		subscribers.add(subscriber);
	}
	
	public void removeSubscriber(T subscriber) {
		if(subscribers.contains(subscriber)) {
			subscribers.remove(subscriber);
		}
		subscribers.add(subscriber);
	}

}

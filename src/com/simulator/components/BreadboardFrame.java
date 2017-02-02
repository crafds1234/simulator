package com.simulator.components;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;

import com.simulator.components.events.SimulatorWindowAdapter;
import com.simulator.model.Subscriber;

public class BreadboardFrame extends Frame {

	/**	 * 	 */
	private static final long serialVersionUID = -6440794451596077186L;
	
	private List<Subscriber> subscribers;
	
	public BreadboardFrame() {
		super("Breadbord Simulator");
		setLayout(new FlowLayout());
		setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		setSize(800, 530);
		setResizable(false);
		setBackground(Color.LIGHT_GRAY);
		
		setEventListeners();
		
		BreadboardNav headerPanel = new BreadboardNav();
		add(headerPanel);
		
		BreadboardPanel navPanel = new BreadboardPanel();
		add(navPanel);
		
		BreadboardCanvas canvas = new BreadboardCanvas();
		add(canvas);
	}
	
	private void setEventListeners() {
		addWindowListener(new SimulatorWindowAdapter());
	}
	
	@Override
	public void dispose() {
		super.dispose();
	}
	
	
	public void notifySubscribers() {
		for (Subscriber subscriber : subscribers) {
			subscriber.respond(); //TODO
		}
	}
	
	public void addSubscriber(Subscriber subscriber) {
		if(subscribers == null) {
			subscribers = new ArrayList<>();
		}
		
		subscribers.add(subscriber);
	}
	
	public void removeSubscriber(Subscriber subscriber) {
		if(subscribers.contains(subscriber)) {
			subscribers.remove(subscriber);
		}
		subscribers.add(subscriber);
	}
	
	
	public void display() {
		if(this.isVisible()) {
			return;
		}
		setVisible(true);
	}

}

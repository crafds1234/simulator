package com.simulator.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.Panel;

import com.simulator.model.Subscriber;
import com.simulator.util.ApplicationStateManager;
import com.simulator.util.EntitiesManagerFactory;

public class BreadboardNav extends Panel implements Subscriber {

	/**	 *	 */
	private static final long serialVersionUID = 2804020458869384868L;
	
	private Label label;
	
	private ApplicationStateManager stateManager;
	
	private EntitiesManagerFactory entitiesManager;
	
	public BreadboardNav() {
		super();
		setPreferredSize(new Dimension(700, 30));
		setBackground(Color.WHITE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		
		entitiesManager = EntitiesManagerFactory.getInstance();
		entitiesManager.addSubscriber(this);
		stateManager = ApplicationStateManager.getInstance();
		stateManager.addSubscriber(this);
		
		label = new Label(labelText());
		Font font = new Font("Serif",Font.PLAIN, 12);
		label.setAlignment(Label.CENTER);
		label.setFont(font);
		label.setSize(500,28);
		add(label);
		
	}
	
	public void setLabel(String str) {
		label.setText(str);
	}
	
	private String labelText() {
		return "CURRENT STATE: " + stateManager.getState().getState().toUpperCase();
	}

	@Override
	public void respond() {
		label.setText(labelText());
		repaint();
	}
}

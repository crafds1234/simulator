package com.simulator.components;

import java.awt.event.ActionEvent;

import com.simulator.model.AppStates;
import com.simulator.util.EntitiesManagerFactory;

public class BreadboardClearButton extends BreadboardButton {

	/** * */
	private static final long serialVersionUID = -2874474969013358363L;
	
	private EntitiesManagerFactory entitiesManager;
	
	public BreadboardClearButton(String val) {
		super(val, AppStates.CLEAR);
		
		entitiesManager = EntitiesManagerFactory.getInstance();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		super.actionPerformed(e);
		entitiesManager.clear();
		
	}

}

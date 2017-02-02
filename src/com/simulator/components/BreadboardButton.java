package com.simulator.components;

import java.awt.Button;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.simulator.model.AppStates;
import com.simulator.util.ApplicationStateManager;

public class BreadboardButton extends Button implements ActionListener {

	/** * */
	private static final long serialVersionUID = -2874474969013358363L;
	
	ApplicationStateManager stateManager = ApplicationStateManager.getInstance();

	private final AppStates buttonState;

	public BreadboardButton(String val, AppStates state) {
		super(val);
		this.buttonState = state;
		addActionListener(this);
	}

	public AppStates getButtonState() {
		return buttonState;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		stateManager.setState(buttonState);
		System.out.println(buttonState.getGate());
	}

}

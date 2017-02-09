package com.simulator.components;

import static com.simulator.model.AppStates.ADD_AND;
import static com.simulator.model.AppStates.ADD_OR;
import static com.simulator.model.AppStates.ADD_XNOR;
import static com.simulator.model.AppStates.ADD_XOR;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;

import com.simulator.model.AppStates;

public class BreadboardPanel extends Panel {

	/** * */
	private static final long serialVersionUID = -1449972505965313222L;

	public BreadboardPanel() {
		super();
		setPreferredSize(new Dimension(200, 460));
		setBackground(Color.GRAY);

		add(new BreadboardButton("OR", ADD_OR));
		add(new BreadboardButton("AND", ADD_AND));
		add(new BreadboardButton("XNOR", ADD_XNOR));
		add(new BreadboardButton("XOR", ADD_XOR));
		add(new BreadboardButton("Switch", AppStates.ADD_SWITCH));
		add(new BreadboardButton("Lightbulb", AppStates.ADD_LIGHTBULB));
		add(new PrintButton("PRINT"));
		add(new BreadboardClearButton("CLEAR"));

	}

}

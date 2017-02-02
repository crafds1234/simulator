package com.simulator.components;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;

import com.simulator.util.LogicGateImageFactory;
import static com.simulator.model.AppStates.*;

public class BreadboardPanel extends Panel {

	/**	 * 	 */
	private static final long serialVersionUID = -1449972505965313222L;
	
	private LogicGateImageFactory factory;
	
	public BreadboardPanel() {
		super();
		setPreferredSize(new Dimension(200, 460));
		setBackground(Color.CYAN);
		
		add(new BreadboardButton("OR" , ADD_OR));
		add(new BreadboardButton("AND", ADD_AND));
		//add(new BreadboardButton("NAND", ADD_NAND)); FIXME image doesn't exist
		add(new BreadboardButton("XNOR", ADD_XNOR));
		add(new BreadboardButton("XOR", ADD_XOR));
		
	}

}

package com.simulator.components;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;

public class BreadboardNav extends Panel {

	/**	 *	 */
	private static final long serialVersionUID = 2804020458869384868L;
	
	private Label label;
	
	public BreadboardNav() {
		super();
		setPreferredSize(new Dimension(700, 30));
		setBackground(Color.YELLOW);
	}
	
	public void setLabel(String str) {
		label.setText(str);
	}
}

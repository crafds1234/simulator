package com.simulator.model.components;

import com.simulator.model.ConnectionEntity;
import com.simulator.model.LogicGate;

public class AndLogicGate extends LogicGate {
	
	/**	 * 	 */
	private static final long serialVersionUID = -4963446310477588535L;

	public AndLogicGate() {
		super();
	}

	@Override
	public void respond() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getLogicGateValue() {
		ConnectionEntity first = getFirstConnectionEntry();
		ConnectionEntity second = getFirstConnectionEntry();
		
		if(first == null || second == null) {
			return false;
		}
		
		return first.isStatus() && second.isStatus();
	}

}

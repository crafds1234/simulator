package com.simulator.model.components;

import com.simulator.model.ConnectionEntity;
import com.simulator.model.LogicGate;

public class XorLogicGate extends LogicGate {

	/**	 * 	 */
	private static final long serialVersionUID = 2578745501597399536L;
	
	public XorLogicGate() {
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
		
		return first.isStatus() ^ second.isStatus();
	}

}

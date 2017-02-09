package com.simulator.model.components;

import com.simulator.model.CanvasEntity;
import com.simulator.model.ConnectionEntity;
import com.simulator.model.LogicGate;

public class XnorLogicGate extends LogicGate {

	/**	 * 	 */
	private static final long serialVersionUID = 2780255920410542L;
	
	public XnorLogicGate() {
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
		
		return !(first.isStatus() ^ second.isStatus());
	}

	@Override
	public boolean getLogicGateValue(CanvasEntity firstEntry, CanvasEntity secondEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getLogicGateValue(boolean first, boolean second) {
		return !(first ^ second);
	}

}

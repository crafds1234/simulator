package com.simulator.model.components;

import java.awt.Image;

import com.simulator.model.CanvasEntity;
import com.simulator.model.ConnectionEntity;
import com.simulator.model.LogicGate;

public class OrLogicGate extends LogicGate {

	/**	 * 	 */
	private static final long serialVersionUID = -1357449621708199178L;
	
	public OrLogicGate() {
		super();
		// TODO Auto-generated constructor stub
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
		
		return first.isStatus() || second.isStatus();
	}

	@Override
	public boolean getLogicGateValue(CanvasEntity firstEntry, CanvasEntity secondEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getLogicGateValue(boolean first, boolean second) {
		return first || second;
	}

}

package com.simulator.util;

import java.io.Serializable;

import com.simulator.model.AppStates;
import com.simulator.model.LogicGate;

public class ApplicationStateManager implements Serializable {
	
	/**	 * 	 */
	private static final long serialVersionUID = 2204384468945797613L;
	
	private static ApplicationStateManager instance;	
	private AppStates state;
	private LogicGate currentLogicGate;
	
	private ApplicationStateManager() {
		super();
	}
	
	public static ApplicationStateManager getInstance() {
		if(instance == null) {
			instance = new ApplicationStateManager();
		}
		
		return instance;
	}
	
	public boolean isAdding() {
		return state != null && state.getState().equals("add");
	}
	
	public String getGateToAdd() {
		if(!isAdding()) {
			return null;
		}
		return state.getGate();
	}

	public AppStates getState() {
		return state;
	}

	public void setState(AppStates state) {
		this.state = state;
	}

	public LogicGate getCurrentLogicGate() {
		return currentLogicGate;
	}

	public void setCurrentLogicGate(LogicGate currentLogicGate) {
		this.currentLogicGate = currentLogicGate;
	}

}

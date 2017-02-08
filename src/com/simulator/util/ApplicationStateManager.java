package com.simulator.util;

import java.io.Serializable;

import com.simulator.model.AppStates;
import com.simulator.model.CanvasEntity;
import com.simulator.model.Publisher;
import com.simulator.model.Subscriber;
import com.simulator.model.components.BSwitch;

public class ApplicationStateManager extends Publisher<Subscriber> implements Serializable {

	/** * */
	private static final long serialVersionUID = 2204384468945797613L;

	private static ApplicationStateManager instance;
	private AppStates state;
	private CanvasEntity currentLogicGate;
	private BSwitch bSwitchFirstEntity;

	private ApplicationStateManager() {
		super();
	}

	public static ApplicationStateManager getInstance() {
		if (instance == null) {
			instance = new ApplicationStateManager();
		}

		return instance;
	}

	public boolean isConnecting() {
		return state != null && state.getState().equals("connect");
	}

	public boolean isConnectingStart() {
		return state != null && state.getState().equals("connect") && state.getGate().equals("start");
	}

	public boolean isConnectingEnd() {
		return state != null && state.getState().equals("connect") && state.getGate().equals("end");
	}

	public boolean isAdding() {
		return state != null && state.getState().equals("add");
	}

	public boolean isDragging() {
		return state != null && state.equals(AppStates.DRAG);
	}

	public String getGateToAdd() {
		if (!isAdding()) {
			return null;
		}
		return state.getGate();
	}

	public AppStates getState() {
		return state == null ? AppStates.EMPTY : state;
	}

	public void setState(AppStates state) {
		this.state = state;
		notifySubscribers();
	}

	public CanvasEntity getCurrentLogicGate() {
		return currentLogicGate;
	}

	public void setCurrentLogicGate(CanvasEntity currentLogicGate) {
		this.currentLogicGate = currentLogicGate;
		this.bSwitchFirstEntity = null;
	}

	public BSwitch getbSwitchFirstEntity() {
		return bSwitchFirstEntity;
	}

	public void setbSwitchFirstEntity(BSwitch bSwitchFirstEntity) {
		this.bSwitchFirstEntity = bSwitchFirstEntity;
		this.currentLogicGate = null;
	}
	
	public boolean isConnectedToSwitch() {
		return bSwitchFirstEntity != null && currentLogicGate == null;
	}

}

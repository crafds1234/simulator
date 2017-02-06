package com.simulator.model;

public class ConnectionResult extends CanvasEntity implements Subscriber {

	/**	 * 	 */
	private static final long serialVersionUID = -9037120427951173345L;
	
	private LogicGate gate;

	public ConnectionResult() {
		super();
	}

	@Override
	public void respond() {
		// TODO Auto-generated method stub

	}

	public LogicGate getGate() {
		return gate;
	}

	public void setGate(LogicGate gate) {
		this.gate = gate;
	}


}

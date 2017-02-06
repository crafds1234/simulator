package com.simulator.model;

public abstract class LogicGate extends CanvasEntity {

	/** * */
	private static final long serialVersionUID = -8062290736655485489L;

	private String label;

	private ConnectionEntry firstConnectionEntry;

	private ConnectionEntry secondConnectionEntry;

	private ConnectionResult connectionResult;

	public LogicGate() {
		super();
	}
	
	public abstract boolean  getLogicGateValue();

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ConnectionEntry getFirstConnectionEntry() {
		return firstConnectionEntry;
	}

	public void setFirstConnectionEntry(ConnectionEntry firstConnectionEntry) {
		this.firstConnectionEntry = firstConnectionEntry;
	}

	public ConnectionEntry getSecondConnectionEntry() {
		return secondConnectionEntry;
	}

	public void setSecondConnectionEntry(ConnectionEntry secondConnectionEntry) {
		this.secondConnectionEntry = secondConnectionEntry;
	}

	public ConnectionResult getConnectionResult() {
		return connectionResult;
	}

	public void setConnectionResult(ConnectionResult connectionResult) {
		this.connectionResult = connectionResult;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

package com.simulator.model;

public abstract class LogicGate extends CanvasEntity {

	/** * */
	private static final long serialVersionUID = -8062290736655485489L;

	private String label;

	private ConnectionEntry connectionResult;
	
	protected int firstMarginX;
	protected int firstMarginY;
	protected int secondMarginX;
	protected int secondMarginY;
	protected int thirdMarginX;
	protected int thirdMarginY;

	public LogicGate() {
		super();
		firstMarginX = -12;
		secondMarginX = -12;
		thirdMarginX = 65;
		
		firstMarginY = 10;
		secondMarginY = 30;
		thirdMarginY = 20;
		
		ConnectionEntry entry1 = new ConnectionEntry();
		entry1.setEntityBind(this);
		setFirstConnectionEntry(entry1);
		
		ConnectionEntry entry2 = new ConnectionEntry();
		entry2.setEntityBind(this);
		setSecondConnectionEntry(entry2);
		
		ConnectionEntry entry3 = new ConnectionEntry();
		entry3.setEntityBind(this);
		setConnectionResult(entry3);
	}
	
	public abstract boolean  getLogicGateValue();
	
	public int getConnectorFirstX(){
		return getCenterX() + firstMarginX;
	}
	
	public int getConnectorFirstY() {
		return getCenterY() + firstMarginY;
	}
	
	public int getConnectorSecondX() {
		return getCenterX() + secondMarginX;
	}
	
	public int getConnectorSecondY() {
		return getCenterY() + secondMarginY;
	}
	
	public int getConnectorThirdX() {
		return getCenterX() + thirdMarginX;
	}
	
	public int getConnectorThirdY() {
		return getCenterY() + thirdMarginY;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public ConnectionEntry getConnectionResult() {
		return connectionResult;
	}

	public void setConnectionResult(ConnectionEntry connectionResult) {
		this.connectionResult = connectionResult;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

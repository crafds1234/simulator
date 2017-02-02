package com.simulator.model;

public abstract class LogicGate extends CanvasEntity {
	
	/**	 * 	 */
	private static final long serialVersionUID = -8062290736655485489L;
	
	private String label;
	

	public LogicGate() {
		super();
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}

package com.simulator.model;

public enum AppStates {
	
	ADD_AND("add", "and"),
	ADD_OR("add", "or"),
	ADD_NOR("add", "nor"),
	ADD_XNOR("add", "xnor"),
	ADD_NAND("add", "nand"),
	ADD_XOR("add", "xor"),
	ADD_LIGHTBULB("add", "lightbulb"),
	ADD_SWITCH("add", "switch"),
	CONNECT_START("connect", "start"),
	CONNECT_END("connect", "end"),
	REMOVE("remove"),
	DRAW("draw"),
	DRAG("drag"),
	CLEAR("clear"),
	EMPTY("empty");
	
	private String state;
	private String gate;
	AppStates(String str) {
		this.state = str;
		this.gate = "";
	}
	
	AppStates(String str, String gate) {
		this.state = str;
		this.gate = gate;
	}
	
	public String getState() {
		return state;
	}
	
	public String getGate() {
		return gate;
	}
}

package com.simulator.model;

public class ConnectionEntry extends CanvasEntity implements Subscriber {

	int x;
	int y;
	boolean status;

	public ConnectionEntry() {
		super();
	}

	@Override
	public void respond() {
		// TODO Auto-generated method stub

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}

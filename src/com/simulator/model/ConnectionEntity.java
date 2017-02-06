package com.simulator.model;

public class ConnectionEntity extends CanvasEntity implements Subscriber {

	/**	 * 	 */
	private static final long serialVersionUID = -9037120427951173345L;
	
	int x;
	int y;
	boolean status;

	public ConnectionEntity() {
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

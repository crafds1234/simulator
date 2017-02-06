package com.simulator.model;

public class ConnectionEntity extends CanvasEntity implements Subscriber {

	/**	 * 	 */
	private static final long serialVersionUID = -9037120427951173345L;
	
	private int x;
	private int y;
	private boolean status;
	private CanvasEntity entityBind;
	private boolean hasConnection;

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

	public CanvasEntity getEntityBind() {
		return entityBind;
	}

	public void setEntityBind(CanvasEntity entityBind) {
		this.entityBind = entityBind;
	}

	public boolean isHasConnection() {
		return hasConnection;
	}

	public void setHasConnection(boolean hasConnection) {
		this.hasConnection = hasConnection;
	}

}

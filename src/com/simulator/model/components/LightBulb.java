package com.simulator.model.components;

import java.awt.Image;

import com.simulator.model.CanvasEntity;
import com.simulator.model.ConnectionEntry;

public class LightBulb extends CanvasEntity {

	/** * */
	private static final long serialVersionUID = -4963446310477588535L;

	private boolean isTurnedOn;

	private Image turnedOnImage;

	private int firstMarginX;
	private int firstMarginY;

	public LightBulb(Image turnedOff, Image turnedOn) {
		super();
		setImage(turnedOff);
		setTurnedOnImage(turnedOn);

		firstMarginX = 25;
		firstMarginY = 55;

		ConnectionEntry entry1 = new ConnectionEntry();
		entry1.setEntityBind(this);
		setFirstConnectionEntry(entry1);
	}

	@Override
	public void respond() {

	}

	@Override
	public Image getImage() {
		if (isTurnedOn) {
			return turnedOnImage;
		}
		return super.getImage();
	}

	public void toggle() {
		isTurnedOn = !isTurnedOn;
	}

	public int getConnectorFirstX() {
		return getCenterX() + firstMarginX;
	}

	public int getConnectorFirstY() {
		return getCenterY() + firstMarginY;
	}

	public boolean isTurnedOn() {
		return isTurnedOn;
	}

	public void setTurnedOn(boolean isTurnedOn) {
		this.isTurnedOn = isTurnedOn;
	}

	public Image getTurnedOnImage() {
		return turnedOnImage;
	}

	public void setTurnedOnImage(Image turnedOnImage) {
		this.turnedOnImage = turnedOnImage;
	}

	public int getFirstMarginX() {
		return firstMarginX;
	}

	public void setFirstMarginX(int firstMarginX) {
		this.firstMarginX = firstMarginX;
	}

	public int getFirstMarginY() {
		return firstMarginY;
	}

	public void setFirstMarginY(int firstMarginY) {
		this.firstMarginY = firstMarginY;
	}

}

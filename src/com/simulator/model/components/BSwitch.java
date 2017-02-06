package com.simulator.model.components;

import java.awt.Image;

import com.simulator.model.CanvasEntity;

public class BSwitch extends CanvasEntity {

	/** * */
	private static final long serialVersionUID = -4963446310477588535L;

	private boolean isTurnedOn;

	private Image turnedOnImage;

	public BSwitch(Image turnedOff, Image turnedOn) {
		super();
		setImage(turnedOff);
		setTurnedOnImage(turnedOn);
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
	
	public void toggle() {
		isTurnedOn = !isTurnedOn;
	}

}

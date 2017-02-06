package com.simulator.model;

import java.awt.Image;
import java.io.Serializable;

public abstract class CanvasEntity implements Subscriber, Serializable {

	/** * */
	private static final long serialVersionUID = 4580621165600612616L;

	private Image image;
	private int x;
	private int y;
	private int width;
	private int height;

	private ConnectionEntry firstConnectionEntry;

	private ConnectionEntry secondConnectionEntry;

	public boolean isHitbox(int x, int y) {
		return intersects(x, y, 1, 1);
	}

	public boolean intersects(double x, double y, double w, double h) {
		double x0 = getCenterX();
		double y0 = getCenterY();
		return (x + w > x0 && y + h > y0 && x < x0 + getWidth() && y < y0 + getHeight());
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
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

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getCenterX() {
		return x - (width / 2);
	}

	public int getCenterY() {
		return y - (height / 2);
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

}

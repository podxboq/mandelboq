package org.podxboq.mandelboq.ui;

import javafx.scene.paint.Color;

public class Pixel {
	private int x;
	private int y;
	private Color color;

	public Pixel(int x, int y, Color color) {
		this.color = color;
		this.x = x;
		this.y = y;
	}

	public Pixel(int x, int y) {
		this(x, y, Color.WHITE);
	}

	public Pixel() {
		this(0, 0);
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

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
}

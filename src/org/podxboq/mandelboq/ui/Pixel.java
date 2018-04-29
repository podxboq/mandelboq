package org.podxboq.mandelboq.ui;

public class Pixel {
	private int x;
	private int y;
	private int iteraciones;

	public Pixel(int x, int y, int iteraciones) {
		this.iteraciones = iteraciones;
		this.x = x;
		this.y = y;
	}

	public Pixel(int x, int y) {
		this(x, y, 0);
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

	public int getIteraciones() {
		return iteraciones;
	}

	public void setIteraciones(int iteraciones) {
		this.iteraciones = iteraciones;
	}
}

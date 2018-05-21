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

	public Pixel(double x, double y) {
		this((int) x, (int) y, 0);
	}

	public Pixel(int x, int y) {
		this(x, y, 0);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getIteraciones() {
		return iteraciones;
	}

}

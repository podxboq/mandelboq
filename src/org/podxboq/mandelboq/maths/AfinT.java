package org.podxboq.mandelboq.maths;

import org.apache.commons.math3.complex.Complex;

public class AfinT {

	private double w; //width of canvas
	private double h; //height of canvas
	private Complex d1; //punto inferior de la diagonal de la parte visible del plano
	private Complex d2; //punto superior de la diagonal de la parte visible del plano

	public void setView(double w, double h) {
		this.w = w;
		this.h = h;
	}

	public void setPlano(Complex d1, Complex d2) {
		this.d1 = d1;
		this.d2 = d2;
	}

	public Complex img(Complex z) {
		double x = z.getReal();
		double y = z.getImaginary();
		double a = d1.getReal();
		double b = d1.getImaginary();
		double c = d2.getReal();
		double d = d2.getImaginary();
		double imgX = (c - a) / w * x + a;
		double imgY = (b - d) / h * y + d;
		return new Complex(imgX, imgY);
	}

	public void resizeAndCenter(double newW, double newH) {
		Complex newD1 = img(new Complex((w - newW) / 2, (h + newH) / 2));
		Complex newD2 = img(new Complex((w + newW) / 2, (h - newH) / 2));
		setView(newW, newH);
		setPlano(newD1, newD2);
	}
}

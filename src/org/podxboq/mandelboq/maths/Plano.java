package org.podxboq.mandelboq.maths;

import javafx.scene.canvas.Canvas;
import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;


public class Plano {

	private Complex W0;
	private Complex W1;
	private Double rejillaX;
	private Double rejillaY;

	public void updateCanvas(Canvas w) {
		rejillaX = (W1.getReal() - W0.getReal()) / w.getWidth();
		rejillaY = (W1.getImaginary() - W0.getImaginary()) / w.getHeight();
	}

	public void setVisible(Complex w0, Complex w1) {
		W0 = w0;
		W1 = w1;
	}

	public void setRejilla(Double r, Double s) {
		rejillaX = r;
		rejillaY = s;
	}

	public void render() {
		Double x = W0.getReal();
		while (x <= W1.getReal()) {
			Double y = W0.getImaginary();
			while (y <= W1.getImaginary()) {
				ComplexFormat format = new ComplexFormat();
				System.out.println(format.format(new Complex(x, y)));
				y += rejillaY;
			}
			x += rejillaX;
		}
	}

	public Complex getW0() {
		return W0;
	}

	public Complex getW1() {
		return W1;
	}
}

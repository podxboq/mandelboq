package org.podxboq.mandelboq.maths;

import org.apache.commons.math3.complex.Complex;
import org.apache.commons.math3.complex.ComplexFormat;


public class Plano {

	private Complex W0;
	private Complex W1;
	private Double rejilla;

	public void setVisible(Complex w0, Complex w1) {
		W0 = w0;
		W1 = w1;
	}

	public void setRejilla(Double r) {
		rejilla = r;
	}

	public void render() {
		Double x = W0.getReal();
		while (x <= W1.getReal()) {
			Double y = W0.getImaginary();
			while (y <= W1.getImaginary()) {
				ComplexFormat format = new ComplexFormat();
				System.out.println(format.format(new Complex(x, y)));
				y += rejilla;
			}
			x += rejilla;
		}
	}
}

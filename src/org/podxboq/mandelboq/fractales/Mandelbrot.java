package org.podxboq.mandelboq.fractales;

import org.apache.commons.math3.complex.Complex;

public class Mandelbrot {

	private Complex C;

	public int color(Complex z) {
		C = z;
		Complex z1 = new Complex(0, 0);
		final int max = 500;
		int i = 0;
		while (i < max) {
			if (z1.abs() > 2) {
				return i;

			}
			z1 = itera(z1);
			i++;
		}
		return max;
	}

	private Complex itera(Complex z) {
		return C.add(z.multiply(z));
	}
}

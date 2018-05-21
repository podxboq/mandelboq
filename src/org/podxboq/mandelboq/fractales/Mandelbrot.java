package org.podxboq.mandelboq.fractales;

import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.Constantes;

public class Mandelbrot {

	private Complex C;

	public int color(Complex z) {
		C = z;
		Complex z1 = new Complex(0, 0);
		final int max = Constantes.MAX_ITERA;
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

package org.podxboq.mandelboq.fractales;

import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.Constantes;

public class Mandelbrot {

	private Complex C;
	private int iteraciones = Constantes.MAX_ITERA;

	public int color(Complex z) {
		C = z;
		Complex z1 = new Complex(0, 0);
		int i = 0;
		while (i < iteraciones) {
			if (z1.abs() > 2) {
				return i;

			}
			z1 = itera(z1);
			i++;
		}
		return i;
	}

	private Complex itera(Complex z) {
		return C.add(z.multiply(z));
	}

	public void setIteraciones(int newValue) {
		iteraciones = newValue;
	}
}

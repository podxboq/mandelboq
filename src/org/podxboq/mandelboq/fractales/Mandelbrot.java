package org.podxboq.mandelboq.fractales;

import javafx.scene.paint.Color;
import org.apache.commons.math3.complex.Complex;

public class Mandelbrot {

	Complex C;

	public Color color(Complex z) {
		C = z;
		Complex z1 = new Complex(0, 0);
		for (int i = 0; i < 500; i++) {
			if (z1.abs() > 2) {
				return Color.WHITE;

			}
			z1 = itera(z1);
		}
		return Color.BLACK;
	}

	private Complex itera(Complex z) {
		return C.add(z.multiply(z));
	}
}

package org.podxboq.mandelboq.fractales;

import javafx.scene.paint.Color;
import org.apache.commons.math3.complex.Complex;

public class Mandelbrot {

	public Color color(Complex z) {
		Complex z1 = itera(z);
		if (z1.abs() < 2) {
			return Color.BLACK;
		}
		return Color.WHITE;
	}

	private Complex itera(Complex z) {
		return z.add(z.pow(2));
	}
}

package org.podxboq.mandelboq.views;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.fractales.Mandelbrot;
import org.podxboq.mandelboq.maths.AfinT;
import org.podxboq.mandelboq.ui.Pixel;

import java.util.ArrayList;

public class FractalView extends Service<Void> {
	private AfinT phi;
	private double width;
	private double height;
	private ArrayList<Pixel> mascara = new ArrayList<>();


	FractalView(double w, double h, Complex x, Complex y) {
		width = w;
		height = h;
		phi = new AfinT();
		phi.setView(w, h);
		phi.setPlano(x, y);
	}

	@Override
	protected Task<Void> createTask() {
		return new Task<Void>() {
			@Override
			protected Void call() throws Exception {
				mascara.clear();
				phi.resizeAndCenter(width, height);
				phi.setView(width, height);
				final int TASK_MAX = (int) (width * height);
				Mandelbrot mandelbrot = new Mandelbrot();
				int contador = 0;
				for (int i = 0; i < width; i++) {
					for (int j = 0; j < height; j++) {
						if (isCancelled()) {
							break;
						}
						contador++;
						Complex z = phi.img(new Complex(i, j));
						int itera = mandelbrot.color(z);
						mascara.add(new Pixel(i, j, itera));
						updateProgress(contador, TASK_MAX);
					}
				}
				return null;
			}
		};
	}

	public ArrayList<Pixel> getMascara() {
		return mascara;
	}
}

package org.podxboq.mandelboq.views;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.paint.Color;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.fractales.Mandelbrot;
import org.podxboq.mandelboq.maths.AfinT;
import org.podxboq.mandelboq.maths.Plano;

import javax.swing.*;

public class MainView extends JFrame implements Observable {

	private Plano plano;
	private Canvas canvas;
	private AfinT phi;

	public MainView(Canvas canvas, Plano plano) {
		this.canvas = canvas;
		this.plano = plano;
		this.plano.updateCanvas(canvas);
		phi = new AfinT();
		phi.setView(canvas.getWidth(), canvas.getHeight());
		phi.setPlano(plano.getW0(), plano.getW1());
	}

	private Complex getImage(double x, double y) {
		return phi.img(new Complex(x, y));
	}

	public void render() {
		final PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
		Mandelbrot mandelbrot = new Mandelbrot();
		for (int i = 0; i < canvas.getWidth(); i++) {
			for (int j = 0; j < canvas.getHeight(); j++) {
				Complex z = getImage(i, j);
				pixelWriter.setColor(i, j, mandelbrot.color(z));
				validate();
			}
		}

	}

	@Override
	public void addListener(InvalidationListener listener) {

	}

	@Override
	public void removeListener(InvalidationListener listener) {

	}
}

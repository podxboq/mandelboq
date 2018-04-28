package org.podxboq.mandelboq.views;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.fractales.Mandelbrot;
import org.podxboq.mandelboq.maths.AfinT;

public class MainView extends Task {

	private Canvas canvas;
	private AfinT phi;

	public MainView(Canvas canvas, Complex x, Complex y) {
		this.canvas = canvas;
		phi = new AfinT();
		phi.setView(canvas.getWidth(), canvas.getHeight());
		phi.setPlano(x, y);
	}

	private Complex getImage(double x, double y) {
		return phi.img(new Complex(x, y));
	}

	@Override
	protected Object call() {
		final int TASK_MAX = (int) (canvas.getWidth() * canvas.getHeight());
		WritableImage wImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
		final PixelWriter pixelWriter = wImage.getPixelWriter();
		Mandelbrot mandelbrot = new Mandelbrot();
		int contador = 0;
		for (int i = 0; i < canvas.getWidth(); i++) {
			for (int j = 0; j < canvas.getHeight(); j++) {
				contador++;
				Complex z = getImage(i, j);
				Color color = mandelbrot.color(z);
				updateProgress(contador, TASK_MAX);
				pixelWriter.setColor(i, j, color);

			}
		}
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				canvas.getGraphicsContext2D().drawImage(wImage, 0, 0);
			}
		});

		return null;
	}
}

package org.podxboq.mandelboq.views;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.fractales.Mandelbrot;
import org.podxboq.mandelboq.maths.AfinT;
import org.podxboq.mandelboq.ui.Pixel;
import org.podxboq.mandelboq.ui.palettes.Palette;

import java.util.ArrayList;

public class MainView extends Task {

	private Canvas canvas;
	private AfinT phi;
	private Palette palette;
	private ArrayList<Pixel> mascara = new ArrayList<>();

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
		resizeAndCenter();
		System.out.println("Calculando");
		mascara.clear();
		phi.setView(canvas.getWidth(), canvas.getHeight());
		final int TASK_MAX = (int) (canvas.getWidth() * canvas.getHeight());
		Mandelbrot mandelbrot = new Mandelbrot();
		int contador = 0;
		for (int i = 0; i < canvas.getWidth(); i++) {
			for (int j = 0; j < canvas.getHeight(); j++) {
				if (isCancelled()) {
					System.out.println("Cancelado");
					break;
				}
				contador++;
				Complex z = getImage(i, j);
				int itera = mandelbrot.color(z);
				mascara.add(new Pixel(i, j, itera));
				updateProgress(contador, TASK_MAX);
			}
		}
		colorear();
		return null;
	}

	public void setPalette(Palette palette) {
		this.palette = palette;
	}

	public void colorear() {
		System.out.println("Coloreando: " + mascara.size());
		WritableImage wImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
		final PixelWriter pixelWriter = wImage.getPixelWriter();
		for (Pixel p : mascara) {
			pixelWriter.setColor(p.getX(), p.getY(), palette.getColor(p.getIteraciones()));
		}
		Platform.runLater(() -> canvas.getGraphicsContext2D().drawImage(wImage, 0, 0));
	}

	public void animar() {
		WritableImage wImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
		final PixelWriter pixelWriter = wImage.getPixelWriter();
		GraphicsContext gc = canvas.getGraphicsContext2D();

		AnimationTimer loop = new AnimationTimer() {

			@Override
			public void handle(long now) {
				palette.push();
				for (Pixel p : mascara) {
					pixelWriter.setColor(p.getX(), p.getY(), palette.getColor(p.getIteraciones()));
				}
				gc.drawImage(wImage, 0, 0);
			}
		};
		loop.start();
	}

	public void resizeAndCenter() {
		System.out.println(canvas.getWidth());
		phi.resizeAndCenter(canvas.getWidth(), canvas.getHeight());
	}
}

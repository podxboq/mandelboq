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
import org.podxboq.mandelboq.ui.palettes.PresetPalette;

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
		PresetPalette presetPalette = new PresetPalette(1);
		final int TASK_MAX = (int) (canvas.getWidth() * canvas.getHeight());
		WritableImage wImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
		final PixelWriter pixelWriter = wImage.getPixelWriter();
		Mandelbrot mandelbrot = new Mandelbrot();
		int contador = 0;
		for (int i = 0; i < canvas.getWidth(); i++) {
			for (int j = 0; j < canvas.getHeight(); j++) {
				contador++;
				Complex z = getImage(i, j);
				int itera = mandelbrot.color(z);
				updateProgress(contador, TASK_MAX);
				int intColor = 0;
				if (itera < 500) {
					intColor = presetPalette.getPaletteColor(itera);
				}
				int red = (intColor >> 16) & 0xff;
				int green = (intColor >> 8) & 0xff;
				int blue = intColor & 0xff;
				pixelWriter.setColor(i, j, Color.rgb(red, green, blue));
			}
		}
		Platform.runLater(() -> canvas.getGraphicsContext2D().drawImage(wImage, 0, 0));

		return null;
	}
}

package org.podxboq.mandelboq.views;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.shape.Rectangle;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.ui.MainCanvas;
import org.podxboq.mandelboq.ui.Pixel;
import org.podxboq.mandelboq.ui.palettes.Palette;

import java.util.ArrayList;

public class MainView {

	private MainCanvas canvas;
	private Palette palette;
	private ArrayList<Pixel> mascara = new ArrayList<>();
	private FractalView fractalView;

	public MainView(MainCanvas canvas, Complex x, Complex y) {
		this.canvas = canvas;
		fractalView = new FractalView(canvas.getWidth(), canvas.getHeight(), x, y);
		fractalView.setOnSucceeded(event -> colorear());
	}

	public void calcularYPintar() {
		zoomToView();
		fractalView.setWidth(canvas.getWidth());
		fractalView.setHeight(canvas.getHeight());
		if (fractalView.getState() == Service.State.READY) {
			fractalView.start();
		} else if (fractalView.getState() == Service.State.SUCCEEDED) {
			fractalView.restart();
		}
	}

	public void setPalette(Palette palette) {
		this.palette = palette;
	}

	public void colorear() {
		mascara = fractalView.getMascara();
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

	public FractalView getFractalView() {
		return fractalView;
	}

	private void zoomToView() {
		Rectangle zoom = canvas.getZoomView();
		if (zoom != null) {
			canvas.zoomToView();
			fractalView.setPlano(
							fractalView.pixelToComplex(new Pixel(zoom.getX(), zoom.getY() + zoom.getHeight())),
							fractalView.pixelToComplex(new Pixel(zoom.getX() + zoom.getWidth(), zoom.getY())));

		}

	}
}

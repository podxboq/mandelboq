package org.podxboq.mandelboq.controllers;

import javafx.scene.canvas.Canvas;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.ui.MainCanvas;
import org.podxboq.mandelboq.ui.palettes.Palette;
import org.podxboq.mandelboq.views.MainView;

public class MainController {

	private MainView mainView;

	public MainController(MainCanvas canvas, Complex x, Complex y) {
		mainView = new MainView(canvas, x, y);
	}

	public MainView getView() {
		return mainView;
	}

	public void calcularYPintar() {
		getView().calcularYPintar();
	}

	public void setPalette(Palette selectedItem) {
		getView().setPalette(selectedItem);
	}

	public void colorear() {
		getView().colorear();
	}

	public void animar() {
		getView().animar();
	}

	public void setIteraciones(int newValue) {
		getView().getFractalView().getMandelbrot().setIteraciones(newValue);
	}
}

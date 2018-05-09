package org.podxboq.mandelboq.controllers;

import javafx.scene.canvas.Canvas;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.views.MainView;

public class MainController {

	private MainView mainView;

	public MainController(Canvas canvas, Complex x, Complex y) {
		mainView = new MainView(canvas, x, y);
	}

	public MainView getView() {
		return mainView;
	}

	public void resizeAndCenter() {
		mainView.resizeAndCenter();
		new Thread(mainView).start();
	}
}

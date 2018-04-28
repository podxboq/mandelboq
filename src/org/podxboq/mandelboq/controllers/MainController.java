package org.podxboq.mandelboq.controllers;

import javafx.scene.canvas.Canvas;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.maths.Plano;
import org.podxboq.mandelboq.views.MainView;

public class MainController {

	MainView mainView;

	public MainController(Canvas canvas, Complex x, Complex y) {
		Plano plano = new Plano();
		plano.setVisible(x, y);
		mainView = new MainView(canvas, plano);
	}

	public void pintar(){
		mainView.render();
	}
}

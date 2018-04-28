package org.podxboq.mandelboq.ui;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import org.podxboq.mandelboq.controllers.MainController;

public class ParamsBar extends ButtonBar {

	public ParamsBar(MainController mainController) {
		Button render = new Button("Pintar");
		render.setOnAction(event -> new Thread(mainController.getView()).start());
		getButtons().addAll(render);
	}

}

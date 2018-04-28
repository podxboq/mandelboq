package org.podxboq.mandelboq.ui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import org.podxboq.mandelboq.controllers.MainController;

public class ParamsBar extends ButtonBar {

	public ParamsBar(MainController mainController) {
		Button render = new Button("Pintar");
		render.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				mainController.pintar();
			}
		});
		getButtons().addAll(render);
	}

}

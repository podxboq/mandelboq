package org.podxboq.mandelboq.ui;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import org.podxboq.mandelboq.controllers.MainController;
import org.podxboq.mandelboq.ui.palettes.Palette;
import org.podxboq.mandelboq.ui.palettes.PresetPalette;

public class ParamsBar extends ButtonBar {

	public ParamsBar(MainController mainController) {
		Button btnRender = new Button("Pintar");
		btnRender.setOnAction(event -> mainController.getView().calcularYPintar());
	  ComboBox<Palette> cbPalettes = new ComboBox<>();
		cbPalettes.getItems().addAll(PresetPalette.PRESETS_PALETTES);
		cbPalettes.setOnAction(event -> {
			mainController.getView().setPalette(cbPalettes.getSelectionModel().getSelectedItem());
			mainController.getView().colorear();
		});
		Button btnAnim = new Button("Animar");
		btnAnim.setOnAction(event -> mainController.getView().animar());
		getButtons().addAll(btnRender, cbPalettes, btnAnim);
	}

}

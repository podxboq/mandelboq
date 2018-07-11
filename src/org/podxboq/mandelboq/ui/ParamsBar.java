package org.podxboq.mandelboq.ui;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.podxboq.mandelboq.Constantes;
import org.podxboq.mandelboq.controllers.MainController;
import org.podxboq.mandelboq.ui.palettes.Palette;
import org.podxboq.mandelboq.ui.palettes.PresetPalette;

public class ParamsBar extends ButtonBar {

	public ParamsBar(MainController mainController) {
		TextField txtIteraciones = new TextField(String.valueOf(Constantes.MAX_ITERA));
		txtIteraciones.textProperty().addListener((observable, oldValue, newValue) -> {
			mainController.setIteraciones(Integer.valueOf(newValue));
		});
		Button btnRender = new Button("Pintar");
		btnRender.setOnAction(event -> mainController.calcularYPintar());
	  ComboBox<Palette> cbPalettes = new ComboBox<>();
		cbPalettes.getItems().addAll(PresetPalette.PRESETS_PALETTES);
		cbPalettes.setOnAction(event -> {
			mainController.setPalette(cbPalettes.getSelectionModel().getSelectedItem());
			mainController.colorear();
		});
		Button btnAnim = new Button("Animar");
		btnAnim.setOnAction(event -> mainController.animar());
		getButtons().addAll(txtIteraciones, btnRender, cbPalettes, btnAnim);
	}

}

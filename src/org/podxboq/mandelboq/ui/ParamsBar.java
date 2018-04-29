package org.podxboq.mandelboq.ui;

import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ComboBox;
import org.podxboq.mandelboq.controllers.MainController;
import org.podxboq.mandelboq.ui.palettes.Palette;
import org.podxboq.mandelboq.ui.palettes.PresetPalette;

public class ParamsBar extends ButtonBar {
	public static final ComboBox<Palette> cbPalettes = new ComboBox<>();

	public ParamsBar(MainController mainController) {
		Button render = new Button("Pintar");
		render.setOnAction(event -> new Thread(mainController.getView()).start());
		cbPalettes.getItems().addAll(PresetPalette.PRESETS_PALETTES);
		getButtons().addAll(render, cbPalettes);
	}

}

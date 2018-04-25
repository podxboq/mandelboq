package org.podxboq.mandelboq.ui;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class MainMenu extends MenuBar {

	public MainMenu() {
		this.getMenus().addAll(
						new Menu("Fichero"),
						new Menu("Editar"),
						new Menu("Vista"));
	}
}

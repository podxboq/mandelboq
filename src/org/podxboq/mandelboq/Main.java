package org.podxboq.mandelboq;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.podxboq.mandelboq.ui.MainMenu;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = new Group();
		primaryStage.setTitle("Mandelbrot");
		Scene scene = new Scene(root, 300, 275);
		((Group) root).getChildren().addAll(new MainMenu());
		primaryStage.setScene(scene);
		primaryStage.show();
	}


	public static void main(String[] args) {
		launch(args);
	}
}

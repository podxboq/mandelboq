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
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.maths.Plano;
import org.podxboq.mandelboq.ui.MainMenu;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Parent root = new Group();
		primaryStage.setTitle("Mandelbrot");
		Scene scene = new Scene(root, 300, 275);
		((Group) root).getChildren().addAll(new MainMenu());
		primaryStage.setScene(scene);
		primaryStage.show();
		test();
	}

	private void test(){
		Plano p = new Plano();
		p.setVisible(new Complex(-1,-1), new Complex(1,1));
		p.setRejilla(0.5);
		p.render();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

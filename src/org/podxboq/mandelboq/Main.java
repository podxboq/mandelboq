package org.podxboq.mandelboq;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.MenuBar;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.maths.Plano;
import org.podxboq.mandelboq.ui.MainMenu;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Parent root = new Group();
		primaryStage.setTitle("Mandelbrot");

		BorderPane borderPane = new BorderPane();
		final Canvas canvas = new Canvas(1920, 1080);
		borderPane.setCenter(canvas);
		Scene scene = new Scene(borderPane);
		final PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
		for (int i = 0; i < 500; i++) {
			for (int j = 0; j < 100; j++) {

				pixelWriter.setColor(i, j, Color.BLACK);
			}
		}
		pixelWriter.setColor(100, 100, Color.BLACK);
		pixelWriter.setColor(1000, 1000, Color.BLACK);


		((Group) root).getChildren().addAll(new MainMenu());
		primaryStage.setScene(scene);
		primaryStage.show();
		test();
	}

	private void test() {
		Plano p = new Plano();
		p.setVisible(new Complex(-1, -1), new Complex(1, 1));
		p.setRejilla(0.5);
		p.render();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

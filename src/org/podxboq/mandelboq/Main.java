package org.podxboq.mandelboq;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.maths.AfinT;
import org.podxboq.mandelboq.maths.Plano;
import org.podxboq.mandelboq.ui.MainMenu;
import org.podxboq.mandelboq.ui.View;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		Parent root = new Group();
		primaryStage.setTitle("Mandelbrot");

		BorderPane borderPane = new BorderPane();
		final Canvas canvas = new Canvas(500, 500);
		borderPane.setCenter(canvas);
		Scene scene = new Scene(borderPane);

		((Group) root).getChildren().addAll(new MainMenu());
		primaryStage.setScene(scene);
		primaryStage.show();

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				test(canvas);
			}
		});
	}

	private void test(Canvas c) {
		Plano plano = new Plano();
		plano.setVisible(new Complex(-2, -2), new Complex(2, 2));
		View view = new View(c, plano);
		view.render();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

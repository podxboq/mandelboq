package org.podxboq.mandelboq;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.PixelWriter;
import javafx.scene.layout.BorderPane;
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
		final Canvas canvas = new Canvas(500, 500);
		borderPane.setCenter(canvas);
		Scene scene = new Scene(borderPane);
		final PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
		for (int i = 0; i < 100; i++) {
		for (int j = 0; j < 100; j++) {

		pixelWriter.setColor(i, j, Color.BLACK);
		}
		}

		((Group) root).getChildren().addAll(new MainMenu());
		primaryStage.setScene(scene);
		primaryStage.show();
		test(canvas);
	}

	private void test(Canvas c) {
		Plano p = new Plano();
		p.setVisible(new Complex(-1, -1), new Complex(1, 1));
		p.updateCanvas(c);
		p.render();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

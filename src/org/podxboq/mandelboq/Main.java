package org.podxboq.mandelboq;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.apache.commons.math3.complex.Complex;
import org.podxboq.mandelboq.controllers.MainController;
import org.podxboq.mandelboq.ui.ParamsBar;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setWidth(500);
		primaryStage.setHeight(600);
		final Canvas canvas = new Canvas(500, 500);
		canvas.widthProperty().bind(primaryStage.widthProperty());
		canvas.heightProperty().bind(primaryStage.heightProperty().subtract(100));
		MainController mainController = new MainController(canvas, new Complex(-1.6, -1), new Complex(0.5, 1));

		BorderPane borderPane = new BorderPane();
		borderPane.setCenter(canvas);

		ParamsBar pb = new ParamsBar(mainController);
		borderPane.setTop(pb);

		ProgressBar progressBar;
		progressBar = new ProgressBar();
		progressBar.prefWidthProperty().bind(primaryStage.widthProperty());
		progressBar.progressProperty().bind(mainController.getView().getFractalView().progressProperty());
		borderPane.setBottom(progressBar);

		Scene scene = new Scene(borderPane);
		primaryStage.setTitle("Mandelbrot");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

package org.podxboq.mandelboq.ui;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;

public class MainCanvas extends Canvas {

	private double starting_point_x, starting_point_y;
	private Rectangle zoomView;
	private boolean new_rectangle_is_being_drawn = false;

	private Rectangle adjust_rectangle_properties(double starting_point_x,
	                                              double starting_point_y,
	                                              double ending_point_x,
	                                              double ending_point_y) {

		Rectangle rectangle = new Rectangle();
		rectangle.setX(starting_point_x);
		rectangle.setY(starting_point_y);
		rectangle.setWidth(ending_point_x - starting_point_x);
		rectangle.setHeight(ending_point_y - starting_point_y);

		if (rectangle.getWidth() < 0) {
			rectangle.setWidth(-rectangle.getWidth());
			rectangle.setX(ending_point_x);
		}

		if (rectangle.getHeight() < 0) {
			rectangle.setHeight(-rectangle.getHeight());
			rectangle.setY(ending_point_y);
		}
		return rectangle;
	}


	public MainCanvas(double w, double h) {
		super(w, h);

		this.setOnMousePressed((MouseEvent event) ->
		{
			if (!new_rectangle_is_being_drawn) {
				starting_point_x = event.getSceneX();
				starting_point_y = event.getSceneY();
				new_rectangle_is_being_drawn = true;
			}
		});

		this.setOnMouseDragged((MouseEvent event) ->
		{
			if (new_rectangle_is_being_drawn) {
				GraphicsContext gc = getGraphicsContext2D();
				Rectangle rectangle = adjust_rectangle_properties(starting_point_x, starting_point_y, event.getSceneX(), event.getSceneY());
				gc.strokeRoundRect(rectangle.getX(), rectangle.getY() - 50, rectangle.getWidth(), rectangle.getHeight(), 0, 0);
			}
		});

		this.setOnMouseReleased(event -> {
			new_rectangle_is_being_drawn = false;
			Rectangle rectangle = adjust_rectangle_properties(starting_point_x, starting_point_y, event.getSceneX(), event.getSceneY());
			zoomView = new Rectangle(rectangle.getX(), rectangle.getY() - 50, rectangle.getWidth(), rectangle.getHeight());
		});
	}

	public Rectangle getZoomView() {
		return zoomView;
	}

	public void zoomToView() {
		zoomView = null;
	}
}


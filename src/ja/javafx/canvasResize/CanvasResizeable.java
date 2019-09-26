package ja.javafx.canvasResize;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasResizeable extends Canvas {

	public CanvasResizeable() {
		// Redraw canvas when size changes.
		widthProperty().addListener(evt -> draw());
		heightProperty().addListener(evt -> draw());
		//		System.out.println("CanvasResizeable created!!!");
	}

	public void draw() {
		double width = getWidth();
		double height = getHeight();
		//		double width = 		getParent().getLayoutBounds().getWidth();
		//		double height = getParent().getLayoutBounds().getHeight();

		GraphicsContext gc = getGraphicsContext2D();
		gc.clearRect(0, 0, width, height);

		gc.setStroke(Color.RED);
		gc.setLineWidth(2);
		gc.strokeLine(0, 0, width, height);
		gc.strokeLine(0, height, width, 0);

		System.out.format("Draw!!! -> Canvas(%f x %f)\n", width, height);
	}

	@Override
	public double minWidth(double height) {
		return 64;
	}

	@Override
	public double maxWidth(double height) {
		return 10000;
	}

	@Override
	public double prefWidth(double height) {
		return getWidth();
	}

	@Override
	public double minHeight(double width) {
		return 64;

	}

	@Override
	public double maxHeight(double width) {
		return 10000;

	}

	@Override
	public double prefHeight(double width) {
		return getHeight();

	}

	@Override
	public boolean isResizable() {
		return true;
	}
	/*
	@Override
	public void resize(double width, double height) {
		System.out.format("resize!!! -> Canvas(%f x %f)\n", width, height);
		super.setWidth(width);
		super.setHeight(height);
		draw();
	}
	 */
}

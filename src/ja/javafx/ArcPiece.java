package ja.javafx;

import javax.annotation.Generated;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;

/** ArcPiece is an object representing the state (model)
 * of an arc shape that will be drawn on the Graphics Context. During
 * an animation loop values in the model will often be
 * updated. The update() method has the ability to calculate
 * elapsed time to allow the arc to later be animated based on
 * frames per second. The draw() method simply renders the arc
 * shape onto the Graphics Context (surface).
 *
 * Created with IntelliJ IDEA.
 * User: cdea
 */

public class ArcPiece {
	public double x;
	public double y;
	public double w;
	public double h;
	public double startAngle;
	public double arcExtent;
	public double strokeWidth = 2;
	public Color strokeColor;
	public boolean clockwise=false;

	long startTime = 0;
	public long displayTimePerFrameMillis = 60;
	private long displayTimePerFrameNano = 60  * 1000000;

	public double pixelsToMove = 2;
	@Generated("SparkTools")
	private ArcPiece(Builder builder) {
		x = builder.x;
		y = builder.y;
		w = builder.w;
		h = builder.h;
		startAngle = builder.startAngle;
		arcExtent = builder.arcExtent;
		strokeWidth = builder.strokeWidth;
		strokeColor = builder.strokeColor;
		clockwise = builder.clockwise;
		startTime = builder.startTime;
		displayTimePerFrameMillis = builder.displayTimePerFrameMillis;
		displayTimePerFrameNano = builder.displayTimePerFrameNano;
		pixelsToMove = builder.pixelsToMove;
	}
	/*
	public ArcPiece(double x, double y, double w, double h, double startAngle, double arcExtent, double strokeWidth,
			Color strokeColor, boolean clockwise, long displayTimePerFrameMillis, double pixelsToMove) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.startAngle = startAngle;
		this.arcExtent = arcExtent;
		this.strokeWidth = strokeWidth;
		this.strokeColor = strokeColor;
		this.clockwise = clockwise;
		this.displayTimePerFrameMillis = displayTimePerFrameMillis;
		this.pixelsToMove = pixelsToMove;
	}
	 */
	public void update(long now) {
		if (startTime == 0){
			startTime = now;
			displayTimePerFrameNano = displayTimePerFrameMillis * 1000000;
		}

		long elapsed = now - startTime;
		if (elapsed > displayTimePerFrameNano) {
			if (!clockwise){
				startAngle = startAngle + pixelsToMove;
				if (startAngle > 360){
					startAngle = 0;
				}
			} else {
				startAngle = startAngle - pixelsToMove;
				if (startAngle < -360){
					startAngle = 0;
				}
			}
			startTime = 0;
		}
	}

	public void draw(GraphicsContext gc) {
		gc.setStroke(strokeColor);
		gc.setLineWidth(strokeWidth);
		gc.strokeArc(x,
				y,
				w,
				h,
				startAngle,
				arcExtent,
				ArcType.OPEN);
	}
	/*
	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		public double x;
		public double y;
		public double w;
		public double h;
		public double startAngle;
		public double arcExtent;
		public double strokeWidth = 2;
		public Color strokeColor;
		public boolean clockwise=false;

		public long displayTimePerFrameMillis = 60;

		public double pixelsToMove = 2;

		public Builder x(double x) {
			this.x = x;
			return this;
		}

		public Builder y(double y) {
			this.y = y;
			return this;
		}

		public Builder w(double w) {
			this.w = w;
			return this;
		}

		public Builder h(double h) {
			this.h = h;
			return this;
		}

		public Builder startAngle(double startAngle) {
			this.startAngle = startAngle;
			return this;
		}

		public Builder arcExtent(double arcExtent) {
			this.arcExtent = arcExtent;
			return this;
		}

		public Builder strokeColor(Color strokeColor) {
			this.strokeColor = strokeColor;
			return this;
		}

		public Builder strokeWidth(double strokeWidth) {
			this.strokeWidth = strokeWidth;
			return this;
		}

		public Builder displayTimePerFrameMillis(long displayTimePerFrameMillis) {
			this.displayTimePerFrameMillis = displayTimePerFrameMillis;
			return this;
		}

		public Builder pixelsToMove(double pixelsToMove) {
			this.pixelsToMove = pixelsToMove;
			return this;
		}

		public ArcPiece build() {
			return new ArcPiece(x, y, w, h, startAngle, arcExtent, strokeWidth, strokeColor, clockwise, displayTimePerFrameMillis, pixelsToMove);
		}
	}
	 */

	/**
	 * Creates builder to build {@link ArcPiece}.
	 * @return created builder
	 */
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}

	/**
	 * Builder to build {@link ArcPiece}.
	 */
	@Generated("SparkTools")
	public static final class Builder {
		private double x;
		private double y;
		private double w;
		private double h;
		private double startAngle;
		private double arcExtent;
		private double strokeWidth;
		private Color strokeColor;
		private boolean clockwise;
		private long startTime;
		private long displayTimePerFrameMillis;
		private long displayTimePerFrameNano;
		private double pixelsToMove;

		private Builder() {
		}

		public Builder x(double x) {
			this.x = x;
			return this;
		}

		public Builder y(double y) {
			this.y = y;
			return this;
		}

		public Builder w(double w) {
			this.w = w;
			return this;
		}

		public Builder h(double h) {
			this.h = h;
			return this;
		}

		public Builder startAngle(double startAngle) {
			this.startAngle = startAngle;
			return this;
		}

		public Builder arcExtent(double arcExtent) {
			this.arcExtent = arcExtent;
			return this;
		}

		public Builder strokeWidth(double strokeWidth) {
			this.strokeWidth = strokeWidth;
			return this;
		}

		public Builder strokeColor(Color strokeColor) {
			this.strokeColor = strokeColor;
			return this;
		}

		public Builder clockwise(boolean clockwise) {
			this.clockwise = clockwise;
			return this;
		}

		public Builder startTime(long startTime) {
			this.startTime = startTime;
			return this;
		}

		public Builder displayTimePerFrameMillis(long displayTimePerFrameMillis) {
			this.displayTimePerFrameMillis = displayTimePerFrameMillis;
			return this;
		}

		public Builder displayTimePerFrameNano(long displayTimePerFrameNano) {
			this.displayTimePerFrameNano = displayTimePerFrameNano;
			return this;
		}

		public Builder pixelsToMove(double pixelsToMove) {
			this.pixelsToMove = pixelsToMove;
			return this;
		}

		public ArcPiece build() {
			return new ArcPiece(this);
		}
	}
}

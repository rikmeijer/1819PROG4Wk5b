package PROG4_WK4b.model;

public class BallRepresentation {

	final public double centerX;
	final public double centerY;
	final public double radiusX;
	final public double radiusY;
	
	public BallRepresentation(double centerX, double centerY, Radius radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.radiusX = radius.horizontal();
		this.radiusY = radius.vertical();
	}
}

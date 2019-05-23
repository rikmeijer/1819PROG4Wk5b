package PROG4_WK4b.model;

public class Radius {

	final double originalRadius;
	private double horizontalRadius;
	private double verticalRadius;

	public Radius(double radius) {
		this.originalRadius = radius;
		this.horizontalRadius = radius;
		this.verticalRadius = radius;
	}

	
	public double leftBoundary(double centerX) {
		return centerX - horizontalRadius;
	}

	
	public double rightBoundary(double centerX) {
		return centerX + horizontalRadius;
	}

	
	public double topBoundary(double centerY) {
		return centerY - verticalRadius;
	}

	
	public double bottomBoundary(double centerY) {
		return centerY + verticalRadius;
	}

	
	public double absoluteHorizontalSpeed(double relativeHorizontalSpeed) {
		return relativeHorizontalSpeed * horizontalRadius;
	}

	
	public double absoluteVerticalSpeed(double relativeVerticalSpeed) {
		return relativeVerticalSpeed * verticalRadius;
	}

	
	public void transformX(double centerToBoundaryDistance) {
		this.horizontalRadius = Math.min(originalRadius, centerToBoundaryDistance);
		this.verticalRadius = Math.min(originalRadius, Math.max(Ball.MIN_RADIUS_Y * originalRadius, this.verticalRadius + (originalRadius - this.horizontalRadius)));
	}

	
	public void transformY(double centerToBoundaryDistance) {
		this.verticalRadius = Math.min(originalRadius, centerToBoundaryDistance);
		this.horizontalRadius = Math.min(originalRadius, Math.max(Ball.MIN_RADIUS_X * originalRadius, this.horizontalRadius + (originalRadius - this.verticalRadius)));
	}

	
	public double percentageHorizontalOf() {
		return this.horizontalRadius / originalRadius;
	}

	
	public double percentageVerticalOf() {
		return this.verticalRadius / originalRadius;
	}
	
	
	public double horizontal() {
		return this.horizontalRadius;
	}

	
	public double vertical() {
		return this.verticalRadius;
	}
}

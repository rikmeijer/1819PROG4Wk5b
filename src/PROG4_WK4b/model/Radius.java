package PROG4_WK4b.model;

public class Radius {

	private double horizontalRadius;
	private double verticalRadius;

	public Radius(double horizontalRadius, double verticalRadius) {
		this.horizontalRadius = horizontalRadius;
		this.verticalRadius = verticalRadius;
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

	
	public void transformX(double orignalRadius, double centerToBoundaryDistance) {
		this.horizontalRadius = Math.min(orignalRadius, centerToBoundaryDistance);
		this.verticalRadius = Math.min(orignalRadius, Math.max(Ball.MIN_RADIUS_Y * orignalRadius, this.verticalRadius + (orignalRadius - this.horizontalRadius)));
	}

	
	public void transformY(double orignalRadius, double centerToBoundaryDistance) {
		this.verticalRadius = Math.min(orignalRadius, centerToBoundaryDistance);
		this.horizontalRadius = Math.min(orignalRadius, Math.max(Ball.MIN_RADIUS_X * orignalRadius, this.horizontalRadius + (orignalRadius - this.verticalRadius)));
	}

	
	public double percentageHorizontalOf(double radius) {
		return this.horizontalRadius / radius;
	}

	
	public double percentageVerticalOf(double radius) {
		return this.verticalRadius / radius;
	}
	
	
	public double horizontal() {
		return this.horizontalRadius;
	}

	
	public double vertical() {
		return this.verticalRadius;
	}
}

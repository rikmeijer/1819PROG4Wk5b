package PROG4_WK4b.model;

public class CircleRadius implements Radius {

	private double radius;
	
	public CircleRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public double leftBoundary(double centerX) {
		return centerX - radius;
	}

	@Override
	public double rightBoundary(double centerX) {
		return centerX + radius;
	}

	@Override
	public double topBoundary(double centerY) {
		return centerY - radius;
	}

	@Override
	public double bottomBoundary(double centerY) {
		return centerY + radius;
	}

	@Override
	public double absoluteHorizontalSpeed(double relativeHorizontalSpeed) {
		return relativeHorizontalSpeed * radius;
	}

	@Override
	public double absoluteVerticalSpeed(double relativeVerticalSpeed) {
		return relativeVerticalSpeed * radius;
	}

	@Override
	public Radius transformX(double radiusDelta) {
		return new OvalRadius(radius - radiusDelta, radius + radiusDelta);
	}

	@Override
	public Radius transformY(double radiusDelta) {
		return new OvalRadius(radius + radiusDelta, radius - radiusDelta);
	}

	@Override
	public double percentageHorizontalOf(double radius) {
		return this.radius / radius;
	}

	@Override
	public double percentageVerticalOf(double radius) {
		return this.radius / radius;
	}

	@Override
	public double horizontal() {
		return this.radius;
	}

	@Override
	public double vertical() {
		return this.radius;
	}

}

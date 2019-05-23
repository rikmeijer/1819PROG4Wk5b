package PROG4_WK4b.model;

public class OvalRadius implements Radius {

	private double horizontalRadius;
	private double verticalRadius;

	public OvalRadius(double horizontalRadius, double verticalRadius) {
		this.horizontalRadius = horizontalRadius;
		this.verticalRadius = verticalRadius;
	}

	@Override
	public double leftBoundary(double centerX) {
		return centerX - horizontalRadius;
	}

	@Override
	public double rightBoundary(double centerX) {
		return centerX + horizontalRadius;
	}

	@Override
	public double topBoundary(double centerY) {
		return centerY - verticalRadius;
	}

	@Override
	public double bottomBoundary(double centerY) {
		return centerY + verticalRadius;
	}

	@Override
	public double absoluteHorizontalSpeed(double relativeHorizontalSpeed) {
		return relativeHorizontalSpeed * horizontalRadius;
	}

	@Override
	public double absoluteVerticalSpeed(double relativeVerticalSpeed) {
		return relativeVerticalSpeed * verticalRadius;
	}

	@Override
	public Radius transformX(double radiusDelta) {
		return new OvalRadius(horizontalRadius - radiusDelta, verticalRadius + radiusDelta);
	}

	@Override
	public Radius transformY(double radiusDelta) {
		return new OvalRadius(horizontalRadius + radiusDelta, verticalRadius - radiusDelta);
	}

	@Override
	public double percentageHorizontalOf(double radius) {
		return this.horizontalRadius / radius;
	}

	@Override
	public double percentageVerticalOf(double radius) {
		return this.verticalRadius / radius;
	}
	
	@Override
	public double horizontal() {
		return this.horizontalRadius;
	}

	@Override
	public double vertical() {
		return this.verticalRadius;
	}
}

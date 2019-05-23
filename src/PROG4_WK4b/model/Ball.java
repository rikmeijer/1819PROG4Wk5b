package PROG4_WK4b.model;

public class Ball {
	
	final static double MIN_RADIUS_X = 0.5;
	final static double MIN_RADIUS_Y = 0.5;
	final double originalRadius;
	
	private double centerX;
	private double centerY;
	private double horizontalSpeed;
	private double verticalSpeed;
	private Radius radius;

	public Ball(double centerX, double centerY, double radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.originalRadius = radius;
		this.radius = new Radius(radius, radius);
		horizontalSpeed = 0.20;
		verticalSpeed = 0.10;
	}

	public BallRepresentation move(double topBoundary, double rightBoundary, double bottomBoundary, double leftBoundary) {		
		this.centerX += radius.absoluteHorizontalSpeed(horizontalSpeed);
		this.centerY += radius.absoluteVerticalSpeed(verticalSpeed);
		
		if (horizontalSpeed < 0) {
			if (radius.percentageHorizontalOf(this.originalRadius) < 1) {
				radius.transformX(originalRadius, Math.abs(centerX - rightBoundary));
			} else if (leftBoundary > radius.leftBoundary(centerX)) {
				radius.transformX(originalRadius, Math.abs(centerX - leftBoundary));
				if (radius.percentageHorizontalOf(this.originalRadius) <= MIN_RADIUS_X) {
					this.horizontalSpeed *= -1;
				}
			}
		} else {
			if (radius.percentageHorizontalOf(this.originalRadius) < 1) {
				radius.transformX(originalRadius, Math.abs(centerX - leftBoundary));
			} else if (radius.rightBoundary(centerX) > rightBoundary) {
				radius.transformX(originalRadius, Math.abs(centerX - rightBoundary));
				if (radius.percentageHorizontalOf(this.originalRadius) <= MIN_RADIUS_X) {
					this.horizontalSpeed *= -1;
				}
			}
		}
		
		if (verticalSpeed < 0) {
			if (radius.percentageVerticalOf(this.originalRadius) < 1) {
				radius.transformY(originalRadius, Math.abs(centerY - bottomBoundary));
			} else if (topBoundary > radius.topBoundary(centerY)) {
				radius.transformY(originalRadius, Math.abs(centerY - topBoundary));
				if (radius.percentageVerticalOf(this.originalRadius) <= MIN_RADIUS_Y) {
					this.verticalSpeed *= -1;
				}
			}
		} else {
			if (radius.percentageVerticalOf(this.originalRadius) < 1) {
				radius.transformY(originalRadius, Math.abs(centerY - topBoundary));
				
			} else if (radius.bottomBoundary(centerY) > bottomBoundary) {
				radius.transformY(originalRadius, Math.abs(centerY - bottomBoundary));
				if (radius.percentageVerticalOf(this.originalRadius) <= MIN_RADIUS_Y) {
					this.verticalSpeed *= -1;
				}
			}
		}

		return new BallRepresentation(centerX, centerY, radius);
		
	}
}

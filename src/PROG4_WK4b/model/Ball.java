package PROG4_WK4b.model;

public class Ball {
	
	final static double MIN_RADIUS_X = 0.5;
	final static double MIN_RADIUS_Y = 0.5;
	
	private double centerX;
	private double centerY;
	private double horizontalSpeed;
	private double verticalSpeed;
	private Radius radius;

	public Ball(double centerX, double centerY, double radius) {
		this.centerX = centerX;
		this.centerY = centerY;
		this.radius = new Radius(radius);
		horizontalSpeed = 0.20;
		verticalSpeed = 0.10;
	}
	
	public void bounceX(double boundery) {
		radius.transformX(Math.abs(centerX - boundery));
	}
	public void bounceY(double boundery) {
		radius.transformY(Math.abs(centerY - boundery));
	}

	public BallRepresentation move(double topBoundary, double rightBoundary, double bottomBoundary, double leftBoundary) {		
		this.centerX += radius.absoluteHorizontalSpeed(horizontalSpeed);
		this.centerY += radius.absoluteVerticalSpeed(verticalSpeed);
		
		if (horizontalSpeed < 0) {
			if (radius.percentageHorizontalOf() < 1) {
				bounceX(rightBoundary);
			} else if (leftBoundary > radius.leftBoundary(centerX)) {
				bounceX(leftBoundary);
				if (radius.percentageHorizontalOf() <= MIN_RADIUS_X) {
					this.horizontalSpeed *= -1;
				}
			}
		} else {
			if (radius.percentageHorizontalOf() < 1) {
				bounceX(leftBoundary);
			} else if (radius.rightBoundary(centerX) > rightBoundary) {
				bounceX(rightBoundary);
				if (radius.percentageHorizontalOf() <= MIN_RADIUS_X) {
					this.horizontalSpeed *= -1;
				}
			}
		}
		
		if (verticalSpeed < 0) {
			if (radius.percentageVerticalOf() < 1) {
				bounceY(bottomBoundary);
			} else if (topBoundary > radius.topBoundary(centerY)) {
				bounceY(topBoundary);
				if (radius.percentageVerticalOf() <= MIN_RADIUS_Y) {
					this.verticalSpeed *= -1;
				}
			}
		} else {
			if (radius.percentageVerticalOf() < 1) {
				bounceY(topBoundary);
				
			} else if (radius.bottomBoundary(centerY) > bottomBoundary) {
				bounceY(bottomBoundary);
				if (radius.percentageVerticalOf() <= MIN_RADIUS_Y) {
					this.verticalSpeed *= -1;
				}
			}
		}

		return new BallRepresentation(centerX, centerY, radius);
		
	}
}

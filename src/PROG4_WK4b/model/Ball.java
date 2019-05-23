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
		this.radius = new CircleRadius(radius);
		horizontalSpeed = 0.5;
		verticalSpeed = 0.75;
	}

	public BallRepresentation move(double topBoundary, double rightBoundary, double bottomBoundary, double leftBoundary) {
		double newCenterX = centerX + radius.absoluteHorizontalSpeed(horizontalSpeed);
		double newCenterY = centerY + radius.absoluteVerticalSpeed(verticalSpeed);
		
		if (horizontalSpeed < 0) {
			if (leftBoundary < radius.leftBoundary(newCenterX)) {
				this.centerX = newCenterX;
			} else {
				radius = radius.transformX(originalRadius - (newCenterX - leftBoundary));
				this.centerX += radius.absoluteHorizontalSpeed(horizontalSpeed);
			}
		} else {
			if (radius.rightBoundary(newCenterX) >= rightBoundary) {
				radius = radius.transformX(originalRadius - (rightBoundary - newCenterX));
				this.centerX += radius.absoluteHorizontalSpeed(horizontalSpeed);
			} else {
				System.out.println(this.centerX);
				this.centerX = newCenterX;
			}
		}
		
		if (verticalSpeed < 0) {
			if (topBoundary < radius.topBoundary(newCenterY)) {
				this.centerY = newCenterY;
			} else {
				radius = radius.transformY(originalRadius - (newCenterY - topBoundary));
				this.centerY += radius.absoluteVerticalSpeed(verticalSpeed);
			}
		} else {
			if (radius.bottomBoundary(newCenterY) < bottomBoundary) {
				this.centerY = newCenterY;
			} else {
				radius = radius.transformY(originalRadius - (bottomBoundary - newCenterY));
				this.centerY += radius.absoluteVerticalSpeed(verticalSpeed);
			}
		}

		if (radius.percentageHorizontalOf(this.originalRadius) <= MIN_RADIUS_X) {
			this.horizontalSpeed *= -1;
		}
		if (radius.percentageVerticalOf(this.originalRadius) <= MIN_RADIUS_Y) {
			this.verticalSpeed *= -1;
		}

		return new BallRepresentation(centerX, centerY, radius);
		
	}
}

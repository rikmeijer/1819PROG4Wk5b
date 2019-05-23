package PROG4_WK4b.model;

public interface Radius {

	double leftBoundary(double centerX);
	double rightBoundary(double centerX);
	double topBoundary(double centerY);
	double bottomBoundary(double centerY);
	double absoluteHorizontalSpeed(double relativeHorizontalSpeed);
	double absoluteVerticalSpeed(double relativeVerticalSpeed);
	Radius transformX(double radiusDelta);
	Radius transformY(double radiusDelta);
	double percentageHorizontalOf(double radius);
	double percentageVerticalOf(double radius);
	double horizontal();
	double vertical();

}

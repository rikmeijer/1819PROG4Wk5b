package PROG4_Wk4b.controller;

import PROG4_WK4b.model.BallRepresentation;

public class Ball {

	private PROG4_WK4b.model.Ball ball;
	
	public Ball(PROG4_WK4b.model.Ball ball) {
		this.ball = ball;
	}

	public BallRepresentation move(double topBoundary, double rightBoundary, double bottomBoundary, double leftBoundary) {
		return this.ball.move(topBoundary, rightBoundary, bottomBoundary, leftBoundary);
	}
	
}

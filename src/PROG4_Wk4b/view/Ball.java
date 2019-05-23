package PROG4_Wk4b.view;

import PROG4_WK4b.model.BallRepresentation;
import javafx.concurrent.Task;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class Ball extends Pane {
	
	private Task<Void> task;
	private Canvas canvas;

	public Ball(int fps, PROG4_Wk4b.controller.Ball controller) {    	
		Ball view = this;
		task = new Task<Void>() {
		    @Override 
		    public Void call() throws InterruptedException {
		    	while (true) {
			    	BallRepresentation representation = controller.move(0, canvas.getWidth(), canvas.getHeight(), 0);
			    	view.render(representation);
		            Thread.sleep(1000/fps);
		    	}
		    }
		};
	}

	public void render(BallRepresentation representation) {
		GraphicsContext g = canvas.getGraphicsContext2D();
		g.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
		g.setFill(Color.YELLOW);
		g.fillOval(representation.centerX - representation.radiusX, representation.centerY - representation.radiusY, representation.radiusX * 2, representation.radiusY * 2);
	}

	public void start(double width, double height) {
		canvas = new Canvas(width, height);
		getChildren().add(canvas);
		new Thread(task).start();
	}

}

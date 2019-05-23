package PROG4_WK4b;

import PROG4_WK4b.model.Ball;

// GIST: https://git.io/fjlCl

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			BorderPane pane = new BorderPane();
			
			Ball ball = new Ball(50, 50, 40);
			PROG4_Wk4b.controller.Ball controller = new PROG4_Wk4b.controller.Ball(ball);
			PROG4_Wk4b.view.Ball view = new PROG4_Wk4b.view.Ball(60, controller);
			pane.setCenter(view);
			
			Scene scene = new Scene(pane, 400, 400);
	
			
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.setOnShowing(e -> {
				view.start(scene.getWidth(), scene.getHeight());
			});
			primaryStage.setOnCloseRequest(e -> {
				System.exit(0);
			});
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

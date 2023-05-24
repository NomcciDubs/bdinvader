package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
/**
 * INFORMATION, JARS AND IMPORTS CAN BE FOUND AT README FILE
 * THIS CODE WAS MADE TO BE A GRAPHIC INTERFACE FOR A DATABASE FEEL FREE TO CHANGE ANYTHING YOU WANT
 *
 * @license CODE HAVE A MIT LICENSE BUT Oracle JDBC driver HAS GPLv2 IF YOU ARE USING Oracle JDBC driver YOU AGREE WITH THEIR LICENSE.
 * @author NomcciDubs
 * @version 1.0.0
 *
 */

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

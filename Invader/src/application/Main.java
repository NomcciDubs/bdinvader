package application;

import java.io.IOException;

import controller.AllController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
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
	private static Stage stg;
	AllController allController;

	/**
	 *Inicia el codigo abriendo la aplicacion, se asigna el path del View login para este ser el primer abierto.
	 *Evitamos que la aplicacion sea resizable, es decir, pueda aumentar o reducir su tamanio.
	 *El titulo de la aplicacion sera Login Invader
	 *inserta la foto de logo como icono.
	 *Evita que aparezcan los iconos de windows encima de la aplicacion.
	 *Insertamos este MAIN dentro de el controller para asi poder ejecutar los metodos desde el codigo de controller.
	 */
	public void start(Stage primaryStage) {
		try {
			stg= primaryStage;
			primaryStage.setResizable(false);
			stg.setTitle("Login Invader");
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(Main.class.getResource("/view/LoginView.fxml"));
			AnchorPane rootLayout = (AnchorPane)loader.load();
			allController = loader.getController();
			allController.setAplicacion(this);
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);
			stg.getIcons().add(new Image("/resources/Logo.png"));
			primaryStage.initStyle(StageStyle.UNDECORATED);
			primaryStage.show();

		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	public void changeScene(String fxml) throws IOException{
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);

	}
	public void close(){
		stg.close();
	}
}

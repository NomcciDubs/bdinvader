package controller;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.*;

public class AllController {
	Main main;
	 @FXML
	    private ComboBox<Ciudad> cmbCiudadRegistro;

	    @FXML
	    private Label lblErrorLogin;

	    @FXML
	    private Label lblErrorRegistro;

	    @FXML
	    private Pane loginPane;

	    @FXML
	    private PasswordField psswdLogin;

	    @FXML
	    private Pane registroPane;

	    @FXML
	    private TextField txtAfiliadoRegistro;

	    @FXML
	    private TextField txtCedulaRegistro;

	    @FXML
	    private PasswordField txtContraseniaRegistro;

	    @FXML
	    private TextField txtCorreoRegistro;

	    @FXML
	    private TextField txtDireccionRegistro;

	    @FXML
	    private TextField txtTelefonoRegistro;

	    @FXML
	    private TextField txtUsuarioCorreoLogin;

	    @FXML
	    private TextField txtUsuarioRegistro;

	    @FXML
	    void LoginBTN(ActionEvent event) {

	    }

	    @FXML
	    void RegistrarseCompletoBTN(ActionEvent event) {

	    }

	    @FXML
	    void RegistroBTN(ActionEvent event) {

	    }

	    @FXML
	    void exit(ActionEvent event) {

	    }

	    @FXML
	    void iniciarSesionCompletoBTN(ActionEvent event) {

	    }

		public void setAplicacion(Main main) {
			this.main = main;

		}

}

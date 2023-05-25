package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import application.Main;
import database.DbConnection;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import model.*;

public class AllController {
	Main main;
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
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
	    private Button loginBoton;

	    @FXML
	    private Button registrarseBoton;

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
	    	loginPane.setVisible(true);
	    	registroPane.setVisible(false);
	    	loginBoton.setDisable(true);
	    	registrarseBoton.setDisable(false);
	    }

	    @FXML
	    void RegistrarseCompletoBTN(ActionEvent event) {

	    }

	    @FXML
	    void RegistroBTN(ActionEvent event) {
	    	loginPane.setVisible(false);
	    	registroPane.setVisible(true);
	    	loginBoton.setDisable(false);
	    	registrarseBoton.setDisable(true);
	    }

	    @FXML
	    void exit(ActionEvent event) {
	    	main.close();
	    }

	    @FXML
	    void iniciarSesionCompletoBTN(ActionEvent event) {
	    	for (int i = 0; i < listaUsuarios.size(); i++) {
				if(listaUsuarios.get(i).getNombreUsuario().equals(txtUsuarioCorreoLogin.getText())
						|| listaUsuarios.get(i).getCorreo().equals(txtUsuarioCorreoLogin.getText())
						&& psswdLogin.getText()==listaUsuarios.get(i).getContrasenia()){
					System.out.println("IT WORKS - Usuario "+listaUsuarios.get(i).getNombreUsuario());
				}
			}
	    }

		public void setAplicacion(Main main) {
			this.main = main;

		}

		 @FXML
		    void initialize() {
			 Connection connection = DbConnection.connect();
			 llenarUsuarios(connection);
		    }

		private void llenarUsuarios(Connection con) {

			ResultSet rs;
			PreparedStatement ps;
			ArrayList<Usuario> lista = new ArrayList<>();
			String sql = "select cedula, nombreusuario, codigoafliacion, nombre, correo, contrasenia, direccion, numerotelefonico, ciudad_idciudad, estado from usuario";
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					Usuario usuario = new Usuario(rs.getInt("cedula"), rs.getInt("codigoafliacion"), rs.getInt("ciudad_idciudad"), rs.getString("nombreusuario"),
							rs.getString("nombre"), rs.getString("correo"), rs.getString("contrasenia"), rs.getString("direccion"), rs.getString("numerotelefonico"),
							rs.getString("estado"));

					listaUsuarios.add(usuario);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}

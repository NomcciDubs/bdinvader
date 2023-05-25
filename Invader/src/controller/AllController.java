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
	ArrayList<Ciudad> listaCiudades = new ArrayList<>();

	Connection connection;
	 @FXML
	    private ComboBox<Ciudad> cmbCiudadRegistro;

	    @FXML
	    private Label lblErrorLogin;

	    @FXML
	    private Label lblErrorRegistro;

	    @FXML
	    private TextField txtNombreRegistro;

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
	    	String correo, usuario, contrasenia, cedula, direccion, telefono, nombre;
	    	int afiliado, idciudad;
	    	boolean error = false;
	    	correo = txtCorreoRegistro.getText();
	    	usuario = txtUsuarioRegistro.getText();
	    	contrasenia = txtContraseniaRegistro.getText();
	    	cedula = txtCedulaRegistro.getText();
	    	nombre = txtNombreRegistro.getText();
	    	afiliado = Integer.valueOf(txtAfiliadoRegistro.getText());
	    	direccion = txtDireccionRegistro.getText();
	    	telefono = txtTelefonoRegistro.getText();
	    	idciudad = cmbCiudadRegistro.getValue().getIdCiudad();

	    	String sql = "insert into usuario (cedula, nombreusuario, codigoafliacion, nombre, correo, contrasenia, direccion, numerotelefonico, ciudad_idciudad, estado)"
	    			+ " values ("+cedula+",'"+usuario+"',"+afiliado+",'"+nombre+"','"+correo+"','"+contrasenia+"','"+direccion+"','"+telefono+"',"+idciudad+",'ACTIVO')";

	    	try {
				PreparedStatement pstmt  = connection.prepareStatement(sql);
				pstmt.execute();
			} catch (SQLException e) {
				lblErrorRegistro.setText(e.getLocalizedMessage());
				error=true;
			}
	    	if(!error){
	    		loginPane.setVisible(true);
		    	registroPane.setVisible(false);
		    	loginBoton.setDisable(true);
		    	registrarseBoton.setDisable(false);
	    	}


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
			 connection = DbConnection.connect();

			 llenarUsuarios();

			 llenarCiudades();

			 cmbCiudadRegistro.getItems().addAll(listaCiudades);
		    }


		private void llenarCiudades() {
			ResultSet rs;
			PreparedStatement ps;
			String sql = "select idciudad, nombreciudad, departamento_iddepartamento from ciudad";

			try {
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					Ciudad ciudad = new Ciudad(rs.getInt("idciudad"), rs.getInt("departamento_iddepartamento"), rs.getString("nombreciudad"));
					listaCiudades.add(ciudad);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


		}

		private void llenarUsuarios() {

			ResultSet rs;
			PreparedStatement ps;
			String sql = "select cedula, nombreusuario, codigoafliacion, nombre, correo, contrasenia, direccion, numerotelefonico, ciudad_idciudad, estado from usuario";
			try {
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					Usuario usuario = new Usuario(rs.getInt("cedula"), rs.getInt("codigoafliacion"), rs.getInt("ciudad_idciudad"), rs.getString("nombreusuario"),
							rs.getString("nombre"), rs.getString("correo"), rs.getString("contrasenia"), rs.getString("direccion"), rs.getString("numerotelefonico"),
							rs.getString("estado"));

					listaUsuarios.add(usuario);
				}
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

}

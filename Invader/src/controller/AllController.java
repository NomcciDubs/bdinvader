package controller;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import application.Main;
import database.DbConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.*;

public class AllController {
	/**
	 * Creacion de variables
	 */
	Main main; //Es la variable que se utiliza para llamar los metodos de main
	ArrayList<Usuario> listaUsuarios = new ArrayList<>();
	ArrayList<Ciudad> listaCiudades = new ArrayList<>();
	ArrayList<Banco> listaBancos = new ArrayList<>();
	ArrayList<Videojuego> listaVideojuegos = new ArrayList<>();
	ArrayList<Billetera> listaBilleteras = new ArrayList<>();
	ObservableList<Usuario> listaUsuariosFX = FXCollections.observableArrayList(); //Para llenar tablas se utilizan ObservableList
	Usuario usuarioLoggeado;
	Usuario usuarioSeleccionado;
	Billetera billeteraUsuario;


	Connection connection;//La conexion de la base de datos

	/**
	 * Variables declaradas por JAVAFX
	 */
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
	    private Button activarUsuarioBoton;

	    @FXML
	    private TableView<Usuario> tablaUsuarios = new TableView<>();

	    @FXML
	    private TableColumn<Usuario, String> afiliadoTab;

	    @FXML
	    private TableColumn<Usuario, String> cedulaTab;

	    @FXML
	    private TableColumn<Usuario, String> correoTab;

	    @FXML
	    private TableColumn<Usuario, String> direccionTab;

	    @FXML
	    private Button eliminarUsuarioBoton;

	    @FXML
	    private TableColumn<Usuario, String> estadoTab;

	    @FXML
	    private Label labelErrorCalcularNivel;

	    @FXML
	    private Label labelNivel;

	    @FXML
	    private TableColumn<Usuario, String> nombreTab;

	    @FXML
	    private Pane paneNivelVisible;

	    @FXML
	    private Button pantallaCalcularNivelBoton;

	    @FXML
	    private Button pantallaEliminarUsuarioBoton;

	    @FXML
	    private TableColumn<Usuario, String> telefonoTab;

	    @FXML
	    private TextField txtIdUsuarioCalcular;

	    @FXML
	    private CheckBox usuarioActivoCheck;

	    @FXML
	    private CheckBox usuarioInactivoCheck;

	    @FXML
	    private TableColumn<Usuario, String> usuarioTab;

	    @FXML
	    private Pane paneUsuariosLista;

	    @FXML
	    private Pane paneCalcularNivel;

	    @FXML
	    private ComboBox<Banco> bancoCmBx;

	    @FXML
	    private TextField cantidadVentaTxt;

	    @FXML
	    private TextField codigoVentaTxt;


	    @FXML
	    private Label lblErrorRetirar;

	    @FXML
	    private Label lblErrorVender;

	    @FXML
	    private Button retirarBoton;

	    @FXML
	    private Pane retirarPane;

	    @FXML
	    private Label saldoLabel;

	    @FXML
	    private TextField txtCantidadRetirar;

	    @FXML
	    private Button venderBoton;

	    @FXML
	    private Pane venderJuegoPane;

	    @FXML
	    private ComboBox<Videojuego> videojuegoVenderCmBx;

	    @FXML
	    void retirarCambiar(ActionEvent event) {
	    	usuarioLoggeado=main.getUsuario();
	    	llenarBilletera();
	    	retirarPane.setVisible(true);
	    	venderJuegoPane.setVisible(false);
	    	retirarBoton.setDisable(true);
	    	venderBoton.setDisable(false);
	    	for (int i = 0; i < listaBilleteras.size(); i++) {
				if (listaBilleteras.get(i).getUsuario_cedula()== usuarioLoggeado.getCedula()){
					saldoLabel.setText(String.valueOf(listaBilleteras.get(i).getSaldo()));
					billeteraUsuario = listaBilleteras.get(i);
				}
			}

	    }

	    @FXML
	    void retirarDinero(ActionEvent event) {
	    	if(!txtCantidadRetirar.getText().isEmpty()){
	    		float retirar = Float.valueOf(txtCantidadRetirar.getText());
	    		String sql = "";
	    		if(retirar < billeteraUsuario.getSaldo()){
	    			sql = "UPDATE billetera set saldo = "+(billeteraUsuario.getSaldo()-retirar)+" where usuario_cedula = "+usuarioLoggeado.getCedula();
	    			try {
						PreparedStatement pstmt  = connection.prepareStatement(sql);
						pstmt.execute();
						pstmt.close();
						llenarBilletera();
						for (int i = 0; i < listaBilleteras.size(); i++) {
							if (listaBilleteras.get(i).getUsuario_cedula()== usuarioLoggeado.getCedula()){
								saldoLabel.setText(String.valueOf(listaBilleteras.get(i).getSaldo()));
								billeteraUsuario = listaBilleteras.get(i);
							}
						}
						lblErrorRetirar.setText("");
						saldoLabel.setText(String.valueOf(billeteraUsuario.getSaldo()));
					} catch (SQLException e) {
						lblErrorRetirar.setText(e.getLocalizedMessage());
					}
	    		}else{
	    			lblErrorRetirar.setText("El valor que intenta retirar es mayor al saldo");
	    		}


	    	}
	    }

	    @FXML
	    void venderJuego(ActionEvent event) {
	    	usuarioLoggeado = main.getUsuario();
	    	String sql = "BEGIN ? := REGISTRAR_VENTA(?, ?, ?, ?); END;";
	    	try {
	    	  CallableStatement cstmt = connection.prepareCall(sql);
	    	  cstmt.registerOutParameter(1, Types.INTEGER);
	    	  cstmt.setInt(2, usuarioLoggeado.getCedula());
	    	  cstmt.setInt(3, videojuegoVenderCmBx.getValue().getCodigo());
	    	  cstmt.setInt(4, Integer.parseInt(cantidadVentaTxt.getText()));
	    	  cstmt.setInt(5, Integer.parseInt(codigoVentaTxt.getText()));
	    	  cstmt.execute();

	    	  int resultado = cstmt.getInt(1); // Obtener el resultado de la funcion

	    	  cstmt.close();
	    	  lblErrorVender.setText(String.valueOf(resultado));
	    	} catch (SQLException e) {
	    	  e.printStackTrace();
	    	}
	    }

	    @FXML
	    void venderPantalla(ActionEvent event) {
	    	retirarPane.setVisible(false);
	    	venderJuegoPane.setVisible(true);
	    	retirarBoton.setDisable(false);
	    	venderBoton.setDisable(true);
	    }

	    @FXML
	    void activarUsuario(ActionEvent event) {
	    	String sql = "UPDATE Usuario set estado = 'ACTIVO' where CEDULA = "+usuarioSeleccionado.getCedula();

	    	try {
				PreparedStatement pstmt  = connection.prepareStatement(sql);
				pstmt.execute();
				llenarUsuarios();
				actualizarUsuariosCheck();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void actualizarBancos(Event event) {

	    	llenarBanco();
	    	bancoCmBx.getItems().addAll(listaBancos);

	    }
	    @FXML
	    void actualizarJuegos(Event event) {
			llenarVideojuego();
	    	videojuegoVenderCmBx.getItems().addAll(listaVideojuegos);

	    }

	    @FXML
	    void calcularNivel(ActionEvent event) {
	    	String sql = "SELECT CALCULAR_NIVEL_USUARIO("+txtIdUsuarioCalcular.getText()+") as Niv FROM dual";

	    	try {
				PreparedStatement pstmt  = connection.prepareStatement(sql);
				pstmt.execute();
				ResultSet rs = pstmt.executeQuery();
				paneNivelVisible.setVisible(true);
				rs.next();
				labelNivel.setText(rs.getString("Niv"));
				labelErrorCalcularNivel.setText("");
			} catch (SQLException e) {
				labelErrorCalcularNivel.setText(e.getLocalizedMessage());
			}
	    }

	    @FXML
	    void cambiarCalcularNivel(ActionEvent event) {
	    	paneUsuariosLista.setVisible(false);
	    	paneCalcularNivel.setVisible(true);

	    	pantallaCalcularNivelBoton.setDisable(true);
	    	pantallaEliminarUsuarioBoton.setDisable(false);
	    }

	    @FXML
	    void cambiarEliminarUsuario(ActionEvent event) {
	    	paneUsuariosLista.setVisible(true);
	    	paneCalcularNivel.setVisible(false);

	    	pantallaCalcularNivelBoton.setDisable(false);
	    	pantallaEliminarUsuarioBoton.setDisable(true);
	    }

	    @FXML
	    void eliminarUsuario(ActionEvent event) {
	    	String sql = "UPDATE Usuario set estado = 'INACTIVO' where CEDULA = "+usuarioSeleccionado.getCedula();

	    	try {
				PreparedStatement pstmt  = connection.prepareStatement(sql);
				pstmt.execute();
				llenarUsuarios();
				actualizarUsuariosCheck();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }

	    @FXML
	    void LoginBTN(ActionEvent event) {
	    	loginPane.setVisible(true);
	    	registroPane.setVisible(false);
	    	loginBoton.setDisable(true);
	    	registrarseBoton.setDisable(false);
	    }

	    private void actualizarDataUsuariosActivos() {
	    	listaUsuariosFX = FXCollections.observableArrayList();
			tablaUsuarios.getItems().clear();
			for (int i = 0; i < listaUsuarios.size(); i++) {
				if(listaUsuarios.get(i).getEstado().equalsIgnoreCase("ACTIVO")){
					listaUsuariosFX.add(listaUsuarios.get(i));
				}
			}
			this.afiliadoTab.setCellValueFactory(new PropertyValueFactory<>("codigoAfiliacion"));
			this.cedulaTab.setCellValueFactory(new PropertyValueFactory<>("cedula"));
			this.correoTab.setCellValueFactory(new PropertyValueFactory<>("correo"));
			this.direccionTab.setCellValueFactory(new PropertyValueFactory<>("direccion"));
			this.estadoTab.setCellValueFactory(new PropertyValueFactory<>("estado"));
			this.nombreTab.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			this.telefonoTab.setCellValueFactory(new PropertyValueFactory<>("numeroTelefonico"));
			this.usuarioTab.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));

			tablaUsuarios.setItems(listaUsuariosFX);

		}
	    private void actualizarDataUsuariosInactivos() {
	    	listaUsuariosFX = FXCollections.observableArrayList();
			tablaUsuarios.getItems().clear();
			for (int i = 0; i < listaUsuarios.size(); i++) {
				if(listaUsuarios.get(i).getEstado().equalsIgnoreCase("INACTIVO")){
					listaUsuariosFX.add(listaUsuarios.get(i));
				}
			}
			this.afiliadoTab.setCellValueFactory(new PropertyValueFactory<>("codigoAfiliacion"));
			this.cedulaTab.setCellValueFactory(new PropertyValueFactory<>("cedula"));
			this.correoTab.setCellValueFactory(new PropertyValueFactory<>("correo"));
			this.direccionTab.setCellValueFactory(new PropertyValueFactory<>("direccion"));
			this.estadoTab.setCellValueFactory(new PropertyValueFactory<>("estado"));
			this.nombreTab.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			this.telefonoTab.setCellValueFactory(new PropertyValueFactory<>("numeroTelefonico"));
			this.usuarioTab.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));

			tablaUsuarios.setItems(listaUsuariosFX);

		}
	    private void actualizarDataUsuarios() {
	    	listaUsuariosFX = FXCollections.observableArrayList();
			tablaUsuarios.getItems().clear();
			for (int i = 0; i < listaUsuarios.size(); i++) {
				listaUsuariosFX.add(listaUsuarios.get(i));
			}
			this.afiliadoTab.setCellValueFactory(new PropertyValueFactory<>("codigoAfiliacion"));
			this.cedulaTab.setCellValueFactory(new PropertyValueFactory<>("cedula"));
			this.correoTab.setCellValueFactory(new PropertyValueFactory<>("correo"));
			this.direccionTab.setCellValueFactory(new PropertyValueFactory<>("direccion"));
			this.estadoTab.setCellValueFactory(new PropertyValueFactory<>("estado"));
			this.nombreTab.setCellValueFactory(new PropertyValueFactory<>("nombre"));
			this.telefonoTab.setCellValueFactory(new PropertyValueFactory<>("numeroTelefonico"));
			this.usuarioTab.setCellValueFactory(new PropertyValueFactory<>("nombreUsuario"));

			tablaUsuarios.setItems(listaUsuariosFX);

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
				pstmt.close();
			} catch (SQLException e) {
				lblErrorRegistro.setText(e.getLocalizedMessage());
				error=true;
				e.printStackTrace();
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
	    	cmbCiudadRegistro.getItems().addAll(listaCiudades);
	    }
	    /**
	     * Cuando el evento es activado, obtenemos el Stage de cualquier boton para cerrar la ventana
	     * @param event -> Evento activado (Click en la X)
	     */
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


					try {
						usuarioLoggeado = listaUsuarios.get(i);
						main.setUsuario(usuarioLoggeado);
						main.changeScene("/view/UsuarioView.fxml");
						break;
					} catch (IOException e) {
						e.printStackTrace();
					}


				}else if(txtUsuarioCorreoLogin.getText().equals("AdminBD") && psswdLogin.getText().equals("123")){
		    		try {
						main.changeScene("/view/AdminView.fxml");
						break;
					} catch (IOException e) {
						e.printStackTrace();
					}
		    	}else{
		    		lblErrorLogin.setText("El usuario, correo o contrasenia no existe.");
		    	}
			}

	    }

		private void llenarVideojuego() {
			listaVideojuegos = new ArrayList<>();
			ResultSet rs;
			PreparedStatement ps;
			String sql = "select codigo, nombre, descripcion, precio, cantidadvendida, categoria_idcategoria, iddesarrolladora from videojuego";

			try {
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					Videojuego videojuego = new Videojuego(rs.getInt("codigo"), rs.getInt("cantidadvendida"), rs.getInt("categoria_idcategoria"),
							rs.getInt("iddesarrolladora"), rs.getString("nombre"), rs.getString("descripcion"), rs.getFloat("precio"));
					listaVideojuegos.add(videojuego);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		private void llenarBanco() {
			listaBancos = new ArrayList<>();
			ResultSet rs;
			PreparedStatement ps;
			String sql = "select idbanco, nombrebanco from banco";

			try {
				ps = connection.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					Banco banco = new Banco(rs.getInt("idbanco"), rs.getString("nombrebanco"));
					listaBancos.add(banco);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		public void llenarBilletera(){
			listaBilleteras = new ArrayList<>();
			String sql = "select saldo, numerocuenta, usuario_cedula, banco_idbanco from billetera";
			ResultSet rs;
			PreparedStatement ps;
			try {
				ps = connection.prepareStatement(sql);
				 rs = ps.executeQuery();
				while(rs.next()){
					Billetera billetera = new Billetera(rs.getInt("saldo"), rs.getInt("usuario_cedula"), rs.getInt("banco_idbanco"), rs.getString("numeroCuenta"));
					listaBilleteras.add(billetera);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
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

			 tablaUsuarios.getSelectionModel().selectedItemProperty().addListener((obs,oldSelection,newSelection) ->{
					usuarioSeleccionado = newSelection;
					if(usuarioSeleccionado != null){
						if(usuarioSeleccionado.getEstado().equalsIgnoreCase("INACTIVO")){
							activarUsuarioBoton.setDisable(false);
							eliminarUsuarioBoton.setDisable(true);
						}
						if(usuarioSeleccionado.getEstado().equalsIgnoreCase("ACTIVO")){
							activarUsuarioBoton.setDisable(true);
							eliminarUsuarioBoton.setDisable(false);
						}
					}
		    	});


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
				e.printStackTrace();
			}


		}

	    @FXML
	    void ctnUsuarioActivoCheck(ActionEvent event) {
	    	actualizarUsuariosCheck();

	    }

	    private void actualizarUsuariosCheck() {
	    	if(usuarioActivoCheck.isSelected()&& !usuarioInactivoCheck.isSelected()){
	    		actualizarDataUsuariosActivos();
	    		eliminarUsuarioBoton.setVisible(true);
	    		activarUsuarioBoton.setVisible(false);
	    	}
	    	if(!usuarioActivoCheck.isSelected()&& usuarioInactivoCheck.isSelected()){
	    		actualizarDataUsuariosInactivos();
	    		eliminarUsuarioBoton.setVisible(false);
	    		activarUsuarioBoton.setVisible(true);
	    	}
	    	if(!usuarioActivoCheck.isSelected()&& !usuarioInactivoCheck.isSelected()){
	    		tablaUsuarios.getItems().clear();
	    		eliminarUsuarioBoton.setVisible(false);
	    		activarUsuarioBoton.setVisible(false);
	    	}
	    	if(usuarioActivoCheck.isSelected()&& usuarioInactivoCheck.isSelected()){
	    		actualizarDataUsuarios();
	    		eliminarUsuarioBoton.setVisible(true);
	    		activarUsuarioBoton.setVisible(true);
	    	}

		}

		@FXML
	    void ctnUsuarioInactivoCheck(ActionEvent event) {
	    	if(usuarioActivoCheck.isSelected()&& !usuarioInactivoCheck.isSelected()){
	    		actualizarDataUsuariosActivos();
	    		eliminarUsuarioBoton.setVisible(true);
	    		activarUsuarioBoton.setVisible(false);
	    	}
	    	if(!usuarioActivoCheck.isSelected()&& usuarioInactivoCheck.isSelected()){
	    		actualizarDataUsuariosInactivos();
	    		eliminarUsuarioBoton.setVisible(false);
	    		activarUsuarioBoton.setVisible(true);
	    	}
	    	if(!usuarioActivoCheck.isSelected()&& !usuarioInactivoCheck.isSelected()){
	    		tablaUsuarios.getItems().clear();
	    		eliminarUsuarioBoton.setVisible(false);
	    		activarUsuarioBoton.setVisible(false);
	    	}
	    	if(usuarioActivoCheck.isSelected()&& usuarioInactivoCheck.isSelected()){
	    		actualizarDataUsuarios();
	    		eliminarUsuarioBoton.setVisible(true);
	    		activarUsuarioBoton.setVisible(true);
	    	}
	    }
		public void setUsuarioLoggeado(Usuario log){
			usuarioLoggeado = log;
		}

		private void llenarUsuarios() {
			listaUsuarios = new ArrayList<>();
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
				e.printStackTrace();
			}

		}

}

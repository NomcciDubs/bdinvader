package model;

public class Usuario {
	int cedula, codigoAfiliacion, ciudad_idCiudad;
	String nombreUsuario, nombre, correo, contrasenia, direccion, numeroTelefonico,estado;
	public int getCedula() {
		return cedula;
	}
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	public int getCodigoAfiliacion() {
		return codigoAfiliacion;
	}
	public void setCodigoAfiliacion(int codigoAfiliacion) {
		this.codigoAfiliacion = codigoAfiliacion;
	}
	public int getCiudad_idCiudad() {
		return ciudad_idCiudad;
	}
	public void setCiudad_idCiudad(int ciudad_idCiudad) {
		this.ciudad_idCiudad = ciudad_idCiudad;
	}
	public String getNombreUsuario() {
		return nombreUsuario;
	}
	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getNumeroTelefonico() {
		return numeroTelefonico;
	}
	public void setNumeroTelefonico(String numeroTelefonico) {
		this.numeroTelefonico = numeroTelefonico;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Usuario(int cedula, int codigoAfiliacion, int ciudad_idCiudad, String nombreUsuario, String nombre,
			String correo, String contrasenia, String direccion, String numeroTelefonico, String estado) {
		super();
		this.cedula = cedula;
		this.codigoAfiliacion = codigoAfiliacion;
		this.ciudad_idCiudad = ciudad_idCiudad;
		this.nombreUsuario = nombreUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contrasenia = contrasenia;
		this.direccion = direccion;
		this.numeroTelefonico = numeroTelefonico;
		this.estado = estado;
	}


}

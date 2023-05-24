package model;

public class Nivel {
	int cantidadVentas, usuario_cedula, venta_idventa, nivelUsuario;
	Float comision;
	public int getCantidadVentas() {
		return cantidadVentas;
	}
	public void setCantidadVentas(int cantidadVentas) {
		this.cantidadVentas = cantidadVentas;
	}
	public int getUsuario_cedula() {
		return usuario_cedula;
	}
	public void setUsuario_cedula(int usuario_cedula) {
		this.usuario_cedula = usuario_cedula;
	}
	public int getVenta_idventa() {
		return venta_idventa;
	}
	public void setVenta_idventa(int venta_idventa) {
		this.venta_idventa = venta_idventa;
	}
	public int getNivelUsuario() {
		return nivelUsuario;
	}
	public void setNivelUsuario(int nivelUsuario) {
		this.nivelUsuario = nivelUsuario;
	}
	public Float getComision() {
		return comision;
	}
	public void setComision(Float comision) {
		this.comision = comision;
	}
	public Nivel(int cantidadVentas, int usuario_cedula, int venta_idventa, int nivelUsuario, Float comision) {
		super();
		this.cantidadVentas = cantidadVentas;
		this.usuario_cedula = usuario_cedula;
		this.venta_idventa = venta_idventa;
		this.nivelUsuario = nivelUsuario;
		this.comision = comision;
	}


}

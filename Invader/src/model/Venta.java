package model;

public class Venta {
	int idVenta, cantidad, videojuego_codigo;

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getVideojuego_codigo() {
		return videojuego_codigo;
	}

	public void setVideojuego_codigo(int videojuego_codigo) {
		this.videojuego_codigo = videojuego_codigo;
	}

	public Venta(int idVenta, int cantidad, int videojuego_codigo) {
		super();
		this.idVenta = idVenta;
		this.cantidad = cantidad;
		this.videojuego_codigo = videojuego_codigo;
	}


}

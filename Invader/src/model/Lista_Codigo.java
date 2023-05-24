package model;

public class Lista_Codigo {
	String idCodigo;
	int videojuego;
	public String getIdCodigo() {
		return idCodigo;
	}
	public void setIdCodigo(String idCodigo) {
		this.idCodigo = idCodigo;
	}
	public int getVideojuego() {
		return videojuego;
	}
	public void setVideojuego(int videojuego) {
		this.videojuego = videojuego;
	}
	public Lista_Codigo(String idCodigo, int videojuego) {
		super();
		this.idCodigo = idCodigo;
		this.videojuego = videojuego;
	}


}

package model;

public class Categoria {
	int idCateogira;
	String nombre;
	public int getIdCateogira() {
		return idCateogira;
	}
	public void setIdCateogira(int idCateogira) {
		this.idCateogira = idCateogira;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria(int idCateogira, String nombre) {
		super();
		this.idCateogira = idCateogira;
		this.nombre = nombre;
	}


}

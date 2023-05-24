package model;

public class Desarrolladora {
	int idDesarrolladora;
	String nombre;
	public int getIdDesarrolladora() {
		return idDesarrolladora;
	}
	public void setIdDesarrolladora(int idDesarrolladora) {
		this.idDesarrolladora = idDesarrolladora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Desarrolladora(int idDesarrolladora, String nombre) {
		super();
		this.idDesarrolladora = idDesarrolladora;
		this.nombre = nombre;
	}


}

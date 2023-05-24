package model;

public class Ciudad {
	int idCiudad, id_departamento;
	String nombreCiudad;
	public int getIdCiudad() {
		return idCiudad;
	}
	public void setIdCiudad(int idCiudad) {
		this.idCiudad = idCiudad;
	}
	public int getId_departamento() {
		return id_departamento;
	}
	public void setId_departamento(int id_departamento) {
		this.id_departamento = id_departamento;
	}
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public Ciudad(int idCiudad, int id_departamento, String nombreCiudad) {
		super();
		this.idCiudad = idCiudad;
		this.id_departamento = id_departamento;
		this.nombreCiudad = nombreCiudad;
	}

}

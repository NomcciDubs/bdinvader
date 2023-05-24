package model;

public class Departamento {
	int idDepartamento, id_pais;
	String nombreDepartamento;
	public int getIdDepartamento() {
		return idDepartamento;
	}
	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}
	public int getId_pais() {
		return id_pais;
	}
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	public String getNombreDepartamento() {
		return nombreDepartamento;
	}
	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	public Departamento(int idDepartamento, int id_pais, String nombreDepartamento) {
		super();
		this.idDepartamento = idDepartamento;
		this.id_pais = id_pais;
		this.nombreDepartamento = nombreDepartamento;
	}


}

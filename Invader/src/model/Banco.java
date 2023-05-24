package model;
public class Banco {
	int idBanco;
	String nombreBanco;
	public int getIdBanco() {
		return idBanco;
	}
	public void setIdBanco(int idBanco) {
		this.idBanco = idBanco;
	}
	public String getNombreBanco() {
		return nombreBanco;
	}
	public void setNombreBanco(String nombreBanco) {
		this.nombreBanco = nombreBanco;
	}
	public Banco(int idBanco, String nombreBanco) {
		super();
		this.idBanco = idBanco;
		this.nombreBanco = nombreBanco;
	}


}

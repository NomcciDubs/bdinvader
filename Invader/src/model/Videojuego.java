package model;

public class Videojuego {
	int codigo, cantidadVendida, id_cateogria, id_desarrolladora;
	String nombre, descripcion;
	Float precio;
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public int getCantidadVendida() {
		return cantidadVendida;
	}
	public void setCantidadVendida(int cantidadVendida) {
		this.cantidadVendida = cantidadVendida;
	}
	public int getId_cateogria() {
		return id_cateogria;
	}
	public void setId_cateogria(int id_cateogria) {
		this.id_cateogria = id_cateogria;
	}
	public int getId_desarrolladora() {
		return id_desarrolladora;
	}
	public void setId_desarrolladora(int id_desarrolladora) {
		this.id_desarrolladora = id_desarrolladora;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Float getPrecio() {
		return precio;
	}
	public void setPrecio(Float precio) {
		this.precio = precio;
	}
	public Videojuego(int codigo, int cantidadVendida, int id_cateogria, int id_desarrolladora, String nombre,
			String descripcion, Float precio) {
		super();
		this.codigo = codigo;
		this.cantidadVendida = cantidadVendida;
		this.id_cateogria = id_cateogria;
		this.id_desarrolladora = id_desarrolladora;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	@Override
	public String toString() {
		return nombre;
	}


}

package model;

public class Billetera {
	int saldo, usuario_cedula, banco_idbanco;
	String numeroCuenta;
	public int getSaldo() {
		return saldo;
	}
	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}
	public int getUsuario_cedula() {
		return usuario_cedula;
	}
	public void setUsuario_cedula(int usuario_cedula) {
		this.usuario_cedula = usuario_cedula;
	}
	public int getBanco_idbanco() {
		return banco_idbanco;
	}
	public void setBanco_idbanco(int banco_idbanco) {
		this.banco_idbanco = banco_idbanco;
	}
	public String getNumeroCuenta() {
		return numeroCuenta;
	}
	public void setNumeroCuenta(String numeroCuenta) {
		this.numeroCuenta = numeroCuenta;
	}
	public Billetera(int saldo, int usuario_cedula, int banco_idbanco, String numeroCuenta) {
		super();
		this.saldo = saldo;
		this.usuario_cedula = usuario_cedula;
		this.banco_idbanco = banco_idbanco;
		this.numeroCuenta = numeroCuenta;
	}


}

package br.imd.ioac.configuracoes;

public class Comandos {
	String comando;
	String valor1;
	String valor2;
	
	public Comandos(String comando, String valor1, String valor2){
		this.comando = comando;
		this.valor1 = valor1;
		this.valor2 = valor2;
	}

	public String getComando() {
		return comando;
	}

	public void setComando(String comando) {
		this.comando = comando;
	}

	public String getValor1() {
		return valor1;
	}

	public void setValor1(String valor1) {
		this.valor1 = valor1;
	}

	public String getValor2() {
		return valor2;
	}

	public void setValor2(String valor2) {
		this.valor2 = valor2;
	}
}

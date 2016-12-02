package br.imd.ioac.memorias;

public class Palavra {
	int valor;
	public Palavra(int valor){
		//System.out.println("Criando palavra com valor: " + valor);
		this.valor = valor;
	}
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
}

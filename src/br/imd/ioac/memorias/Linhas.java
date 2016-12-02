package br.imd.ioac.memorias;

public class Linhas {
	private int num_bloco;
	private Bloco bloco; 
	public Linhas(){
		num_bloco = 99;
		bloco = null;
	}
	public int getNum_bloco() {
		return num_bloco;
	}
	public void setNum_bloco(int num_bloco) {
		this.num_bloco = num_bloco;
	}
	public Bloco getBloco() {
		return bloco;
	}
	public void setBloco(Bloco bloco) {
		this.bloco = bloco;
	}
	
}

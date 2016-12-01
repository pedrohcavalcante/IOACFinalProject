package br.imd.ioac.memorias;

public class MemoriaCache {
	private int tamanho;
	private String[][][][] print;
	public MemoriaCache(int tamanho){
		this.tamanho = tamanho;
	}
	public void print(){
		for (int i = 0; i < tamanho; i++){
			System.out.println(i);
			
		}
	}
}

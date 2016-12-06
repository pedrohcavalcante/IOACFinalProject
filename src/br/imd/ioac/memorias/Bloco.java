package br.imd.ioac.memorias;

import java.util.ArrayList;
import java.util.Random;

public class Bloco {
	Random gerador = new Random();
	static int cont;
	ArrayList<Palavra> palavras = new ArrayList<Palavra>();
	public Bloco(int tam_bloco){
		//System.out.println("criando bloco com tamanho " + tam_bloco);
		for (int i = 0; i < tam_bloco; i++){
			cont = cont + 7;
			palavras.add(new Palavra(cont));	
			cont++;
		}
	}
	public ArrayList<Palavra> getPalavras() {
		return palavras;
	}
	public void setPalavras(ArrayList<Palavra> palavras) {
		this.palavras = palavras;
	}
}

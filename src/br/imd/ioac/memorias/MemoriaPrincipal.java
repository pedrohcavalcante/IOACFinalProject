package br.imd.ioac.memorias;

import java.util.ArrayList;

public class MemoriaPrincipal {
	
	ArrayList<Bloco> blocos = new ArrayList<Bloco>();
	
	public MemoriaPrincipal(int tamanho, int tam_bloco) {
		/*System.out.println("Criando mem�ria principal de tamanho: " + tamanho + " com "
				+ "tamanho do bloco em " + tam_bloco);*/
		for(int i = 0; i < tamanho; i++){
			blocos.add(new Bloco(tam_bloco));
		}
	}
	public void print(){
		System.out.println("MEM�RIA PRINCIPAL");
		for (int i = 0; i < blocos.size(); i++){
			for (int j = 0; j < blocos.get(i).getPalavras().size(); j++){
				System.out.println(i + "-" + (i * 4 + j) + "-" + blocos.get(i).getPalavras().get(j).getValor());
			}
		}
	}
	
}

package br.imd.ioac.memorias;

import java.util.ArrayList;

public class MemoriaPrincipal {
	
	ArrayList<Bloco> blocos = new ArrayList<Bloco>();
	ArrayList<Linhas> linhas = new ArrayList<Linhas>();
	MemoriaCache mc;
	int tam_bloco;
	public MemoriaPrincipal(int tamanho, int tam_bloco, MemoriaCache mc) {
		this.mc = mc;
		this.tam_bloco = tam_bloco;
		/*System.out.println("Criando memoria principal de tamanho: " + tamanho + " com "
				+ "tamanho do bloco em " + tam_bloco);*/
		for(int i = 0; i < tamanho; i++){
			blocos.add(new Bloco(tam_bloco));
		}
	}
	public void print(){
		System.out.println("MEMORIA PRINCIPAL");
		for (int i = 0; i < blocos.size(); i++){
			for (int j = 0; j < blocos.get(i).getPalavras().size(); j++){
				System.out.println(i + "-" + (i * tam_bloco + j) + "-" + blocos.get(i).getPalavras().get(j).getValor());
			}
		}
	}
	
	public boolean search(int value){
		for (int i = 0; i < blocos.size(); i++){
			for (int j = 0; j < blocos.get(i).getPalavras().size(); j++){
				if (blocos.get(i).getPalavras().get(j).getValor() == value){
					System.out.println("oi, eh igual e encontrado em : " + i + "-" + (i * tam_bloco + j) + "-" + blocos.get(i).getPalavras().get(j).getValor());
					int position = (i % 4);
					mc.setLinhas(position, blocos);
				
					return true;
				}
			}
		}
		return false;
	}
	public ArrayList<Bloco> getBlocos() {
		return blocos;
	}
	public void setBlocos(ArrayList<Bloco> blocos) {
		this.blocos = blocos;
	}
	
}

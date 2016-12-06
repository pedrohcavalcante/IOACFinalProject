package br.imd.ioac.memorias;

import java.util.ArrayList;

public class MemoriaCache {
	
	ArrayList<Linhas> linhas = new ArrayList<Linhas>();
	int tam_bloco;
	public MemoriaCache(int tamanho, int tam_bloco){
		this.tam_bloco = tam_bloco;
		for (int i = 0; i < tamanho; i++){
			linhas.add(new Linhas());
		}
	}
	public void print(){
		System.out.println("MEMORIA CACHE");
		for(int i = 0; i < linhas.size(); i++){
			if (linhas.get(i).getBloco() == null){
				for (int j = 0; j < tam_bloco;j++){
					System.out.println(i + "-X-X-X");
				}
			}else{
				for (int j = 0; j < linhas.get(i).getBloco().getPalavras().size();j++){
					System.out.println(i + "-" + linhas.get(i).getNum_bloco() + "-"
							+ (linhas.get(i).getNum_bloco() * linhas.get(i).getBloco().getPalavras().size()+j) 
							+ "-" + linhas.get(i).getBloco().getPalavras().get(j).getValor());
				}
			}
			
		}
	}
	public boolean search(int value){
		for(int i = 0; i < linhas.size(); i++){
			if (linhas.get(i).getBloco() == null){
					return false;
			}else{
				for (int j = 0; j < linhas.get(i).getBloco().getPalavras().size(); j++){
					if ((linhas.get(i).getNum_bloco() * linhas.get(i).getBloco().getPalavras().size()+j == value)){
					return true;
				}
			}
			
		}
		}
		return false;
	}
	public ArrayList<Linhas> getLinhas() {
		return linhas;
	}
	public void setLinhas(int position, ArrayList<Bloco> bloc) {
		for (int i = position; i < tam_bloco; i++){
		
		}
		
	}
	
}

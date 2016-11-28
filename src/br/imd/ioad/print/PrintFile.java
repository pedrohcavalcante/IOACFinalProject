package br.imd.ioad.print;

import java.util.ArrayList;

public class PrintFile {
	private int bloco;
	private int numLinhas;
	private int numBlocos;
	private int map;
	private int numConjuntos;
	private int polSubs;
	private int polEscrita;
	
	public PrintFile(ArrayList<String> linhasArq){
		this.bloco = Integer.parseInt(linhasArq.get(0));
		this.numLinhas = Integer.parseInt(linhasArq.get(1));
		this.numBlocos = Integer.parseInt(linhasArq.get(2));
		this.map = Integer.parseInt(linhasArq.get(3));
		this.numConjuntos = Integer.parseInt(linhasArq.get(4));
		this.polSubs = Integer.parseInt(linhasArq.get(5));
		this.polEscrita = Integer.parseInt(linhasArq.get(6));
	}
	public PrintFile(ArrayList<String> linhasArq, boolean isEntrada){
		int size = linhasArq.size();
		for (int i = 0; i < size; i++){
			System.out.println(linhasArq.get(i));
		}
	}
	public int getBloco() {
		return bloco;
	}

	public void setBloco(int bloco) {
		this.bloco = bloco;
	}

	public int getNumLinhas() {
		return numLinhas;
	}

	public void setNumLinhas(int numLinhas) {
		this.numLinhas = numLinhas;
	}

	public int getNumBlocos() {
		return numBlocos;
	}

	public void setNumBlocos(int numBlocos) {
		this.numBlocos = numBlocos;
	}

	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public int getNumConjuntos() {
		return numConjuntos;
	}

	public void setNumConjuntos(int numConjuntos) {
		this.numConjuntos = numConjuntos;
	}

	public int getPolSubs() {
		return polSubs;
	}

	public void setPolSubs(int polSubs) {
		this.polSubs = polSubs;
	}

	public int getPolEscrita() {
		return polEscrita;
	}

	public void setPolEscrita(int polEscrita) {
		this.polEscrita = polEscrita;
	}
}

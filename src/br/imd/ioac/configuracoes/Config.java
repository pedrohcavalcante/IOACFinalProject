package br.imd.ioac.configuracoes;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.imd.ioac.memorias.MemoriaCache;
import br.imd.ioac.print.PrintFile;

public class Config {
	JFileChooser arqFile = new JFileChooser(".");
	JFileChooser entrada = new JFileChooser(".");
	Component parent;
	FileReader arq;
	BufferedReader arqRead;
	ArrayList<String> linhasArq = new ArrayList<String>();
	ArrayList<Comandos> entradas = new ArrayList<Comandos>();
	PrintFile printConfig, printEntrada;
	String linha;
	public Config() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		arqFile.setFileSelectionMode(JFileChooser.FILES_ONLY);	
		arqFile.showOpenDialog(parent);
		// Lendo arquivo de configuracao
		try{
			arq = new FileReader(arqFile.getSelectedFile());
			arqRead = new BufferedReader(arq);
			linha = arqRead.readLine();
		}catch (NullPointerException npx){
			System.out.println("Arquivo de configuracoes nao selecionado. Encerrando a aplicação");
			System.exit(0);
		}
		
		
		while (linha != null){
			linhasArq.add(linha);
			linha = arqRead.readLine();
		}
		arq.close();
		
		// Lendo arquivo de entrada de comandos
		printConfig = new PrintFile(linhasArq);
		entrada.setFileSelectionMode(JFileChooser.FILES_ONLY);
		entrada.showOpenDialog(parent);
		try{
			arq = new FileReader(entrada.getSelectedFile());
		}catch (NullPointerException npx){
			System.out.println("Arquivo de leitura nao selecionado. Encerrando a aplicação");
			System.exit(0);
		}
		arqRead = new BufferedReader(arq);
		linha = arqRead.readLine();
		  
		while (linha != null){
			String[] dados = linha.split(" ");
			if (dados[1].toUpperCase().equals("READ")){
				entradas.add(new Comandos(dados[1], dados[2], ""));
			}else if(dados[1].toUpperCase().equals("WRITE")){
				entradas.add(new Comandos(dados[1], dados[2], dados[3]));
			}else if(dados[1].toUpperCase().equals("SHOW")){
				entradas.add(new Comandos(dados[1], " ", " "));
			}
			linha = arqRead.readLine();
		}
		linha = arqRead.readLine();
	
		arq.close();
		printEntrada = new PrintFile(linhasArq);
		for (int i = 0; i < entradas.size(); i++){
			printEntrada = new PrintFile(entradas.get(i).getComando(), true);
			printEntrada = new PrintFile(entradas.get(i).getValor1(), true);
			printEntrada = new PrintFile(entradas.get(i).getValor2(), true);
			
		}
		MemoriaCache teste = new MemoriaCache(Integer.parseInt(linhasArq.get(1)));
		//printEntrada = new PrintFile(valores, true);
		
		System.out.println("Cada bloco contem " + printConfig.getBloco() + " palavras");
		System.out.println("A cache tem " + printConfig.getNumLinhas() + " linhas");
		System.out.println("A memoria principal tem " + printConfig.getNumBlocos() + " blocos");
		switch (printConfig.getMap()){
		case 1: 
			System.out.println("O mapeamento eh Direto");
			break;
		case 2: 
			System.out.println("O mapeamento eh Totalmente Associativo");
			break;
		case 3:
			System.out.println("O mapeamento eh Parcialmente Associativo");
			break;
		default:
				System.out.println("Mapeamento nao reconhecido");
				break;
		}
		// oi
		if (printConfig.getMap() == 2){
			System.out.println("Numero de Conjuntos " + printConfig.getNumConjuntos());
		}else{
			System.out.println("Numero de conjuntos desconsiderado por o mapeamento não é Parcialmente Associativo");
		}
		switch (printConfig.getPolSubs()){
		case 1:
			System.out.println("Politica de substituicao 1: Aleatoio" );
			break;
		case 2:
			System.out.println("Politica de substituicao 2: FIFO" );
			break;
		case 3:
			System.out.println("Politica de substituicao 3: LFU" );
			break;
		case 4: 
			System.out.println("substituicao 4: LRU" );
			break;
		default:
				System.out.println("substituicao desconhecida");
		}
		switch (printConfig.getPolEscrita()){
		case 1: 
			System.out.println("Politica de escrita 1: Write-back");
			break;
		case 2:
			System.out.println("Politica de escrita 2: Write-through");
			break;
		default: 
			System.out.println("Politica de escrita desconhecida");
		}
	}
}

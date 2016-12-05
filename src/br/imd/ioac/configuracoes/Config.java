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
import br.imd.ioac.memorias.MemoriaPrincipal;
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
	MemoriaPrincipal mp;
	MemoriaCache mc;
	int j = 0;
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
			System.out.println("Arquivo de leitura nao selecionado. Encerrando a aplicacao");
			System.exit(0);
		}
		arqRead = new BufferedReader(arq);
		linha = arqRead.readLine();
		  
		while (linha != null){
			String[] dados = linha.split(" ");
			if (dados[0].toUpperCase().equals("READ")){
				entradas.add(new Comandos(dados[0], dados[1], ""));
			}else if(dados[0].toUpperCase().equals("WRITE")){
				entradas.add(new Comandos(dados[0], dados[1], dados[2]));
			}else if(dados[0].toUpperCase().equals("SHOW")){
				entradas.add(new Comandos(dados[0], " ", " "));
			}
			linha = arqRead.readLine();
		}
		linha = arqRead.readLine();
		mp = new MemoriaPrincipal(printConfig.getNumBlocos(), printConfig.getBloco());
		mc = new MemoriaCache(printConfig.getNumLinhas(),printConfig.getBloco());
		arq.close();
		//printEntrada = new PrintFile(linhasArq);
		/*for (int i = 0; i < entradas.size(); i++){
			printEntrada = new PrintFile(entradas.get(i).getComando(), true);
			printEntrada = new PrintFile(entradas.get(i).getValor1(), true);
			printEntrada = new PrintFile(entradas.get(i).getValor2(), true);
			System.out.println("\n");
		}*/
		while(j != entradas.size()){
			if (entradas.get(j).getComando().toUpperCase().equals("READ")){
				System.out.println("Procurando por " + entradas.get(j).getValor1());
				if (mc.search(Integer.parseInt(entradas.get(j).getValor1()))){
					System.out.println("HIT");
				}else{
					System.out.println("MISS");
				}
			}else if(entradas.get(j).getComando().toUpperCase().equals("SHOW")){
				mc.print();
			}else if(entradas.get(j).getComando().toUpperCase().equals("WRITE")){
				
			}
			j++;
		}
		//MemoriaCache teste = new MemoriaCache(Integer.parseInt(linhasArq.get(1)));
		//printEntrada = new PrintFile(valores, true);
		
		
		
		
		
		
		// SESSAO DE CONTROLE DE DADOS PARA COMPARACAO
		System.out.println("=========================================");
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
			System.out.println("Politica de substituicao 1: Aleatorio" );
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

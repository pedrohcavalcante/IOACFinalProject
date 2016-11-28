package br.imd.ioac.configuracoes;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.imd.ioad.print.PrintFile;

public class Config {
	JFileChooser arqFile = new JFileChooser(".");
	JFileChooser entrada = new JFileChooser(".");
	Component parent;
	FileReader arq;
	BufferedReader arqRead;
	ArrayList<String> linhasArq = new ArrayList<String>();
	ArrayList<String> entradas = new ArrayList<String>();
	PrintFile printConfig, printEntrada;
	String linha;
	public Config() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException, IOException{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		arqFile.setFileSelectionMode(JFileChooser.FILES_ONLY);	
		arqFile.showOpenDialog(parent);
		// Lendo arquivo de configuração
		try{
			arq = new FileReader(arqFile.getSelectedFile());
			arqRead = new BufferedReader(arq);
			linha = arqRead.readLine();
		}catch (NullPointerException npx){
			System.out.println("Arquivo de configurações não selecionado. Encerrando a aplicação");
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
			System.out.println("Arquivo de leitura não selecionado. Encerrando a aplicação");
			System.exit(0);
		}
		arqRead = new BufferedReader(arq);
		linha = arqRead.readLine();
		while (linha != null){
			entradas.add(linha);
			linha = arqRead.readLine();
		}
		arq.close();
		printEntrada = new PrintFile(entradas, true);
		
		System.out.println("Cada bloco contem " + printConfig.getBloco() + " palavras");
		System.out.println("A cache tem " + printConfig.getNumLinhas() + " linhas");
		System.out.println("A memoria principal tem " + printConfig.getNumBlocos() + " blocos");
		switch (printConfig.getMap()){
		case 1: 
			System.out.println("O mapeamento é Direto");
			break;
		case 2: 
			System.out.println("O mapeamento é Totalmente Associativo");
			break;
		case 3:
			System.out.println("O mapeamento é Parcialmente Associativo");
			break;
		default:
				System.out.println("Mapeamento não reconhecido");
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
			System.out.println("Política de substituição 1: Aleatório" );
			break;
		case 2:
			System.out.println("Política de substituição 2: FIFO" );
			break;
		case 3:
			System.out.println("Política de substituição 3: LFU" );
			break;
		case 4: 
			System.out.println("Política de substituição 4: LRU" );
			break;
		default:
				System.out.println("Política de substituição desconhecida");
		}
		switch (printConfig.getPolEscrita()){
		case 1: 
			System.out.println("Política de escrita 1: Write-back");
			break;
		case 2:
			System.out.println("Política de escrita 2: Write-through");
			break;
		default: 
			System.out.println("Polítiac de substituição desconhecida");
		}
	}
}

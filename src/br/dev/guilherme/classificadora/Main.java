package br.dev.guilherme.classificadora;

import java.util.Scanner;

import br.dev.guilherme.classificadora.model.CalculoClasse;
import br.dev.guilherme.classificadora.model.CalculoDecimal;

public class Main {

	public static void main(String[] args) {
		
		System.out.print("Informe o ip voc� gostaria de calcular:");
		
		Scanner leitor = new Scanner(System.in);
		String ip = leitor.nextLine();
		
		System.out.print("Informe a m�scara que voc� gostaria de calcular:");
		String mascara = leitor.nextLine();
		
		CalculoClasse classeIP =  new CalculoClasse(); 
		classeIP.DescobrirClasse(ip);
		
		
		
		

	}

}

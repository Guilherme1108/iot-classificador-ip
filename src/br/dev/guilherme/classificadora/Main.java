package br.dev.guilherme.classificadora;

import java.util.Scanner;
import br.dev.guilherme.classificadora.model.*;
public class Main {

	public static void main(String[] args) {
		
		System.out.print("Informe o IP com CIDR que você gostaria de calcular (ex: 192.168./24):");
		
		Scanner leitor = new Scanner(System.in);
		String ip = leitor.nextLine();
		
		Ip classeIP =  new Ip(); 
		classeIP.DescobrirClasse(ip);
		classeIP.calcMaskEmDeciamal(ip);
		
		

	}

}

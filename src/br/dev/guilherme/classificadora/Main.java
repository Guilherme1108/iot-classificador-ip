package br.dev.guilherme.classificadora;

import java.util.Scanner;
import br.dev.guilherme.classificadora.model.*;
public class Main {

	public static void main(String[] args) {
		
        Scanner leitor = new Scanner(System.in);
        System.out.print("Informe o IP com CIDR que você gostaria de calcular \n(ex: 192.168.10.0/24): ");
        String entrada = leitor.nextLine();

        Ip classeIP = new Ip(entrada);
        classeIP.mostrarDados();
        
        leitor.close();
		
	}

}

package br.dev.guilherme.classificadora.model;

public class Ip {
	
	//atualmente esta recebendo o valor do main para testes
	public void DescobrirClasse(String ip) {
		String[] ipSeparado = ip.split("\\.");

		int primeiraCasa = Integer.parseInt(ipSeparado[0]);

		if (primeiraCasa >= 1 && primeiraCasa <= 127) {
			System.out.println("A classe desse Ip é A");
		} else if (primeiraCasa >= 128 && primeiraCasa <= 191) {
			System.out.println("A classe desse Ip é B");
		} else if (primeiraCasa >= 192 && primeiraCasa <= 223) {
			System.out.println("A classe desse Ip é C");
		}
		
		
	}
	
	//pegando o valor do cidr
	public void calcMaskEmDeciamal(String ip) {
		
		String[] maskSeparada = ip.split("/");
		
		
		
		
	}

}

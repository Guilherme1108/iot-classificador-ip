package br.dev.guilherme.classificadora.model;

public class Ip {
	
	private int cidr;
	private String classe;
	private String mascaraDecimal;
	private String mascaraBinario;
	private String endereco;
	private int IpsValidos;
	
	       //construtor
	public Ip(String enderecoCIDR) {
		String[] partes = enderecoCIDR.split("/"); // o .split aqui foi utilizado para separar a mascara do ip atraves da /
		this.endereco = partes[0]; // isso vai definir que o endereco ip é a primeira parte antes da /
        this.classe = calcClasse(this.endereco); // a classe vai receber o valor do endereço para realizar o cálculo
		this.cidr = Integer.parseInt(partes[1]); // define a o cidr como a outra parte depois da /
        this.mascaraBinario = calcMaskBinario(cidr); //faz o calcMaskBinario utilizar o valor do cidr para calcular e dar este vslor para o mascaraBinario
        this.mascaraDecimal = calcMaskDecimal(mascaraBinario); // o calcMaskDecimal vai utilizar a máscara em binario para calcular
        this.IpsValidos = calcQtdIPsValidos(cidr);
	}
	
                  // calculo da classe
    private String calcClasse(String endereco) {
        int primeiroOcteto = Integer.parseInt(endereco.split("\\.")[0]); // vai pegar o primeiro número antes do primeiro ponto

        // definindo a classe
        if (primeiroOcteto >= 0 && primeiroOcteto <= 127) return "A";  // o && é utilizado para que as 2 condições sejam verdadeiras
        else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) return "B"; // não aceitando numeros negativos e nem numeros que
        else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) return "C"; // passam o limite
        else if (primeiroOcteto >= 224 && primeiroOcteto <= 239) return "D";
        else return "E";
    }
    
                  //calculo da maascara para binario
	private String calcMaskBinario(int cidr) { //está pedindo um cidr como numero inteiro para calcular
		StringBuilder bin = new StringBuilder(); // utilizei o StringBuilder porque é melhor para montar String em loops
		for (int i = 0; i < 32; i++) { // cria um loop que se repete 32 vezes
			if (i < cidr) bin.append('1'); // (true) se o i for menor que o cidr adiciona 1
			else bin.append('0'); // (false) se o i for menor que o cidr adiciona 0
		}
		return bin.toString(); // irá converter o resultado do StringBuilder para uma String normal
	}
	
	              //calculo da mascara em decimal
	private String calcMaskDecimal(String mascaraBinario) {
		StringBuilder decimal = new StringBuilder(); //criando o StringBuilder decimal
		for (int i = 0; i < 32; i += 8) { //ele irá fazer um loop de 8 caracteres 4 vezes, indo de 0 a 32
			String octeto = mascaraBinario.substring(i, i + 8); //vai pegar a string e ir quebrando ela a cada 8 caracteres
			decimal.append(Integer.parseInt(octeto, 2)); // converte para decimal e adiciona ao StringBuilde. O 2 é usado para falar que o octeto
			if (i < 24) decimal.append("."); //verifica se o octeto é menor que 24, se for ele adiciona um ponto
		}
		return decimal.toString();
	}
	
	         //calculo de IPs válidos
	private int calcQtdIPsValidos(int cidr) {
		int ipsValidos = (int) Math.pow(2, 32 - cidr); // calculo do número de ips válidos. O (int) força o Math.pow retornar um resulto int, do que double que é o padrão dele
		return ipsValidos - 2; //exclui o IP de rede e Broadcast
	}
	
	
	public void mostrarDados() {
		System.out.println("Endereço: " + endereco + "/" + cidr);
		System.out.println("Classe: " + classe);
		System.out.println("Máscara em Binario: " + mascaraBinario);
		System.out.println("Máscara em Decimal:" + mascaraDecimal);
		System.out.println("IPs válidos: " + IpsValidos);
		
	}
	
	
	
	
}


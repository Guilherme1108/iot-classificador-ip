package br.dev.guilherme.classificadora.gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import br.dev.guilherme.classificadora.model.Ip;

public class TelaCalculadorIP {
	
    private JTextField enderecoIpCIDR;
    
    private JButton buttonCalcular;
    
    private JLabel labelInfo;
    private JLabel labelResultadoClasse;
    private JLabel labelResultadoMaskBin;
    private JLabel labelResultadoMaskDec;
    private JLabel labelResultadoQtd;
    private JLabel labelMensagemErro;
    
    // configura√ß√µes padr√£o da tela
    public void criarTelaCalculadoraIP() {
        JFrame tela = new JFrame();
        tela.setSize(460, 340);
        tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tela.setResizable(false);
        tela.setLayout(null);
        tela.setTitle("Calculadora de IP");
        
		// torna a tela como o local onde ir√° aparecer os dados
        Container container = tela.getContentPane();

        // criando e personalizando a mensagem principal em cima
        labelInfo = new JLabel("Informe o endere«o IP com CIDR:");
        labelInfo.setBounds(40, 20, 315, 30);
		Font FonteInfo = new Font(null, Font.BOLD, 20); // fonte para o titulo
		labelInfo.setFont(FonteInfo); // faz a mensagem do resultado utilizar a fonte
		
		// criando e escolhendo onde ser√° o local de escrever o endere√ßo
        enderecoIpCIDR = new JTextField();
        enderecoIpCIDR.setBounds(40, 55, 370, 30);
        
     // criando e personalizando o bot√£o de calcular
        buttonCalcular = new JButton();
        buttonCalcular.setText("Calcular"); // mensagem do bot√£o
        buttonCalcular.setBounds(150, 100, 140, 40); // lugar onde ele vai estar
        buttonCalcular.setForeground(new Color(255, 255, 255)); // cor do texto do bot√£o
        buttonCalcular.setBackground(new Color(100, 80, 120)); // define a cor de fundo

        // criando e personalizando o resultado da classe
        labelResultadoClasse = new JLabel();
        labelResultadoClasse.setText("Classe: ");
        labelResultadoClasse.setBounds(40, 180, 380, 25);
        labelResultadoClasse.setFont(new Font(null, Font.BOLD, 14));
        labelResultadoClasse.setVisible(true);

        // criando e personalizando o resultado da mascara em binario
        labelResultadoMaskBin = new JLabel();
        labelResultadoMaskBin.setText("M·scara Bin·ria: ");
        labelResultadoMaskBin.setBounds(40, 200, 380, 25);
        labelResultadoMaskBin.setFont(new Font(null, Font.BOLD, 14));
        labelResultadoMaskBin.setVisible(true);

        // criando e personalizando o resultado da mascara em decimal
        labelResultadoMaskDec = new JLabel();
        labelResultadoMaskDec.setText("M·scara Decimal: ");
        labelResultadoMaskDec.setBounds(40, 220, 380, 25);
        labelResultadoMaskDec.setFont(new Font(null, Font.BOLD, 14));
        labelResultadoMaskDec.setVisible(true);

        // criando e personalizando o resultado dos ips v√°lidos
        labelResultadoQtd = new JLabel();
        labelResultadoQtd.setText("IPs v·lidos: ");
        labelResultadoQtd.setBounds(40, 240, 380, 25);
        labelResultadoQtd.setFont(new Font("A", Font.BOLD, 14));
        labelResultadoQtd.setVisible(true);
        
        // criando e personalizando a mensagem de erro
        labelMensagemErro = new JLabel("Formato inv·lido! Ex: 10.0.0.1/24");
        labelMensagemErro.setForeground(Color.RED);
        Font mensagemErro = new Font(null, Font.BOLD, 18);
        labelMensagemErro.setFont(mensagemErro);
        labelMensagemErro.setBounds(80, 150, 300, 25);
        labelMensagemErro.setVisible(false);
		
		
		// Adicionando os componentes no painel de conte√∫do do JFrame (tela)
        container.setBackground(new Color(243, 240, 250)); //cor de fundo geral
		container.add(labelInfo);
		container.add(enderecoIpCIDR);
		container.add(buttonCalcular);
        container.add(labelResultadoClasse);
        container.add(labelResultadoMaskBin);
        container.add(labelResultadoMaskDec);
        container.add(labelResultadoQtd);
		container.add(labelMensagemErro);
		
		
		// adicionando a√ß√£o no bot√£o calcular quando ele for clicado
		buttonCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			try {
				String entrada = enderecoIpCIDR.getText();
				Ip ip = new Ip(); //objeto Ip criado
				ip.setEnderecoCIDR(entrada); //atribuindo valor ao Ip
				
                labelMensagemErro.setVisible(false); //faz a mensagem erro sumir
                
				//pega dados calculados a partir do IP e mostra
				labelResultadoClasse.setText("Classe: " + ip.getClasse());
                labelResultadoMaskBin.setText("M·scara Bin·ria: " + ip.getMascaraBinario());
                labelResultadoMaskDec.setText("M·scara Decimal: " + ip.getMascaraDecimal());
                labelResultadoQtd.setText("IPs v·lidos: " + ip.getIpsValidos());
				
			} catch (Exception ex) { //quando tiver um erro e entrar no catch ele ir√° tirar os resultados e mostrar a mensagem de erro
				labelResultadoClasse.setText("Classe: ??? ");
                labelResultadoMaskBin.setText("M·scara Bin·ria: ??? ");
                labelResultadoMaskDec.setText("M·scara Decimal: ??? ");
                labelResultadoQtd.setText("IPs v·lidos: ??? ");
		        
                labelMensagemErro.setVisible(true);
			}
				
			}
		});

     // o setVisible √© a ultima coisa que deve aparecer
		tela.setVisible(true);
    }
}

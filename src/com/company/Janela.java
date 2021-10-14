package com.company;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class Janela extends JFrame implements ActionListener {
    protected int resultado;
    protected String resultadoTexto;
    protected JTextField input, output;
    protected JButton converter;
    protected String texto;
    protected JPanel painel;
    protected JLabel header, footer;

    private int traduzirNumeralRomano(String texto) {
        int n = 0;
        int numeralDaDireita = 0;
        for (int i = texto.length() - 1; i >= 0; i--) {
            int valor = (int) traduzirNumeralRomano(texto.charAt(i));
            n += valor * Math.signum(valor + 0.5 - numeralDaDireita);
            numeralDaDireita = valor;
        }
        return n;
    }

    private double traduzirNumeralRomano(char caractere) {
        return Math.floor(Math.pow(10, "IXCM".indexOf(caractere))) + 5 * Math.floor(Math.pow(10, "VLD".indexOf(caractere)));
    }

    Janela(){
        // Criando objeto imagem
        ImageIcon icone = new ImageIcon("D:\\Programacao\\proj_roma\\src\\assets\\roman_icon.png");
        this.setIconImage(icone.getImage()); // Tornando objeto imagem o icone

        this.setBounds(0,0,800,600); //Definir tamanho da janela
        this.setResizable(false); // Proibir redimensionamento
        this.setTitle("Roman Converter"); //Nome da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para realmente fechar a aplicação
        this.getContentPane().setBackground(new Color(13, 17, 23)); //Colorindo background
        this.getContentPane().setLayout(null); //configurando o layout para nulo, assim podemos usar o metodo setBounds

        // Painel
        painel = new JPanel();
        painel.setBackground(new Color(13, 17, 23));
        painel.setBounds(0, 0, 800, 600); // metodo para escolher local do componente na tela
        getContentPane().add(painel);
        painel.setLayout(null);

        // Header da página
        header = new JLabel();
        header.setText("Conversor de números romanos");
        header.setForeground(Color.lightGray); // cor do texto
        header.setFont(new Font("Unto",Font.BOLD, 28));
        header.setVerticalAlignment(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setBounds(0,0,800,600);
        header.setBorder(new EmptyBorder(10,0,0,0)); // adicionando bordas
        painel.add(header);

        //Entrada de dados
        input = new JTextField();
        input.setBounds(270,155,250,50);
        input.setFont(new Font("Arial",Font.BOLD, 20));
        input.setBackground(Color.LIGHT_GRAY); // cor da caixa de texto
        input.addActionListener(this);
        painel.add(input);

        //Botão para converter dados
        converter = new JButton("Converter");
        converter.setBounds(345,255,100,50);
        converter.setFocusable(false); // tirar caixa pontilhada que ficava em volta da palavra dentro do botão
        painel.add(converter);
        converter.addActionListener(this);

        //Saida de dados
        output = new JTextField();
        output.setBounds(270,355,250,50);
        output.setFont(new Font("Arial",Font.BOLD, 20));
        output.setBackground(new Color(13, 17, 23));
        output.setEnabled(false);
        painel.add(output);

        //Footer
        footer = new JLabel();
        footer.setText("Feito por © Pedro Junqueira.");
        footer.setForeground(Color.lightGray); // cor do texto
        footer.setFont(new Font("Unto",Font.BOLD, 12));
        footer.setVerticalAlignment(JLabel.TOP);
        footer.setHorizontalAlignment(JLabel.CENTER);
        footer.setBounds(270, 540, 253, 16);
        painel.add(footer);

        //Tornando tudo visivel
        this.setVisible(true);
        header.setVisible(true);
        painel.setVisible(true);
        input.setVisible(true);
        converter.setVisible(true);
        output.setVisible(true);
        footer.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        boolean disjuntor = true;

        if (Objects.equals(e.getSource(), converter)) {
            texto = input.getText();
            texto = texto.toUpperCase();
        }

        for (int i = 0; i < texto.length(); i++) {

            if((texto.contains("IIII")) ||
                    (texto.contains("XXXX")) ||
                    (texto.contains("CCCC")) ||
                    (texto.contains("MMMM")) ||
                    (texto.contains("VV"))   ||
                    (texto.contains("LL"))   ||
                    (texto.contains("DD"))   ||
                    (texto.contains("IL"))   ||
                    (texto.contains("IC"))   ||
                    (texto.contains("ID"))   ||
                    (texto.contains("IM"))   ||
                    (texto.contains("XD"))   ||
                    (texto.contains("XM"))){
                JOptionPane.showMessageDialog(null,"Numero inválido, tente novamente!","Atenção",JOptionPane.WARNING_MESSAGE);
                disjuntor = false;
                break;
            }
            else if ((texto.charAt(i) == 'I') ||
                    (texto.charAt(i) == 'V') ||
                    (texto.charAt(i) == 'X') ||
                    (texto.charAt(i) == 'L') ||
                    (texto.charAt(i) == 'C') ||
                    (texto.charAt(i) == 'D') ||
                    (texto.charAt(i) == 'M')){
                System.out.println("caracter válido");
            }
            else{
                JOptionPane.showMessageDialog(null,"Numero inválido, tente novamente!","Atenção",JOptionPane.WARNING_MESSAGE);
                disjuntor = false;
                break;
            }
        }

        if (disjuntor){
        resultado = traduzirNumeralRomano(texto);
        resultadoTexto = Integer.toString(resultado);
        output.setText(resultadoTexto);
        }
    }
}

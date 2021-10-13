package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Janela extends JFrame implements ActionListener {

    JTextField input, output;
    JButton converter;


    Janela(){
        // Criando objeto imagem
        ImageIcon icone = new ImageIcon("D:\\Programacao\\proj_roma\\src\\assets\\roman_icon.png");
        this.setIconImage(icone.getImage()); // Tornando objeto imagem o icone

        this.setBounds(0,0,800,600); //Definir tamanho da janela
        this.setResizable(false); // Proibir redimensionamento
        this.setTitle("Roman Converter"); //Nome da janela
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Para realmente fechar a aplicação
        this.getContentPane().setBackground(new Color(13, 17, 23)); //Colorindo background
        this.getContentPane().setLayout(null);

        // Painel
        JPanel painel = new JPanel();
        painel.setBackground(new Color(13, 17, 23));
        painel.setBounds(0, 0, 800, 600);
        getContentPane().add(painel);
        painel.setLayout(null);


        // Header da página
        JLabel header = new JLabel();
        header.setText("Conversor de números romanos");
        header.setForeground(Color.lightGray); // cor do texto
        header.setFont(new Font("Unto",Font.BOLD, 25));
        header.setVerticalAlignment(JLabel.TOP);
        header.setHorizontalAlignment(JLabel.CENTER);
        header.setBounds(0,0,800,600);
        painel.add(header);


        //Entrada de dados
        JTextField input = new JTextField();
        input.setBounds(275,120,250,50);
        input.setFont(new Font("Arial",Font.BOLD, 20));
        input.setBackground(Color.LIGHT_GRAY);
        painel.add(input);

        //Botão para converter dados
        JButton converter = new JButton("Converter");
        converter.setBounds(350,220,100,50);
        converter.setFocusable(false);
        painel.add(converter);
        converter.addActionListener(this);

        //Saida de dados
        JTextField output = new JTextField();
        output.setBounds(275,320,250,50);
        output.setFont(new Font("Arial",Font.BOLD, 20));
        output.setBackground(Color.LIGHT_GRAY);
        painel.add(output);


        //Footer
        JLabel footer = new JLabel();
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
        if (e.getSource()==converter){
            System.out.println("work" + input.getText());
        }
    }
}

package classes;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface extends JFrame implements ActionListener {

    public Interface() {



        setSize(400, 600);
        setTitle("Calculadora");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel WindowHeight = new JLabel("Altura da Janela (m): ");
        WindowHeight.setBounds(65, 30, 130, 30);
        JTextField heightField = new JTextField();
        heightField.setBounds(225, 30, 100,30);

        JLabel timeInWindow = new JLabel("Tempo na janela (s): ");
        timeInWindow.setBounds(65, 65, 130, 30);
        JTextField windowTime= new JTextField();
        windowTime.setBounds(225, 65, 100,30);

        JLabel fallBackTime = new JLabel("Queda e volta(s): ");
        fallBackTime.setBounds(65, 100, 130, 30);
        JTextField fallBack= new JTextField();
        fallBack.setBounds(225, 100, 100,30);

        JButton reset = new JButton("Resetar");
        JButton calc = new JButton("Calcular");

        calc.setBounds(65, 140, 130, 30);
        reset.setBounds(225, 140, 100, 30);
        calc.setForeground(new Color(0, 0, 0));
        reset.setForeground(new Color(165, 12, 12));

        JPanel output = new JPanel();
        output.setBounds(65, 180, 260, 60);
        output.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
                "Resultado",
                TitledBorder.LEFT,
                TitledBorder.TOP
        ));
        output.setLayout(new GridBagLayout());
        JLabel result = new JLabel();
        result.setText("0,00m");
        result.setBounds(150, 200, 50, 40);
        result.setForeground(new Color(10, 90, 170));
        result.setFont(new Font("Arial", Font.BOLD, 20));

        String h = heightField.getText();
        String t1 = windowTime.getText();
        String t2 = fallBack.getText();

        add(WindowHeight);
        add(heightField);

        add(timeInWindow);
        add(windowTime);

        add(fallBackTime);
        add(fallBack);
        output.add(result);
        add(output);



        add(reset);
        add(calc);

        calc.addActionListener(this);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //CONTINUAR EM: validação de entrada: texto vazio ou letras e conversão dos inputs de String para double
    }
}
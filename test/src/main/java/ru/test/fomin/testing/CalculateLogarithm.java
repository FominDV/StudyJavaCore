package ru.test.fomin.testing;

import javax.swing.*;
import java.awt.*;
import static java.lang.Math.log;

public class CalculateLogarithm extends JFrame {

    private final JPanel PANEL_ONE = new JPanel(new GridLayout(2, 1));
    private final JPanel PANEL_TWO = new JPanel(new GridLayout(2, 1));
    private final int WIDTH = 400;
    private final int HEIGHT = 150;
    private final JButton BUTTON_CALCULATE = new JButton("CALCULATE");
    private final JLabel LABEL_BASE = new JLabel("Inter the base of the logarithm:");
    private final JLabel LABEL_NUMBER = new JLabel("Inter the number for calculating logarithm:");
    private final JLabel LABEL_RESULT = new JLabel(" ");
    private final JTextField FIELD_BASE = new JTextField();
    private final JTextField FIELD_NUMBER = new JTextField();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculateLogarithm());
    }

    public CalculateLogarithm() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("CALCULATION OF LOGARITHM");
        setResizable(false);
        BUTTON_CALCULATE.addActionListener(e -> {
            calculate();
        });
        LABEL_RESULT.setHorizontalAlignment(SwingConstants.CENTER);
        FIELD_NUMBER.setPreferredSize(new Dimension(100,50));
        FIELD_BASE.setPreferredSize(new Dimension(100,50));
        PANEL_ONE.add(LABEL_NUMBER);
        PANEL_TWO.add(FIELD_NUMBER);
        PANEL_ONE.add(LABEL_BASE);
        PANEL_TWO.add(FIELD_BASE);
        add(PANEL_ONE,BorderLayout.CENTER);
        add(PANEL_TWO,BorderLayout.EAST);
        add(LABEL_RESULT, BorderLayout.SOUTH);
        add(BUTTON_CALCULATE, BorderLayout.NORTH);
        setVisible(true);
    }

    private void calculate() {
        LABEL_RESULT.setText("incorrect data");
        double number = 0, base = 0, result;
        try {
            number = Double.parseDouble(FIELD_NUMBER.getText());
            base = Double.parseDouble(FIELD_BASE.getText());
        } catch (NumberFormatException e) {
            showErrorMessage("Fields should be filled by only numbers");
            return;
        }
        if(base==1){ showErrorMessage("The base of logarithm should not be equal one!");return;}
        if(base<=0){ showErrorMessage("The base of logarithm should be greater zero!");return;}
        if(number<=0) {showErrorMessage("The number of logarithm should be greater zero!");return;}
        result = log(number) / log(base);
        LABEL_RESULT.setText("Result of calculation of logarithm: " + result);
    }
    private void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}

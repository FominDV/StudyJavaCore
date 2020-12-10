package ru.test.fomin.testing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.lang.Thread.interrupted;
import static java.lang.Thread.sleep;

public class KitchenTimer extends JFrame implements ActionListener, Runnable {
    private final JPanel PANEL_TOP = new JPanel(new GridLayout(2, 3));
    private final JPanel PANEL_BOTTOM = new JPanel(new GridLayout(1, 1));
    private final JLabel LABEL_TIME_OUT = new JLabel();
    private final int WIDTH = 400;
    private final int HEIGHT = 150;
    private final JButton BUTTON_START = new JButton("START");
    private final JLabel LABEL_COOK = new JLabel("NAME OF COOK");
    private final JLabel LABEL_TIME = new JLabel("TIME IN SECONDS");
    private final JLabel LABEL_DISH = new JLabel("NAME OF DISH");
    private final JTextField FIELD_TIME = new JTextField("");
    private final JTextField FIELD_COOK = new JTextField("");
    private final JTextField FIELD_DISH = new JTextField("");
    private String message;
    private Thread thread;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new KitchenTimer());
    }

    public KitchenTimer() {
        SwingUtilities.invokeLater(() -> initialization());
    }

    private void initialization() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setLocationRelativeTo(null);
        setTitle("KITCHEN TIMER");
        setResizable(false);
        BUTTON_START.addActionListener(this);
        PANEL_TOP.add(LABEL_COOK);
        PANEL_TOP.add(LABEL_DISH);
        PANEL_TOP.add(LABEL_TIME);
        PANEL_TOP.add(FIELD_COOK);
        PANEL_TOP.add(FIELD_DISH);
        PANEL_TOP.add(FIELD_TIME);
        PANEL_BOTTOM.add(BUTTON_START);
        LABEL_TIME_OUT.setHorizontalAlignment(SwingConstants.CENTER);
        add(PANEL_TOP, BorderLayout.NORTH);
        add(LABEL_TIME_OUT, BorderLayout.CENTER);
        add(PANEL_BOTTOM, BorderLayout.SOUTH);
        setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if ((!isAllFieldsWasFilled()) || thread != null) return;
        thread = new Thread(this);
        thread.start();
    }

    private boolean isAllFieldsWasFilled() {
        if (FIELD_COOK.getText().equals("") || FIELD_DISH.getText().equals("") || FIELD_TIME.getText().equals("")) {
            showErrorMessage("All field should be filled!");
            return false;
        }
        return true;
    }

    @Override
    public void run() {
        int time=0;
        message = String.format("TIME OUT!!!   COOK: %s   DISH: %s", FIELD_COOK.getText(), FIELD_DISH.getText());
        try {
            time= Integer.parseInt(FIELD_TIME.getText()) * 1000;
        } catch (NumberFormatException e) {
            showErrorMessage("You should insert time in seconds!\n It is should be only integer number!");
        }
        int elapsedTime = 0;
        while (elapsedTime < time) {
            try {
                sleep(1000);
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
            elapsedTime += 1000;
            LABEL_TIME_OUT.setText((time - elapsedTime) / 1000 + " seconds left");
        }
        LABEL_TIME_OUT.setText(message);
        thread = null;
    }
    private void showErrorMessage(String message){
        JOptionPane.showMessageDialog(null, message, "ERROR", JOptionPane.ERROR_MESSAGE);
    }
}

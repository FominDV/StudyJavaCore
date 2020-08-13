package catchDrops;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends JFrame {

    private static GameWindow GW;

    public static void main(String[] args) {
        GW = new GameWindow();
        GW.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//close window
        GW.setLocation(200,100);//window appearance point
        GW.setSize(906, 478); //size of window
        GW.setResizable(false); //Forbidding window changes
        gameField GF = new gameField();
        GW.add(GF);
        GW.setVisible(true);//make it visible



    }

    private static void Repaint(Graphics g){
        g.fillOval(10,10,200,100);
        g.drawLine(10,110,210,210);

    }

    private static class gameField extends JPanel {
        @Override//Override a component from JPanel to our own component
        protected void paintComponent(Graphics g){
            super.paintComponent(g);  //draws Jpanel
            Repaint(g);

        }

    }
}

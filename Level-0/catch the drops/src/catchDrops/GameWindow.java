package catchDrops;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static Image game_over;
    private static Image background;
    private static Image drop;
    private static long time;
    private static GameWindow GW;
    private static float dropX = 200;
    private static float dropY = -100;
    private static float dropVY = 200;
    private static float dropVX = 130;

    public static void main(String[] args) throws IOException {
        background = ImageIO.read(GameWindow.class.getResourceAsStream("background.png"));
        game_over = ImageIO.read(GameWindow.class.getResourceAsStream("game_over.png"));
        drop = ImageIO.read(GameWindow.class.getResourceAsStream("drop.png"));
        GW = new GameWindow();
        GW.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);//close window
        GW.setLocation(200,100);//window appearance point
        GW.setSize(906, 478); //size of window
        GW.setResizable(false); //Forbidding window changes
        time = System.nanoTime();
        gameField GF = new gameField();
        GW.add(GF);
        GW.setVisible(true);//make it visible



    }

    private static void Repaint(Graphics g){
        long current_time = System.nanoTime();
        float delta_time = (current_time - time) * 0.000000001f;
        time = current_time;
        dropY += dropVY * delta_time;
        dropX += dropVX * delta_time;
        g.drawImage(background, 0,0,null);
        g.drawImage(drop,(int) dropX,(int) dropY,null);
        //g.drawImage(game_over, 280,120,null);

    }

    private static class gameField extends JPanel {
        @Override//Override a component from JPanel to our own component
        protected void paintComponent(Graphics g){
            super.paintComponent(g);  //draws Jpanel
            Repaint(g);
            repaint();

        }

    }
}

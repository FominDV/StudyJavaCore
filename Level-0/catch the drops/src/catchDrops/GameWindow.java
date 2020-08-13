package catchDrops;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class GameWindow extends JFrame {
    private static Image game_over;
    private static Image background;
    private static Image drop;
    private static long time;
    private static GameWindow GW;
    private static float dropX = 200;
    private static float dropY = -100;
    private static float dropVY = 150;
    private static float dropVX = 0;
    private  static int score;

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
        GF.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                float dropX2 = dropX + drop.getWidth(null);
                float dropY2 = dropY + drop.getHeight(null);
                boolean is_drop = x >= dropX && x <= dropX2 && y >= dropY && y <= dropY2;
                if(is_drop){
                    dropY = -100;
                    dropX = (int) (Math.random()*(GF.getWidth() - drop.getWidth(null)));
                    dropVY += 4;
                    score++;
                    if(dropVX < 0) dropVX *= (-1);
                    if(score > 10) dropVX += 8;
                    if(dropX > (GF.getWidth()/2)) dropVX *= (-1);
                    GW.setTitle("Score: " + score);
                }
            }
        });
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
        if(dropY>GW.getHeight()) g.drawImage(game_over, 280,120,null);

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


import javax.swing.*;
import javax.swing.plaf.basic.BasicGraphicsUtils;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
        import java.awt.event.MouseEvent;

import static sun.swing.SwingUtilities2.drawString;
import static sun.swing.SwingUtilities2.getGraphics2D;

public class BattleMap extends JPanel {

    JButton btn=new JButton("press");
    JPanel panel=new JPanel();
    public BattleMap() {

//        setTitle("Tic-tic-toe by Dmitriy Fomin");
//        setSize(200,200);
//        setLocationRelativeTo(null);
//        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        setResizable(false);
btn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        paintWin();
    }
});
add(btn,BorderLayout.WEST);

       setVisible(true);

    }

    public static void main(String[] args) {
        new BattleMap();

    }
     void paintWin(){
        btn.setVisible(false);
        Graphics g=this.getGraphics();
         ((Graphics2D)g).setStroke(new BasicStroke(5));
        // g.setColor(Color.RED);
         g.drawRect(0,0,150,150);
         g.drawString("qweqweqwe", 100, 100);

        //update(g);

    }
}
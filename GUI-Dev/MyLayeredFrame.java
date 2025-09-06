import javax.swing.*;
import java.awt.*;

// A Layered Pane allows you to stack components on top of each other
// this adds a 3D effect to the program
public class MyLayeredFrame extends JFrame {

    JLabel label1, label2, label3;

    MyLayeredFrame(){

        label1 = new JLabel();
        label1.setBackground(Color.GREEN);
        label1.setOpaque(true);
        label1.setBounds(50, 20, 100, 100);

        label2 = new JLabel();
        label2.setBackground(Color.BLUE);
        label2.setOpaque(true);
        label2.setBounds(60, 30, 100, 100);

        label3 = new JLabel();
        label3.setBackground(Color.RED);
        label3.setOpaque(true);
        label3.setBounds(70, 50, 100, 100);

        JLayeredPane pane = new JLayeredPane();
        pane.setBounds(0, 0, 400, 400);
        pane.add(label1, Integer.valueOf(0));
        pane.add(label2, Integer.valueOf(2));
        pane.add(label3, Integer.valueOf(1));

        this.setSize(400, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(pane);
        this.setVisible(true);
    }
}

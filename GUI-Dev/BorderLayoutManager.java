import javax.swing.*;
import java.awt.*;

public class BorderLayoutManager extends JFrame {

    JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JPanel panel5 = new JPanel();

    BorderLayoutManager(){

        //setting the color of the panels
        panel1.setBackground(Color.RED);
        panel2.setBackground(Color.GREEN);
        panel3.setBackground(Color.BLUE);
        panel4.setBackground(Color.magenta);
        panel5.setBackground(Color.yellow);

        //settings the preferred sizes of the panels
        panel1.setPreferredSize(new Dimension(100, 100));
        panel2.setPreferredSize(new Dimension(100, 100));
        panel3.setPreferredSize(new Dimension(100, 100));
        panel4.setPreferredSize(new Dimension(100, 100));
        panel5.setPreferredSize(new Dimension(100, 100));

        //configuring the main frame
        this.setSize(600, 600);
        this.setTitle("The border layout manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout(10, 10));
        this.add(panel1, BorderLayout.NORTH);
        this.add(panel2, BorderLayout.CENTER);
        this.add(panel3, BorderLayout.SOUTH);
        this.add(panel4, BorderLayout.EAST);
        this.add(panel5, BorderLayout.WEST);
    }
}

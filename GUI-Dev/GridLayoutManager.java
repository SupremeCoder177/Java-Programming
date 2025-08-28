import javax.swing.*;
import java.awt.*;

public class GridLayoutManager extends JFrame {


    GridLayoutManager(){
        this.setSize(500, 500);
        this.setTitle("Grid Layout Manager");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 3, 10, 10));

        this.add(new JButton("1"));
        this.add(new JButton("2"));
        this.add(new JButton("3"));
        this.add(new JButton("4"));
        this.add(new JButton("5"));
        this.add(new JButton("6"));
        this.add(new JButton("7"));
        this.add(new JButton("8"));
        this.add(new JButton("9"));

        this.setVisible(true);
    }
}

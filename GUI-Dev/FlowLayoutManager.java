import javax.swing.*;
import java.awt.*;

/*
The flow layout manager places the components in a line until it runs out of space and then goes onto the next row
 */

public class FlowLayoutManager extends JFrame {

    JButton button1 = new JButton();
    JButton button2 = new JButton();
    JButton button3 = new JButton();
    JButton button4 = new JButton();
    JButton button5 = new JButton();
    JButton button6 = new JButton();
    JButton button7 = new JButton();
    JButton button8 = new JButton();
    JButton button9 = new JButton();

    FlowLayoutManager(){

        button1.setText("Button 1");
        button2.setText("Button 2");
        button3.setText("Button 3");
        button4.setText("Button 4");
        button5.setText("Button 5");
        button6.setText("Button 6");
        button7.setText("Button 7");
        button8.setText("Button 8");
        button9.setText("Button 9");

        this.setSize(600, 600);
        this.setTitle("Flow layout");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(button5);
        this.add(button6);
        this.add(button7);
        this.add(button8);
        this.add(button9);

        this.setVisible(true);

    }
}

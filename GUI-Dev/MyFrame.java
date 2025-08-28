import org.w3c.dom.events.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    ImageIcon image1 = new ImageIcon("Images\\img2.png");
    JButton button = new JButton();
    JLabel label = new JLabel();


    MyFrame(){

        label.setBounds(0, 50, 300, 400);
        label.setVisible(true);
        label.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        label.setText("This is a label");
        label.setIcon(image1);

        button.setText("This is a button");
        button.setBounds(0, 0, 200, 50);
        button.setFont(new Font("Cascadia Mono", Font.PLAIN, 10));
        button.setForeground(Color.GREEN);
        button.setBackground(Color.BLACK);
        button.setBorder(BorderFactory.createLineBorder(Color.GREEN));
        button.setFocusable(false);
        button.addActionListener(this);

        this.setSize(500, 500);
        this.setTitle("A frame with a button");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.add(button);
        this.add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            System.out.println("The button was pressed");
        }
    }
}

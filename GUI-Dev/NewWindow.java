import javax.swing.*;
import java.awt.*;

public class NewWindow extends JFrame {

    JLabel label;

    NewWindow(){

        label = new JLabel("Hello from another window !");
        label.setFont(new Font("Helvetica", Font.BOLD, 15));
        label.setBounds(0, 0, 200, 30);

        this.setSize(400, 400);
        this.setTitle("New Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.add(label);
        this.setVisible(true);
    }
}

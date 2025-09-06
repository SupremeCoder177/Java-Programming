import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OpenAnotherWindow extends JFrame implements ActionListener {

    JButton button;

    OpenAnotherWindow(){
        button = new JButton("Click to open another window !");
        button.setFont(new Font("Cascadio Mono", Font.PLAIN, 10));
        button.setFocusable(false);
        button.setBounds(100, 100, 200, 25);
        button.addActionListener(this);

        this.setSize(400, 300);
        this.setTitle("Open another Window");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(null);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == button){
            this.dispose();
            new NewWindow();
        }
    }
}

package Games.Game1.Code;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setTitle("Game 1");
        frame.setVisible(true);

        GamePanel panel = new GamePanel();
        frame.add(panel);

        // System.out.println(System.getProperty("user.dir"));
        frame.setLocationRelativeTo(null);
        frame.pack();

        panel.run();

    }
}

package Games.Space_Cowboys.Code;

import Games.Space_Cowboys.Code.utils.GamePanel;

import javax.swing.*;

public class Main {

    public static void main(String[] args){

        // window configurations
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Space Cowboys");

        // adding the game panel
        GamePanel panel = new GamePanel();
        frame.add(panel);

        frame.setVisible(true);
        frame.pack();

        panel.startGame();

    }

}

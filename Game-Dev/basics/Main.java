package basics;

import javax.swing.*;

public class Main {

    public static void main(String[] args){
        // We are going to use the java swing library
        // for game dev in java, more specifically
        // 2D game dev in java

        // A JFrame is the window which appears on the screen
        JFrame frame = new JFrame();

        // default close operation decides what will happen when the user
        // will try to close the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // setting the window title
        frame.setTitle("Basics of Java Game-Dev");

        // setting window resizing to false will disable window resizing
        frame.setResizable(false);

        // creating a game panel
        GamePanel panel = new GamePanel();
        frame.add(panel);

        // makes sure the window size is equal to the panel size
        frame.pack();

        // usually the OS tries to offset new windows by another window
        // by setting it to null the frame will appear in a fixed place
        frame.setLocationRelativeTo(null);

        // you need to set the visibility to true in order to see the window
        frame.setVisible(true);
        panel.startGame();

    }
}

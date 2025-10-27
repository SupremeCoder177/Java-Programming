package Games.Space_Cowboys.Code.utils;

import Games.Space_Cowboys.Code.Entities.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    Settings settings = new Settings();
    private KeyHandler handler = new KeyHandler();
    private boolean gameRunning = true;
    private Player player;

    public GamePanel(){
        this.setPreferredSize(new Dimension(settings.WINDOW_WIDTH, settings.WINDOW_HEIGHT));
        this.addKeyListener(this.handler);
        this.setFocusable(true);
        this.player = new Player(100, 200);
    }

    public void startGame(){
        Thread gameThread = new Thread();
        gameThread.start();
    }

    @Override
    public void run(){
        while(true){

            long startTime = System.nanoTime();

            update();
            repaint();

            long endTime = System.nanoTime();

            if((endTime - startTime) < settings.FRAME_TIME){
                try{
                    Thread.sleep((settings.FRAME_TIME - (endTime - startTime)) / 10000000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public void update(){

    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.dispose();
    }

}

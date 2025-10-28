package Games.Space_Cowboys.Code.utils;

import Games.Space_Cowboys.Code.Entities.Player;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel{

    Settings settings = new Settings();
    private KeyHandler handler = new KeyHandler(this);
    private boolean gameRunning = true;
    private boolean newCode = false;
    private Player player;
    private int code = 0;

    public GamePanel(){
        this.setPreferredSize(new Dimension(settings.WINDOW_WIDTH, settings.WINDOW_HEIGHT));
        this.addKeyListener(this.handler);
        this.setFocusable(true);
        this.player = new Player(200, 200);
    }

    public void run(){
        while(true){

            long startTime = System.nanoTime();

            this.update();
            repaint();

            long endTime = System.nanoTime();

            if((endTime - startTime) < settings.FRAME_TIME){
                try{
                    Thread.sleep((settings.FRAME_TIME - (endTime - startTime)) / 1000000);
                } catch(InterruptedException e){
                    e.printStackTrace();
                }
            }

        }
    }

    public void update(){
        if(!this.newCode) this.code = 0;
        this.player.update(this.code);
        this.newCode = false;
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        if(this.gameRunning) {
            this.player.paint(g2);
        }

        g2.dispose();
    }

    public void setCode(int code) {
        this.code = code;
        this.newCode = true;
    }

}

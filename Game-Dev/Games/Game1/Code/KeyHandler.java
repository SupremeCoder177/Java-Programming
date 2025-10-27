package Games.Game1.Code;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private GamePanel panel;

    KeyHandler(GamePanel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_SPACE) {
            if(this.panel.getRunning()) this.panel.getPlayer().jump();
            else{
                this.panel.start();
            }
        }
        if(code == KeyEvent.VK_ESCAPE) this.panel.stop();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

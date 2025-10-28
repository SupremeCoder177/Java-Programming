package Games.Space_Cowboys.Code.utils;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private GamePanel panel;

    public KeyHandler(GamePanel panel){
        this.panel = panel;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        this.panel.setCode(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

package Main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    public boolean upPressed, downPressed, leftPressed, rightPressed;
    public boolean arrowUp, arrowDown, arrowLeft, arrowRight;

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
        if(code == KeyEvent.VK_W){
            upPressed = true;
        }
        if(code == KeyEvent.VK_S){
            downPressed = true;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = true;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = true;
        }
        if(code == KeyEvent.VK_UP){
            arrowUp = true;
        }
        if(code == KeyEvent.VK_DOWN){
            arrowDown = true;
        }
        if(code == KeyEvent.VK_LEFT){
            arrowLeft = true;
        }
        if(code == KeyEvent.VK_RIGHT){
            arrowRight = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            upPressed = false;
        }
        if(code == KeyEvent.VK_S){
            downPressed = false;
        }
        if(code == KeyEvent.VK_A){
            leftPressed = false;
        }
        if(code == KeyEvent.VK_D){
            rightPressed = false;
        }
        if(code == KeyEvent.VK_UP){
            arrowUp = false;
        }
        if(code == KeyEvent.VK_DOWN){
            arrowDown = false;
        }
        if(code == KeyEvent.VK_LEFT){
            arrowLeft = false;
        }
        if(code == KeyEvent.VK_RIGHT){
            arrowRight = false;
        }
    }
}

package Main;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    //Screen Settings
    final int originalTileSize = 16; // 16x16
    final int scale = 3;

    final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize* maxScreenRow;

    int FPS = 60;

    KeyHandler keyH = new KeyHandler();
    Thread gameThread;

    //set players position
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;

    //set player2 position
    int player2X = 110;
    int player2Y = 110;
    int player2Speed = 10;

    public GamePanel(){

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000/FPS;
        double nextDrawTime = System.nanoTime() + drawInterval;
        while(gameThread != null){

            update();

            repaint();

            try{
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }

                Thread.sleep((long)remainingTime);
                nextDrawTime += drawInterval;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(){
        if(keyH.upPressed == true){
            playerY -= playerSpeed;
        }else if(keyH.downPressed) {
            playerY += playerSpeed;
        }else if(keyH.leftPressed) {
            playerX -= playerSpeed;
        }else if(keyH.rightPressed) {
            playerX += playerSpeed;
        }

        if(keyH.arrowUp == true){
            player2Y -= player2Speed;
        }else if(keyH.arrowDown) {
            player2Y += player2Speed;
        }else if(keyH.arrowLeft) {
            player2X -= player2Speed;
        }else if(keyH.arrowRight) {
            player2X += player2Speed;
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(Color.white);
        g2.fillRect(playerX, playerY, tileSize, tileSize);

        g2.setColor(Color.red);
        g2.fillRect(player2X, player2Y, tileSize,tileSize);


        g2.dispose();//to save some memory

    }
}

package main;

import Entity.Player;
import object.SuperObject;
import tiles.TileManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {
    //Screen settings
    final int originalTileSize = 16;
    final int scale = 3;
    public final int tileSize = originalTileSize*scale;
   public final int maxScreenCol = 16;
   public final int maxScreenRow = 12;
   public final int screenHeight = tileSize*maxScreenRow;
    public final int screenWidth = tileSize*maxScreenCol;
    //world setting
    public final int maxWorldCol = 50;
    public final int maxWorldRow = 50;
    public final int worldWidth = tileSize*maxWorldCol;
    public final int worldHeight = tileSize*maxWorldRow;



    int FPS = 60;
    int playerX = 100;
    int playerY = 100;
    int playerSpeed = 4;
    Thread gameThread;
    public CollisionCheck ccheck  = new CollisionCheck(this);
    KeyHandler keyH = new KeyHandler();
    public Player player = new Player (this,keyH);

    public SuperObject obj[]= new SuperObject[10];
    public Asset aset = new Asset(this);
    TileManager tileM = new TileManager (this);

    public GamePanel ()
    {
        this.setPreferredSize(new Dimension (screenWidth,screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable (true);
        //to rcv key input
    }
    public void setupGame()
    {
        aset.setObject();
    }
    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();


    }
    @Override

    public void run()
    {
        double drawInterval = 1000000000/FPS;
        double delta = 0;
        long lastTime = System.nanoTime ();
        long currentTime;
        long timer = 0;
        int drawCount = 0;

        while(gameThread != null)
        {
            currentTime = System.nanoTime ();
            delta += (currentTime - lastTime)/drawInterval;
            timer += (currentTime - lastTime);
            lastTime = currentTime;
            if(delta >= 100)
            {
                update();
                repaint();
                delta--;
                drawCount++;
            }
            if(timer >= 1000000000)
            {
                System.out.println (drawCount);
                drawCount = 0;
                timer = 0;
            }

        }
    }


  /////////////////////////////
    public void update()
    {
        player.update();

    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        //TILE

        tileM.draw(g2);
        //object
        for(int i = 0; i < obj.length; i++)
        {
            if(obj[i] != null)
            {
                obj[i].draw(g2, this);
            }
        }
        //player
        player.draw(g2);

        g2.dispose();
        //player.draw2(g2);
       // g2.dispose();

        //dispose of this graphics context and release any system resources that it is using


    }

}







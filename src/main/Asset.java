package main;

import object.OBJ_Chest;
import object.OBJ_Door;
import object.OBJ_key;

public class Asset {
    GamePanel gp;
    public Asset ( GamePanel gp)
    {
        this.gp = gp;
    }
    public  void  setObject ( )
    {
        gp.obj[0] = new OBJ_key();
        gp.obj[0].worldX = 23*gp.tileSize;
        gp.obj[0].worldY = 7*gp.tileSize;

        gp.obj[1] = new OBJ_key();
        gp.obj[1].worldX = 23*gp.tileSize;
        gp.obj[1].worldY = 40*gp.tileSize;

        gp.obj[1] = new OBJ_key();
        gp.obj[1].worldX = 37*gp.tileSize;
        gp.obj[1].worldY = 7*gp.tileSize;

        gp.obj[2] = new OBJ_key();
        gp.obj[2].worldX = 10*gp.tileSize;
        gp.obj[2].worldY = 9*gp.tileSize;

        gp.obj[3] = new OBJ_Door ();
        gp.obj[3].worldX = 8*gp.tileSize;
        gp.obj[3].worldY = 28*gp.tileSize;

        gp.obj[4] = new OBJ_Door();
        gp.obj[4].worldX = 12*gp.tileSize;
        gp.obj[4].worldY = 22*gp.tileSize;

        gp.obj[5] = new OBJ_Door();
        gp.obj[5].worldX = 15*gp.tileSize;
        gp.obj[5].worldY = 17*gp.tileSize;

        gp.obj[6] = new OBJ_Chest();
        gp.obj[6].worldX = 10*gp.tileSize;
        gp.obj[6].worldY = 7*gp.tileSize;

        gp.obj[7] = new OBJ_Chest ();
        gp.obj[7].worldX = 9*gp.tileSize;
        gp.obj[7].worldY = 10*gp.tileSize;

        gp.obj[8] = new OBJ_Chest();
        gp.obj[8].worldX = 7*gp.tileSize;
        gp.obj[8].worldY = 20*gp.tileSize;
    }
}

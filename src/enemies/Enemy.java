package enemies;

import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;
import player.EnemiesShoot;

import java.util.ArrayList;

import java.awt.*;

public class Enemy extends GameObject {


    public ArrayList<Enemy> enemiesBullets = new ArrayList<>();
    EnemiesShoot enemiesShoot;

    public Enemy(int x, int y) {

        super(x, y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");

    }


    @Override
    public void run() {
        super.run();
        this.position.addUp(0, 5);
    }



    public void shoot() {

        enemiesShoot.shoot(this);
    }

}



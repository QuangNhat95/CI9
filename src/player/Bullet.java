package player;

import bases.*;
import enemies.Enemy;

import java.awt.*;
import java.util.ArrayList;

public class Bullet extends GameObject {


    public Bullet(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
          this.boxCollider= new BoxCollider(x,y,10,20);
    }

    @Override
    public void run() {
        super.run();
        move();
        hitEnemy();
    }

    private void hitEnemy() {
        Enemy enemy = GameObject.checkCollision(this.boxCollider);
        if (enemy != null) {
            System.out.println("hit");
            enemy.getHit();
            this.destroy();
        }
    }

    private void move() {

        this.position.addUp(0, -10);

    }
}

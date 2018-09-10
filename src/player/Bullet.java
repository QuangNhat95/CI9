package player;

import bases.*;
import enemies.Enemy;

public class Bullet extends GameObject {


    public Bullet(int x, int y) {
        super(x, y);
        this.renderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");
          this.boxCollider= new BoxCollider(x,y,10,20);
    }

    @Override
    public void run() {
        super.run();
        this.move();
        this.hitEnemy();
        deactivateIfNeeded();
    }

    private void deactivateIfNeeded() {
        if (this.position.y<0){
            this.isActive=false;

        }
    }

    private void hitEnemy() {
        Enemy enemy = GameObject.checkCollision(this.boxCollider,Enemy.class);
        if (enemy != null) {
            System.out.println("hit");
            enemy.getHit();
            this.destroy();
        }
    }

    private void move() {
        this.position.addUp(0, -20);

    }
}

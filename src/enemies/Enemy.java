package enemies;

import bases.*;
import player.EnemiesShoot;
import player.Player;

import java.awt.*;
import java.util.ArrayList;

public class Enemy extends GameObject {

    private EnemiesShoot enemiesShoot;

    public Enemy(int x, int y) {
        super(x, y);


        this.renderer = new Animation(
                ImageUtil.load("images/enemy/bacteria/bacteria1.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria2.png"),
                ImageUtil.load("images/enemy/bacteria/bacteria3.png")

        );

        enemiesShoot = new EnemiesShoot();
        this.boxCollider = new BoxCollider(x, y, 30, 30);
    }

    @Override
    public void run() {
        super.run();
        this.shoot();
        this.move();
        hitPlayer();
        deactivateIfNeeded();
    }

    public void shoot() {

        enemiesShoot.shoot(this);
    }

    public void move() {
        this.position.addUp(0, 3);

    }

    public void getHit() {
        this.destroy();
        EnemyExplosion enemyExplosion = new EnemyExplosion(
                (int) this.position.x,
                (int) this.position.y

        );
        GameObject.add(enemyExplosion);

    }

    private void hitPlayer() {
        Player player = GameObject.checkCollision(this.boxCollider, Player.class);
        if (player != null) {
            System.out.println("hitPlayer");
            player.getHit();
            this.destroy();
        }
    }
    private void deactivateIfNeeded() {
        if (this.position.y<0){
            this.isActive=false;

        }
    }

}



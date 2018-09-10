package enemies;

import bases.*;
import player.EnemiesShoot;
import player.Player;

import java.util.ArrayList;

import java.awt.*;

 public class Enemy extends GameObject {

    private  EnemiesShoot enemiesShoot;

    public Enemy(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/enemy/bacteria/bacteria1.png");
        enemiesShoot = new EnemiesShoot();
        this.boxCollider= new BoxCollider(x,y,30,30);
    }
    @Override
    public void run() {
        super.run();
        this.shoot();
        this.move();
        hitPlayer();
    }
    public void shoot() {

        enemiesShoot.shoot(this);
    }
    public void move(){
        this.position.addUp(0, 3);

    }


     public void getHit() {
         this.destroy();
     }

     private void hitPlayer() {
         Player player = GameObject.checkCollision(this.boxCollider,Player.class);
         if (player != null) {
             System.out.println("hitPlayer");
             player.getHit();
             this.destroy();
         }
     }
}



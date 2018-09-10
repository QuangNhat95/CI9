package player;

import java.awt.*;
import java.util.ArrayList;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import enemies.Enemy;

public class Player extends GameObject {

    private PlayerMove playerMove;
    private PlayerShoot playerShoot;

    public Player(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        this.boxCollider= new BoxCollider(x,y,64,80);


    }

    public void render(Graphics g) {
        imageRenderer.render(g, this.position);

    }

    public void run() {
        playerMove.run(position);
        this.shoot();
    }

    private void shoot() {

        playerShoot.run(this);
    }

    @Override
    public void getHit() {
        super.getHit();
       this.destroy();
       this.gameOver();
    }

    public void gameOver(){
        System.exit(0);
    }
}




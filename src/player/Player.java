package player;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;


public class Player extends GameObject {

    private PlayerMove playerMove;
    private PlayerShoot playerShoot;

    public Player(int x, int y) {
        super(x, y);
        this.renderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        this.boxCollider= new BoxCollider(x,y,64,80);

    }


    public void run() {
        super.run();
        playerMove.run(position);
        this.shoot();
    }

    private void shoot() {
        playerShoot.run(this);
    }


    public void getHit() {
       this.destroy();
       this.gameOver();
    }


}




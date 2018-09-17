package player;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;


public class Player extends GameObject {

    private PlayerMove playerMove;
    private PlayerShoot playerShoot;

    private  PlayerAnimator playerAnimater ;

    public Vector2D velocity;


    public Player(int x, int y) {
        super(x, y);

        this.velocity = new Vector2D();

        this.playerAnimater = new PlayerAnimator();

        this.renderer = this.playerAnimater;

        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();

        this.boxCollider= new BoxCollider(x,y,64,80);

    }


    public void run() {
        super.run();
        playerMove.run(position);

        this.shoot();
        this.animate();
    }

    private void animate() {

        this.playerAnimater.selectAnimation(this.playerMove.velocity);
    }

    private void shoot() {

        playerShoot.run(this);
    }


    public void getHit() {
        PlayerExplosion playerExplosion = new PlayerExplosion(
                (int) this.position.x,
                (int) this.position.y);
                 this.destroy();
        GameObject.add(playerExplosion);

        //this.gameOver();
    }




}




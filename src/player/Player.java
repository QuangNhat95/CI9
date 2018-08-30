package player;

import java.awt.*;
import java.util.ArrayList;

import bases.ImageRenderer;
import bases.Vector2D;

public class Player {
    PlayerMove playerMove;

    Vector2D position;
    ImageRenderer imageRenderer;

    boolean shootL;//shoot
    public ArrayList<Bullet> bullets;//shoot
    PlayerShoot playerShoot;

   public  Player(float x, float y) {
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        this.position = new Vector2D(x, y);

        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");

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


    int count = 0;
}




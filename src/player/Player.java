package player;

import java.awt.*;
import java.util.ArrayList;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;

public class Player extends GameObject {

    private PlayerMove playerMove;
    boolean shootL;//shoot
    private PlayerShoot playerShoot;

    public Player(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/player/MB-69/player1.png");
        playerMove = new PlayerMove();
        playerShoot = new PlayerShoot();
        // this.position = new Vector2D(x, y);


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


}




package enemies;

import bases.BoxCollider;
import bases.GameObject;
import bases.ImageRenderer;
import player.Player;

public class EnemiesBullet extends GameObject {


    public EnemiesBullet(int x, int y) {
        super(x, y);
        this.renderer = new ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
        this.boxCollider = new BoxCollider(x, y, 30, 28);

    }

    public void run() {
        super.run();
        this.move();
        hitPlayer();
    }



    private void hitPlayer() {
        Player player = GameObject.checkCollision(this.boxCollider,Player.class);
        if (player != null) {
            player.getHit();
            this.destroy();
            System.out.println("hitPlayer");

        }
    }
    void move() {
        super.run();
        this.position.addUp(0, 5);
    }
}

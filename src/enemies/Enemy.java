package enemies;

import bases.ImageUtil;
import bases.Vector2D;
import player.EnemiesShoot;

import java.util.ArrayList;

import java.awt.*;

public class Enemy {

    float x;
    float y;
    Image image;
    public ArrayList<Enemy> enemiesBullets = new ArrayList<>();
    EnemiesShoot enemiesShoot;
    public Vector2D position;

    public Enemy(float x, float y) {
        this.position = new Vector2D(x, y);
        image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");
        enemiesShoot = new EnemiesShoot();

    }


    public void run() {

        Vector2D velocity = new Vector2D();


        velocity.y += 2;
        this.position.addUp(velocity);

        System.out.println("down");

    }


    public void render(Graphics g) {


        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);

    }

    public void shoot() {

        enemiesShoot.run(this);
    }

}



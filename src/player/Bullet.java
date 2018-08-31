package player;

import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Bullet {
    float x;
    float y;
    Image image;
    Vector2D position;

    public Bullet(float x, float y) {
        this.position = new Vector2D(x, y);

        image = ImageUtil.load("images/bullet/player/mb69bullet1.png");
    }

    public void run() {
        Vector2D velocity = new Vector2D();
        velocity.y -= 10;
        this.position.addUp(velocity);

    }

    public void render(Graphics g) {
        g.drawImage(this.image, (int) this.position.x, (int) this.position.y, null);

    }
}

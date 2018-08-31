package player;

import bases.GameObject;
import bases.ImageRenderer;
import bases.ImageUtil;
import bases.Vector2D;

import java.awt.*;
import java.util.ArrayList;

public class Bullet extends GameObject {


    public Bullet(int x, int y) {
        super(x, y);
        this.imageRenderer = new ImageRenderer("images/bullet/player/mb69bullet1.png");

    }


    @Override
    public void run() {
        super.run();
        this.position.addUp(0, -10);
    }
}

package player;

import bases.FramCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerShoot {
    private boolean shootL ;
    FramCounter framCounter = new FramCounter(20);

    void run(Player player) {
        if (InputManager.instance.xPressed && !this.shootL) {
            //1.Try to recycle

            Bullet newBullet = GameObject.recycle((int) player.position.x, (int) player.position.y, Bullet.class );

            this.shootL = true;
        }

        if (shootL) {
            framCounter.run();
            if (framCounter.expired) {
                shootL = false;
                framCounter.reset();
            }

        }

    }
}
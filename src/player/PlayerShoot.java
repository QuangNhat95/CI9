package player;

import bases.FramCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

import java.awt.*;

public class PlayerShoot {
    private boolean shootL=false;
    FramCounter framCounter = new FramCounter(15);

    void run(Player player) {
        if (InputManager.instance.xPressed && !this.shootL) {
            Vector2D vector2D = player.position.subtract(0, 50);
            System.out.println("shoot");

            Bullet bullet = new Bullet((int) vector2D.x, (int) vector2D.y);
            GameObject.add(bullet);
            this.shootL = true;
        }
        if (shootL) {
            framCounter.run();
            System.out.println("run");
            if (framCounter.expired) {
                shootL = false;
                framCounter.reset();
                System.out.println("exprired");

            }

        }

    }

}

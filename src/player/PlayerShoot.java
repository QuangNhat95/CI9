package player;
import bases.FramCounter;
import inputs.InputManager;

public class PlayerShoot {
    boolean shootL;
    FramCounter framCounter = new FramCounter(10);

    void run(Player player) {
        if (InputManager.instance.xPressed && !this.shootL) {
             Bullet bullet = new Bullet((int) player.position.x, (int) player.position.y);
            player.bullets.add(bullet);
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

package player;

import bases.FramCounter;
import bases.GameObject;
import enemies.Enemy;
import inputs.InputManager;

public class EnemiesShoot {
    public  boolean shootL;
    FramCounter framCounter = new FramCounter(10);
   public void shoot (Enemy enemy) {
        if (InputManager.instance.xPressed && !this.shootL) {
            Enemy enemy1 = new Enemy((int) enemy.position.x, (int) enemy.position.y);
            enemy.enemiesBullets.add(enemy1);
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

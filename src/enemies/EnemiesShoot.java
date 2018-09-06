package player;

import bases.FramCounter;
import bases.GameObject;
import enemies.EnemiesBullet;
import enemies.Enemy;
import inputs.InputManager;

public class EnemiesShoot {
    public boolean shootL;
    FramCounter framCounter = new FramCounter(50);

    public void shoot(Enemy enemy) {

        if ( !this.shootL) {
           EnemiesBullet enemy1 = new EnemiesBullet((int) enemy.position.x, (int) enemy.position.y);
            GameObject.add(enemy1);
            this.shootL = true;

            if (shootL) {
                framCounter.run();
                if (framCounter.expired) {
                    shootL = false;
                    framCounter.reset();

                }
            }
        }
    }
}
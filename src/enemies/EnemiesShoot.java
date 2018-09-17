package player;

import bases.FramCounter;
import bases.GameObject;
import enemies.EnemiesBullet;
import enemies.Enemy;

public class EnemiesShoot {
    public boolean shootL;
    FramCounter framCounter = new FramCounter(50);

    public void shoot(Enemy enemy) {

        if ( !this.shootL) {
           EnemiesBullet enemybullet = GameObject.recycle((int) enemy.position.x, (int) enemy.position.y,EnemiesBullet.class);
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
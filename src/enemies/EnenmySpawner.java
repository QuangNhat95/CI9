package enemies;

import bases.FramCounter;
import bases.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class EnenmySpawner extends GameObject {
FramCounter framCounter =new FramCounter(30);
ArrayList<Enemy> enemies;
    Random random;

    public EnenmySpawner(int x, int y) {

        super(x, y);
        random = new Random();
        enemies = new ArrayList<>();
    }
      public void run(){
        framCounter.run();
          if (framCounter.expired) {
              int postX1 = random.nextInt(700);
              Enemy enemy1 = new Enemy(postX1, 0);
              GameObject.add(enemy1);
              framCounter.reset();
          }
      }

}

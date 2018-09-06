package blood;

import bases.FramCounter;
import bases.GameObject;

import java.util.ArrayList;
import java.util.Random;

public class BloodSpawner extends GameObject {
    FramCounter framCounter =new FramCounter(10);
    ArrayList<Blood> bloodArrayList;
    Random random;

    public BloodSpawner(int x, int y) {

        super(x, y);
        random = new Random();
        bloodArrayList = new ArrayList<>();
    }
    public void run(){
        framCounter.run();
        if (framCounter.expired) {
            int postX1 = random.nextInt(1000);
           int postY1 = random.nextInt(1000);
            Blood blood1 = new Blood(postX1, postY1);
            GameObject.add(blood1);
            framCounter.reset();
        }
    }

}

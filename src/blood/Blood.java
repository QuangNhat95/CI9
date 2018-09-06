package blood;

import bases.FramCounter;
import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;
import enemies.Enemy;

import java.awt.*;
import java.util.Random;

public class Blood extends GameObject {
    FramCounter framCounter =new FramCounter(60);
    Random random;
    public Blood(int x, int y){
        super(x, y);

        this.imageRenderer = new ImageRenderer("images/blood cells/blood-cell1.png");
        random = new Random();
    }

    public void run(){
        this.move();
        super.run();

    }
    public void move(){
        this.position.subtract(600,600);
        this.position.addUp(2,2);


    }


}

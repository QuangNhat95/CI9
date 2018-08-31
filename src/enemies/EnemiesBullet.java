package enemies;

import bases.GameObject;
import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class EnemiesBullet extends GameObject {


    public EnemiesBullet(int x,int y){
        super(x,y);
        this.imageRenderer = new  ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
    }

    public void run()
    {
        this.move();
    }

    void move(){
       super.run();
       this.position.addUp(0,5);
    }
}

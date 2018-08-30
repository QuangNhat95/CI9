package enemies;

import bases.ImageRenderer;
import bases.Vector2D;

import java.awt.*;

public class EnemiesBullet {
    Vector2D position;
    int count=0;
    ImageRenderer imageRenderer;
    EnemiesBullet(int x,int y){
        this.position = new Vector2D(x,y);
        this.imageRenderer = new  ImageRenderer("images/bullet/enemy/enemy2_bullet1.png");
    }
    public void render(Graphics g){
        this.imageRenderer.render(g,position);
    }
    public void run(){
        this.move();
    }
    void move(){
        Vector2D velocity = new Vector2D();
        velocity.y+=5;
        this.position.addUp(velocity);
    }
}

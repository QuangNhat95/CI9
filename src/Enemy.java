import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Enemy {

    float x;
    float y;
    Image image;

    Vector2D position;

    Enemy(float x, float y) {
        this.position = new Vector2D(x, y);
        image = ImageUtil.load("images/enemy/bacteria/bacteria1.png");


    }


    void run() {

        Vector2D velocity = new Vector2D();


        velocity.y += 2;
        this.position.addUp(velocity);

        System.out.println("down");

    }


    void render(Graphics g) {


        g.drawImage(this.image, (int)this.position.x, (int) this.position.y, null);

    }


}



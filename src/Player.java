import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class Player {

    Vector2D position ;
    Image imagePlayer;
    InputManager inputManager;
    boolean shootL;
    ArrayList<Bullet>bullets;

    Player(float x, float y) {
        this.position= new Vector2D(x,y);

        imagePlayer = ImageUtil.load("images/player/MB-69/player1.png");
    }

    void render(Graphics g) {
        g.drawImage(this.imagePlayer, (int)this.position.x, (int)this.position.y, null);

    }

    void run() {
        this.move();
        this.shoot();

    }

    private void shoot() {
        for (Bullet b1 : bullets) {
            b1.run();
        }
        if (this.inputManager.xPressed&&!this.shootL){
            Bullet bullet = new Bullet((int)this.position.x,(int)this.position.y);
            this.bullets.add(bullet);
            this.shootL=true;

        }
        if (shootL) {
            count++;
            if (count > 15) {
                shootL = false;
                count = 0;
            }

        }
    }

    void move(){
        Vector2D velocity = new Vector2D();

        if (inputManager.rightPressed) {
            velocity.x+=5;
            System.out.println("right");
        }
        if (inputManager.leftPressed) {
            velocity.x -= 5;
            System.out.println("left");

        }
        if (inputManager.upPressed) {
            velocity.y -= 5;

        }
        if (inputManager.downPressed) {
            velocity.y+= 5;

        }
        this.position.addUp(velocity);

    }


  /*void shootLock(ArrayList<Bullet> bullets) {
        for (Bullet b1 : bullets) {
            b1.run();
        }
        if (inputManager.xPressed && !shootLock) {
            Bullet newB = new Bullet((int)this.position.x, (int)this.position.y);
            bullets.add(newB);
            shootLock = true;
        }
        if (shootLock) {
            count++;
            if (count > 15) {
                shootLock = false;
                count = 0;
            }

        }
*/




    boolean shootLock = false;
    int count = 0;
}




import java.awt.*;
import java.util.ArrayList;

public class Player {
    int x;
    int y;

    Image image;
    InputManager inputManager;

    Player(int x, int y) {

        this.x = x;
        this.y = y;


        image = ImageUtil.load("images/player/MB-69/DSC_2493.png");

    }

    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);

    }

    void run() {
        if (inputManager.rightPressed) {
            this.x += 5;

        }
        if (inputManager.leftPressed) {
            this.x -= 5;

        }
        if (inputManager.upPressed) {
            this.y -= 5;

        }
        if (inputManager.downPressed) {
            this.y += 5;

        }


    }
    void shootLock(ArrayList<Bullet> bullets){

        for (Bullet b1 : bullets) {
            b1.run();
        }
        if (inputManager.xPressed && !shootLock) {
            Bullet newB = new Bullet(this.x, this.y);
            bullets.add(newB);
            shootLock = true;
        }
        if (shootLock) {
            count++;
            if (count > 30) {
                shootLock = false;
                count = 0;
            }
        }



    }
    boolean shootLock = false;
    boolean enemyDisable = false;
    int count;
    Player player;
}



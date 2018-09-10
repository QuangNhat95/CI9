package player;

import bases.FramCounter;
import bases.GameObject;
import bases.Vector2D;
import inputs.InputManager;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerShoot {
    private boolean shootL=false;
    FramCounter framCounter = new FramCounter(20);

    void run(Player player) {
        if (InputManager.instance.xPressed && !this.shootL) {
            Vector2D vector2D = player.position.subtract(0, 50);
            System.out.println("shoot");
              //1.Try to recycle

            Bullet newBullet = GameObject.recycle();
            if (newBullet ==null){

                //2.if can recycle fails , creat new

                newBullet = new Bullet((int) vector2D.x, (int) vector2D.y);
                GameObject.add(newBullet);

            }else{
                newBullet.isActive=true;
                newBullet.position.x=vector2D.x;
                newBullet.position.y=vector2D.y;
            }


            this.shootL = true;
        }
        if (shootL) {
            framCounter.run();
            System.out.println("run");
            if (framCounter.expired) {
                shootL = false;
                framCounter.reset();
                System.out.println("exprired");

            }

        }

    }

}

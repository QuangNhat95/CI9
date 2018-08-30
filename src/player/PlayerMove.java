package player;

import bases.Vector2D;
import inputs.InputManager;

public class PlayerMove {
    Vector2D position;
    Player player;


    void run(Vector2D position) {
        Vector2D velocity = new Vector2D();

        if (InputManager.instance.rightPressed) {
            velocity.x += 5;
            System.out.println("right");
        }
        if (InputManager.instance.leftPressed) {
            velocity.x -= 5;
            System.out.println("left");

        }
        if (InputManager.instance.upPressed) {
            velocity.y -= 5;

        }
        if (InputManager.instance.downPressed) {
            velocity.y += 5;

        }
        position.addUp(velocity);
    }

}

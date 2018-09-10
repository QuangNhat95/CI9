package player;

import bases.GameObject;
import bases.ImageRenderer;

public class Player2 extends GameObject {
    private PlayerMove playerMove;

    public Player2(int x, int y) {

        super(x, y);
        this.renderer = new ImageRenderer("images/player/MB-70/player1.png");
        //playerMove = new PlayerMove();
    }

    public void run() {
       // playerMove.run(position);

    }
}

package games;

import bases.GameObject;
import bases.ImageRenderer;

public class Background extends GameObject {
    public Background(int x, int y) {
        super(x,y);
        this.renderer = new ImageRenderer("images/background/background.png");


    }
}

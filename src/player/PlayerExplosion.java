package player;

import bases.Animation;
import bases.GameObject;
import bases.ImageUtil;

public class PlayerExplosion extends GameObject {
    public PlayerExplosion(int x, int y) {
        super(x, y);
        this.renderer = new Animation(3, true,
                ImageUtil.load("images/bullet/player/pe/pe1.png"),
                ImageUtil.load("images/bullet/player/pe/pe2.png"),
                ImageUtil.load("images/bullet/player/pe/pe3.png"),
                ImageUtil.load("images/bullet/player/pe/pe4.png"),
                ImageUtil.load("images/bullet/player/pe/pe5.png"),
                ImageUtil.load("images/bullet/player/pe/pe6.png"),
                ImageUtil.load("images/bullet/player/pe/pe7.png"),
                ImageUtil.load("images/bullet/player/pe/pe8.png"),
                ImageUtil.load("images/bullet/player/pe/pe9.png"),
                ImageUtil.load("images/bullet/player/pe/pe10.png"),
                ImageUtil.load("images/bullet/player/pe/pe11.png"),
                ImageUtil.load("images/bullet/player/pe/pe12.png"),
                ImageUtil.load("images/bullet/player/pe/pe13.png"),
                ImageUtil.load("images/bullet/player/pe/pe14.png"),
                ImageUtil.load("images/bullet/player/pe/pe15.png"),
                ImageUtil.load("images/bullet/player/pe/pe16.png")
        );
    }
    @Override
    public void run() {
        super.run();
        Animation animation = (Animation) this.renderer;
        if (animation.finished) {
            this.destroy();
        }
    }

}

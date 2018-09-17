package player;

import bases.Animation;
import bases.ImageUtil;
import bases.Renderer;
import bases.Vector2D;

import java.awt.*;

public class PlayerAnimator extends Renderer {
    private Animation currentAnimation;
    private Animation leftAnimation;
    private Animation rightAnimation;
    private Animation straightAnimation;

    public PlayerAnimator() {
        straightAnimation = new Animation(10, false,
                ImageUtil.load("images/player/MB-69/player1.png"),
                ImageUtil.load("images/player/MB-69/player2.png"),
                ImageUtil.load("images/player/MB-69/player3.png"),
                ImageUtil.load("images/player/MB-69/player4.png")

                );
        leftAnimation = new Animation(10, false,
                ImageUtil.load("images/player/MB-69/player_left1.png"),
                ImageUtil.load("images/player/MB-69/player_left2.png"),
                ImageUtil.load("images/player/MB-69/player_left3.png"),
                ImageUtil.load("images/player/MB-69/player_left4.png")
        );
        rightAnimation = new Animation(10, false,
                ImageUtil.load("images/player/MB-69/player_right1.png"),
                ImageUtil.load("images/player/MB-69/player_right2.png"),
                ImageUtil.load("images/player/MB-69/player_right3.png"),
                ImageUtil.load("images/player/MB-69/player_right4.png")
                );
        this.currentAnimation= this.straightAnimation;
    }

    @Override
    public void render(Graphics g, Vector2D position) {
        this.currentAnimation.render(g, position);
    }

    public void selectAnimation(Vector2D playerVelocity) {
        if (playerVelocity.x < 0) {
            this.currentAnimation = this.leftAnimation;

        } else if (playerVelocity.x > 0) {
            this.currentAnimation = this.rightAnimation;
        } else if (playerVelocity.x == 0) {
            this.currentAnimation = this.straightAnimation;
        }
    }
}

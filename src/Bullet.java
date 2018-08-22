import java.awt.*;

public class Bullet {
    int x;
    int y;

    Image image;

    Bullet(int x, int y) {

        this.x = x;
        this.y = y;

        image = ImageUtil.load("images/bullet/player/mb69bullet1.png");

    }

    public void render(Graphics g) {
        g.drawImage(this.image, this.x, this.y, null);

    }

    void run() {
        this.y -= 10;

    }
}

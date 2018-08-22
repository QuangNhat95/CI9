import java.awt.*;

public class Enemy2 {
    int x;
    int y;
    //Image image1;
    Image image2;

    Enemy2(int x, int y) {

        this.x = x;
        this.y = y;


       // this.image1 = ImageUtil.load("images/player/MB-69/DSC_7393.png");
        this.image2 = ImageUtil.load("images/player/MB-69/DSC_7513.png");

    }

    public void render(Graphics g) {
      //  g.drawImage(this.image1, this.x, this.y, null);
        g.drawImage(this.image2, this.x, this.y, null);


    }

    public void run() {
        this.y += 3;
    }
}

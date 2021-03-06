package bases;

import java.awt.*;

public class BoxCollider extends GameObject {
    private int width;
    private int height;

    public BoxCollider(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    private float top() {

        return this.position.y - this.height / 2;
    }

    private float bot() {

        return this.position.y + this.height / 2;

    }

    private float left() {

        return this.position.x - width / 2;
    }

    private float right() {

        return this.position.x + width / 2;
    }

    public boolean collideWith(BoxCollider other) {

        boolean xOtherlap = this.left() <= other.right() &&
                other.left() <= this.right();
        boolean yOtherlap = this.top() <= other.bot() &&
                other.top() <= this.bot();
        return xOtherlap && yOtherlap;

    }

//    @Override
//    public void render(Graphics g) {
//        super.render(g);
//        g.drawRect((int)this.left(),(int)this.top(), this.width,this.height);
//    }
}

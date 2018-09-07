package bases;

public class BoxCollider extends GameObject {
    private int width;
    private int height;

    public BoxCollider(int x, int y, int width, int height) {

        super(x, y);
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
}

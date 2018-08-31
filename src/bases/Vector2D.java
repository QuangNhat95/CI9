package bases;

public class Vector2D {

    public float x;
    public float y;


    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    Vector2D add(float x, float y) {

        return new Vector2D(this.x + x, this.y + y);
    }

    Vector2D add(Vector2D other) {

        return this.add(other.x, other.y);
    }


    public void addUp(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void addUp(Vector2D other) {

        this.addUp(other.x, other.y);
    }


    void subtractBy(float x, float y) {
        this.x -= x;
        this.y -= y;

    }

    void subtractBy(Vector2D other) {

        this.subtractBy(other.x, other.y);
    }


    public Vector2D subtract(float x, float y) {
        return new Vector2D(this.x - x, this.y - y);


    }

    Vector2D subtract(Vector2D other) {

        return this.subtract(other.x, other.y);
    }

    void scaleBy(float m) {

        this.x *= m;
        this.y *= m;

    }

    Vector2D scale(float m) {

        return new Vector2D(this.x * m, this.y * m);
    }

    float lengh() {
        return (float) Math.sqrt(x * x + y * y);

    }

    Vector2D normalize() {
        float lengh = this.lengh();
        return new Vector2D(this.x / lengh, this.y / lengh);

    }


    void print() {
        System.out.println(this.x + "," + this.y);
    }

    public static void main(String[] args) {
        Vector2D v1 = new Vector2D(2, 3);
        v1.addUp(5, 7);
        v1.print();
        Vector2D v2 = new Vector2D(2, 3);
        Vector2D v3 = v2.add(5, 7);
        v3.print();
        Vector2D v4 = new Vector2D(2, 4);
        v4 = v1.add(3, 4);
        v4.print();
        Vector2D v = new Vector2D(6, 9);
        v.print();
        Vector2D v6 = v1.subtract(v2);
        v1.scaleBy(3);
        assert true;
    }
}

package bases;

import java.awt.*;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;

    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newgameOject=new ArrayList<>();
    public static void add(GameObject g) {
        newgameOject.add(g);

    }

    public static void runAll() {
        for (GameObject g : gameObjects) {
            g.run();
        }
        gameObjects.addAll(newgameOject);
        newgameOject.clear();
    }

    public static void renderAll(Graphics g) {
        for (GameObject go : gameObjects) {
            go.render(g);

        }
    }

    public GameObject(int x, int y) {

        this.position = new Vector2D(x, y);
        this.imageRenderer = null; //chua xac dinh//not yet specified
    }

    public void render(Graphics g) {
        if (this.imageRenderer != null) {
            this.imageRenderer.render(g, this.position);

        }

    }

    public void run() {


    }
}

package bases;

import enemies.Enemy;
import player.Player;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public ImageRenderer imageRenderer;
    public boolean isActive;


    private static ArrayList<GameObject> gameObjects = new ArrayList<>();
    private static ArrayList<GameObject> newgameOject = new ArrayList<>();

    public static void add(GameObject g) {
        newgameOject.add(g);

    }

    public static void runAll() {
        for (GameObject g : gameObjects) {
            if (g.isActive) {
                g.run();

            }
        }
        gameObjects.addAll(newgameOject);
        newgameOject.clear();

    }

    public static void renderAll(Graphics g) {
        for (GameObject go : gameObjects) {
            if (go.isActive) {
                go.render(g);
            }


        }
    }

    public static Enemy checkCollision(BoxCollider boxCollider) {
        Enemy result = null;
        for (GameObject go : gameObjects) {
            if (go.isActive&&go.boxCollider != null) {
                if (go instanceof Enemy) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        return (Enemy) go;
                    }

                }

            }

        }

        return result;
    }
    public static Player checkCollision2(BoxCollider boxCollider) {
        Player result = null;
        for (GameObject go : gameObjects) {
            if (go.isActive&&go.boxCollider != null) {
                if (go instanceof Player) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        return (Player) go;
                    }

                }

            }

        }

        return result;
    }

    public BoxCollider boxCollider;


    public GameObject(int x, int y) {

        this.position = new Vector2D(x, y);
        this.imageRenderer = null; //chua xac dinh//not yet specified
        this.boxCollider = null;
        this.isActive = true;
    }

    public void render(Graphics g) {
        if (this.imageRenderer != null) {
            this.imageRenderer.render(g, this.position);

        }
        if (this.boxCollider != null) {
            this.boxCollider.render(g);
        }

    }

    public  void destroy() {
        this.isActive = false;

    }

    public void run() {
        if (this.boxCollider != null) {
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
            this.boxCollider.run();
        }

    }



}

package bases;

import enemies.Enemy;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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

     public static Enemy checkCollision(BoxCollider boxCollider){
Enemy result =null;
        for(GameObject go: gameObjects){
            if(go.boxCollider !=null){
                if(go instanceof  Enemy){
                    if(go.boxCollider.collideWith(boxCollider)){
                        return (Enemy) go;
                    }

                }

            }

        }

        return  result;
     }
 public BoxCollider boxCollider;


    public GameObject(int x, int y) {

        this.position = new Vector2D(x, y);
        this.imageRenderer = null; //chua xac dinh//not yet specified
        this.boxCollider=null;
    }

    public void render(Graphics g) {
        if (this.imageRenderer != null) {
            this.imageRenderer.render(g, this.position);

        }

    }

    public void run() {


    }

}

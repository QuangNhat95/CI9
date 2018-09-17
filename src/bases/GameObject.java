package bases;

import enemies.EnemiesBullet;
import enemies.Enemy;
import player.Bullet;

import java.awt.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class GameObject {
    public Vector2D position;
    public Renderer renderer;
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
        System.out.println(gameObjects.size());

    }

    public static void renderAll(Graphics g) {
        for (GameObject go : gameObjects) {
            if (go.isActive) {
                go.render(g);
            }


        }
    }

    public static <T extends  GameObject> T recycle(int x, int y, Class<T> cls) {
        T pb = null;
        for (GameObject go : gameObjects) {
            if (!go.isActive) {
                if (go.getClass().equals(cls)) {
                    pb = (T) go;
                }
            }
        }
        if (pb == null) {
            try {
                try {
                    pb = cls.getConstructor(int.class, int.class).newInstance(x, y);
                } catch (InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();

            }
            System.out.println("add");
            GameObject.add(pb);
        } else {
            System.out.println("recycle");
            pb.isActive = true;
            pb.position.x = x;
            pb.position.y = y;
        }
        return pb;
    }
//
//    public static Enemy recycleE(int x, int y) {
//        Enemy e = null;
//        for (GameObject go : gameObjects) {
//            if (!go.isActive) {
//                if (go instanceof Enemy) {
//                    e = (Enemy) go;
//                }
//            }
//
//        }
//        if (e == null) {
//            e = new Enemy(x, y);
//            GameObject.add(e);
//        } else {
//
//            e.isActive = true;
//            e.position.x = x;
//            e.position.y = y;
//        }
//        return e;
//    }

//    public static EnemiesBullet recycleEB(int x, int y) {
//        EnemiesBullet eb = null;
//        for (GameObject go : gameObjects) {
//            if (!go.isActive) {
//                if (go instanceof EnemiesBullet) {
//                    eb = (EnemiesBullet) go;
//                }
//            }
//
//        }
//        if (eb == null) {
//            eb = new EnemiesBullet(x, y);
//            GameObject.add(eb);
//        } else {
//
//            eb.isActive = true;
//            eb.position.x = x;
//            eb.position.y = y;
//        }
//        return eb;
//    }

//Generics

    public static <T extends GameObject> T checkCollision(BoxCollider boxCollider, Class<T> cls) {
        T result = null;
        for (GameObject go : gameObjects) {
            if (go.isActive && go.boxCollider != null) {
                if (go.getClass().equals(cls)) {
                    if (go.boxCollider.collideWith(boxCollider)) {
                        result = (T) go;
                    }

                }

            }

        }
        return result;
    }


    public BoxCollider boxCollider;

    public GameObject() {

        this(0, 0);
    }

    public GameObject(int x, int y) {

        this.position = new Vector2D(x, y);
        this.renderer = null; //chua xac dinh//not yet specified
        this.boxCollider = null;
        this.isActive = true;
    }

    public void render(Graphics g) {
        if (this.renderer != null) {
            this.renderer.render(g, this.position);

        }
        if (this.boxCollider != null) {
            this.boxCollider.render(g);
        }

    }

    public void destroy() {
        this.isActive = false;
    }

    public void run() {
        if (this.boxCollider != null) {
            this.boxCollider.position.x = this.position.x;
            this.boxCollider.position.y = this.position.y;
            this.boxCollider.run();
        }

    }

    public void gameOver() {

        System.exit(0);
    }

}

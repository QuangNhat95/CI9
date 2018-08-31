package games;

import bases.GameObject;
import bases.ImageUtil;
import inputs.InputManager;
import enemies.Enemy;
import player.Bullet;
import player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;
    BufferedImage bufferedImage;
    Graphics graphics;
    Player player;
    //InputManager inputManager;


    ArrayList<GameObject> gameObjects = new ArrayList<>();
    Random random;
    int enemySpawnCount = 0;

    public GameCanvas() {
        random = new Random();
        background = ImageUtil.load("images/background/background.png");
        player = new Player(300, 700);
        GameObject.add(player);

        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        graphics = bufferedImage.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);

    }

    void run() {
        GameObject.runAll();

        enemySpawnCount++;
        if (enemySpawnCount >= 50) {
            enemySpawnCount = 0;
            int postX1 = random.nextInt(600);
            Enemy enemy1 = new Enemy(postX1, 0);
            GameObject.add(enemy1);


        }
    }

    void render() {
        graphics.drawImage(background, 0, 0, null);

        GameObject.renderAll(graphics);

        this.repaint();//  Son lai //Canvas repeat

    }


}


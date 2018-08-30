package games;

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
    InputManager inputManager;
    ArrayList<Bullet> bullets;
    ArrayList<Enemy> enemies;
    Random random;
    int enemySpawnCount = 0;

    public GameCanvas() {

        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        random = new Random();

        //inputManager = new inputs.InputManager();

        // inputManager= InputManager.instance;

        background = ImageUtil.load("images/background/background.png");
        player = new Player(268, 600);
        player.bullets = this.bullets;
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        graphics = bufferedImage.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);

    }

    void run() {
        player.run();
        //player.shootLock(bullets);
        for (Bullet bs : bullets) {
            bs.run();
        }
        for (Enemy es : enemies) {
            es.run();
        }
        enemySpawnCount++;
        if (enemySpawnCount >= 50) {
            enemySpawnCount = 0;
            int postX1 = random.nextInt(600);
            Enemy enemy1 = new Enemy(postX1, 0);

            enemies.add(enemy1);
        }
    }

    void render() {
        graphics.drawImage(background, 0, 0, null);
        for (Enemy es : enemies) {

            es.render(graphics);
        }
        player.render(graphics);

        for (Bullet bs : bullets) {
            bs.render(graphics);
        }

        this.repaint();//  Son lai //Canvas repeat

    }


}


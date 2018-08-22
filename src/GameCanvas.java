import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

public class GameCanvas extends JPanel {
    Image background;
    Player player;
    Random random;
    //InputManager inputManager;
    InputManager inputManager;
    ArrayList<Enemy> enemies1;
    ArrayList<Enemy2> enemies2;

    ArrayList<Bullet> bullets;

    public GameCanvas() {
        random = new Random();
        inputManager = new InputManager();

        enemies1 = new ArrayList<>();
        enemies2 = new ArrayList<>();

        bullets = new ArrayList<>();

        background = ImageUtil.load("images/background/background.png");
        player = new Player(200, 600);//Setup kich thuoc player
        player.inputManager = inputManager;//reference , point to
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        bufferedGraphics = bufferedImage.getGraphics();


    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);
    }




    BufferedImage bufferedImage;
    Graphics bufferedGraphics;


    void run() {
        player.run();
        player.shootLock(bullets);
        for (Bullet b1 : bullets) {
            b1.run();
        }

        for (Enemy e1 : enemies1) {
            e1.run();
        }

        for (Enemy2 e2 : enemies2) {
            e2.run();
        }

        //Setup de dan dc nha deu


        enemySpawnCount++;
        if (enemySpawnCount >= 60) {
            enemySpawnCount = 0;
           int  postX1 = random.nextInt(600);
            int  postX2 = random.nextInt(300);
            Enemy enemy1 = new Enemy(postX1, 0);
            Enemy2 enemy2 = new Enemy2(postX2, 0);

            enemies1.add(enemy1);
            enemies2.add(enemy2);
        }



    }

    boolean shootLock = false;
    boolean enemyDisable = false;
    int count;
    //int count1;
    int enemySpawnCount = 0;

    void render() {
        bufferedGraphics.drawImage(background, 0, 0, null);
        // bufferedGraphics.drawImage(player, playerX, playerY, null);

        for (Enemy e1 : enemies1) {
            e1.render(bufferedGraphics);
        }
        for (Enemy2 e2 : enemies2) {
            e2.render(bufferedGraphics);
        }
        for (Bullet b : bullets) {
            b.render(bufferedGraphics);
        }
        player.render(bufferedGraphics);

        this.repaint();
    }


}


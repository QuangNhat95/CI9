import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.ArrayList;

public class GameCanvas extends JPanel {
    Image background;
    Image player;
    //Bullet b;

    ArrayList<Enemy> es;
    ArrayList<Bullet> bs;

    public GameCanvas() {
        es = new ArrayList<>();

        bs = new ArrayList<>();

       /* Enemy es1 = new Enemy();
        es1.x = 200;
        es1.y = 0;
        Enemy es2 = new Enemy();
        es2.x = 400;
        es2.y = 0;
        Enemy es3 = new Enemy();
        es3.x = 500;
        es3.y = 0;

        Bullet b1 = new Bullet();
        b1.x=300;
        b1.y=700;
        Bullet b2 = new Bullet();
        b2.x=300;
        b2.y=600;
*/
        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
          /*  b1.image=ImageIO.read(new File("images/images/bullet/player/mb69bullet1.png"));
             b2.image=ImageIO.read(new File("images/images/bullet/player/mb69bullet1.png"));
            es1.image = ImageIO.read(new File("images/images/enemy/bacteria/bacteria3.png"));
            es2.image = ImageIO.read(new File("images/images/enemy/bacteria/bacteria3.png"));
            es3.image = ImageIO.read(new File("images/images/enemy/bacteria/bacteria3.png"));
*/


        } catch (IOException e) {
            e.printStackTrace();

        }
        //es.add(es1);
        //  es.add(es2);
        //bs.add(b1);
        // bs.add(b2);
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        bufferedGraphics = bufferedImage.getGraphics();


    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);

    }

    int x = 300 - 32;
    int y = 700 - 40;
    int xE1 = 150;
    int yE1 = 0;
    int xE2 = 300;
    int yE2 = 0;
    int xE3 = 400;
    int yE3 = 0;

    boolean rightPressed = false;
    boolean leftPressed = false;
    boolean upPressed = false;
    boolean downPressed = false;
    boolean xPressed = false;
    BufferedImage bufferedImage;
    Graphics bufferedGraphics;

    void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = true;

        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = true;

        }
    }

    void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            rightPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            leftPressed = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            upPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            downPressed = false;

        }
        if (e.getKeyCode() == KeyEvent.VK_X) {
            xPressed = false;
        }

    }

    void run() {
        if (rightPressed) {
            x += 5;

        }
        if (leftPressed) {
            x -= 5;

        }
        if (upPressed) {
            y -= 5;

        }
        if (downPressed) {
            y += 5;

        }
        for (Bullet b : bs) {
            b.y -= 5;
        }
        for (Enemy e : es) {
            e.y += 2;
        }
        if (xPressed && !shootDisable) {
            Bullet newB = new Bullet();
            newB.x = x;
            newB.y = y;
            try {
                newB.image = ImageIO.read(new File("images/bullet/player/mb69bullet.aseprite"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            bs.add(newB);
            shootDisable = true;
        }
        //Setup de dan dc nha deu
        if (shootDisable) {
            count++;
            if (count > 30) {
                shootDisable = false;
                count = 0;
            }
        }
        if (!enemyDisable) {
            Enemy newE1 = new Enemy();
            newE1.x = xE1;
            newE1.y = yE2;
            Enemy newE2 = new Enemy();
            newE2.x = xE2;
            newE2.y = yE2;
            Enemy newE3 = new Enemy();
            newE3.x = xE3;
            newE3.y = yE3;
            try {
                newE1.image = ImageIO.read(new File("images/enemy/bacteria/bacteria1.png"));
                newE2.image = ImageIO.read(new File("images/enemy/bacteria/bacteria2.png"));
                newE3.image = ImageIO.read(new File("images/enemy/bacteria/bacteria3.png"));

            } catch (IOException e) {
                e.printStackTrace();
            }
            es.add(newE1);
            es.add(newE2);
            es.add(newE3);
            enemyDisable = true;
        }
        if (enemyDisable) {
            count1++;
            if (count1>50) {
                enemyDisable = false;
                count1 = 0;
            }
        }


    }

    boolean shootDisable = false;
    boolean enemyDisable = false;
    int count;
    int count1;

    void render() {
        bufferedGraphics.drawImage(background, 0, 0, null);
        bufferedGraphics.drawImage(player, x, y, null);

        for (Enemy e : es) {
            bufferedGraphics.drawImage(e.image, e.x, e.y, null);
        }
        for (Bullet b : bs) {
            bufferedGraphics.drawImage(b.image, b.x, b.y, null);
        }
        this.repaint();
    }


}


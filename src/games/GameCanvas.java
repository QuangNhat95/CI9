package games;

import bases.GameObject;
import bases.ImageUtil;
import blood.BloodSpawner;
import enemies.EnenmySpawner;
import player.Player;
import player.Player2;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


public class GameCanvas extends JPanel {
    //Image background;
    BufferedImage bufferedImage;
    Graphics graphics;
    Player player;
    Player2 player2;
    BloodSpawner bloodSpawner;
    Background background;
    //InputManager inputManager;
    EnenmySpawner enenmySpawner;
    ArrayList<GameObject> gameObjects = new ArrayList<>();
    //Random random;

    public GameCanvas() {
        //random = new Random();
        //background = ImageUtil.load("images/background/background.png");
        background = new Background(300,400);
           GameObject.add(background);
        enenmySpawner = new EnenmySpawner(200, 0);
        GameObject.add(enenmySpawner);

        bloodSpawner = new BloodSpawner(600, 600);
        GameObject.add(bloodSpawner);


        player2 = new Player2(200, 600);
        GameObject.add(player2);

        player = new Player(300, 700);
        GameObject.add(player);

        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        graphics = bufferedImage.getGraphics();
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(bufferedImage, 0, 0, null);

    }

    public void run() {
        GameObject.runAll();

    }

    void render() {
        //graphics.drawImage(background, 0, 0, null);

        GameObject.renderAll(graphics);

        this.repaint();//  Son lai //Canvas repeat

    }


}


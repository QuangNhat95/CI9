import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GameCanvas extends JPanel {
    Image player;
   // Image player1;
    Image background;

    public GameCanvas() {
        try {
            background = ImageIO.read(new File("images/background/background.png"));
            player = ImageIO.read(new File("images/player/MB-69/player1.png"));
           //player1 = ImageIO.read(new File("images/player/MB-70/player2.png"));
        } catch (IOException e) {
            System.out.println("Oh no");
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(background, 0, 0, null);
        g.drawImage(player, 300-32, 400-40, null);
        //g.drawImage(player1, 300-32, 700-40, null);

    }
}

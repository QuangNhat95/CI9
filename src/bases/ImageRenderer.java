package bases;

import java.awt.*;
import java.awt.image.ImagingOpException;

public class ImageRenderer {
    Image image;


    public ImageRenderer(String url) {

        this.image = ImageUtil.load(url);

    }


    public void render(Graphics g, Vector2D position) {
        g.drawImage(this.image, (int) position.x, (int) position.y, null);

    }

}

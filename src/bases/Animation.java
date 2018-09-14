package bases;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Animation extends Renderer {
    private boolean oneTime;
    public boolean finished;
    ArrayList<Image> images;
    //1.Load anh
    int imageIndex;
    FramCounter framCounter;

    public Animation(Image... images) {
        this(10, false, images);

    }

    public Animation(int frameDelay, boolean oneTime, Image... imgs) {
        this.images = new ArrayList<>();
        this.images.addAll(Arrays.asList(imgs));

        this.oneTime = oneTime;
        this.finished = false;

        this.imageIndex = 0;
        framCounter = new FramCounter(frameDelay);
    }

    //2.Ve anh
    public void render(Graphics g, Vector2D position) {
        renderCurrentImage(g, position);
        changeCurrentImage();
    }

    private void changeCurrentImage() {
        framCounter.run();
        if (framCounter.expired) {
            framCounter.reset();

            if (this.imageIndex < this.images.size() - 1) {
                this.imageIndex += 1;
            } else {
                if (this.oneTime) {
                    this.finished = true;
                } else {
                    this.imageIndex = 0;
                }
            }
        }
    }

    private void renderCurrentImage(Graphics g, Vector2D position) {

        Image currentImage = images.get(this.imageIndex);
        int width = currentImage.getWidth(null);
        int height = currentImage.getHeight(null);
        g.drawImage(currentImage,
                (int) (position.x - width / 2), (int) (position.y) - height / 2,
                null
        );
    }
}

package GameObject;

import java.awt.image.BufferedImage;
import Math.Vector2D;

public class ReduceSpeed extends PowerUps{
    public ReduceSpeed (Vector2D position, BufferedImage texture) {
        super(position, texture);
        time = 0;
    }
}

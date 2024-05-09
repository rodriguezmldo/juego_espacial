package GameObject;

import java.awt.image.BufferedImage;
import Math.Vector2D;

public class Speed extends PowerUps{
    public Speed(Vector2D position, BufferedImage texture) {
        super(position, texture);
        time = 0;
    }
}

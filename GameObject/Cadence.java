package GameObject;

import java.awt.image.BufferedImage;

import Math.Vector2D;

public class Cadence extends PowerUps{
    public Cadence (Vector2D position, BufferedImage texture) {
        super(position, texture);
        time = 0;
    }
}

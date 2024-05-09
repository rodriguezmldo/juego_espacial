package GameObject;

import Math.Vector2D;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Spacecraft extends CosmicObject {
    protected int missiles;
    private int distance;

    public Spacecraft(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    public int getDistance() {
        return distance;
    }

    public int getMissiles() {
        return missiles;
    }
}
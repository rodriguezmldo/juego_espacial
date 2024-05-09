package GameObject;

import java.awt.image.BufferedImage;
import Math.Vector2D;


public class Asteroid extends CosmicObject {
    public Asteroid(Vector2D position, BufferedImage texture) {
        super(position, texture); // Daño y penalidades específicas para asteroides
    }
}
package GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import Math.Vector2D;


public class Asteroid extends CosmicObject {
    public Asteroid(Vector2D position, BufferedImage texture) {
        super(position, texture); // Daño y penalidades específicas para asteroides
    }

    @Override
    public void update(float dt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics g) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }
}
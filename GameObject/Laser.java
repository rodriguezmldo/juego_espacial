package GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Math.Vector2D;
import States.GameState;

public class Laser extends MoveObject {

    public Laser(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.velocity = velocity.scale(maxVel);
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

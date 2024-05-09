package GameObject;

import Math.Vector2D;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Graphics.Keyboard;

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

    @Override
    public void update(float t) {
        if(Keyboard.VK_A){
            position.setX(position.getX() + 1);
        }
    }
    @Override
    public void draw(Graphics g) {
        g.drawImage(texture, (int)position.getX(), (int)position.getY(), null);
    }
}
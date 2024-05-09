package GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import Math.Vector2D;

public class PowerUps extends CosmicObject{
    protected int time;

    public PowerUps(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

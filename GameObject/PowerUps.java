package GameObject;

import java.awt.image.BufferedImage;

import Math.Vector2D;

public class PowerUps extends CosmicObject{
    private int time;

    public PowerUps(Vector2D position, BufferedImage texture) {
        super(position, texture);
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

}

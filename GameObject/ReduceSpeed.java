package GameObject;

import java.awt.image.BufferedImage;
import Math.Vector2D;

public class ReduceSpeed extends CosmicObject{
    private int time;

    public ReduceSpeed (Vector2D position, BufferedImage texture) {
        super(position, texture);
        time = 0;
    }
    
    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}

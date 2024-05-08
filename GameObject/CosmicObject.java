package GameObject;

import java.awt.image.BufferedImage;

public abstract class CosmicObject {
    protected BufferedImage texture;
    protected int distance;
    protected int speed;
    protected int damage;
    protected int missilesPenalty;

    public CosmicObject() {
    }

    public abstract void interact(Spacecraft spacecraft);

    public int getDistance() {
        return distance;
    }

    public int getDamage() {
        return damage;
    }

    public int getMissilesPenalty() {
        return missilesPenalty;
    }
}
package GameObject;

import java.awt.image.BufferedImage;
import Math.Vector2D;

public abstract class CosmicObject {
    protected BufferedImage texture;
    protected Vector2D position;
    protected int distance;
    protected int speed;
    protected int damage;

    public CosmicObject() {
    }

    public CosmicObject(Vector2D position, BufferedImage texture) {
        this.position = position;
        this.texture = texture;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public Vector2D getPosition() {
        return position;
    }

    public void setPosition(Vector2D position) {
        this.position = position;
    }

    public int getDistance() {
        return distance;
    }

    public int getDamage() {
        return damage;
    }
}
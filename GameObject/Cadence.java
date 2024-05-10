package GameObject;

import java.awt.image.BufferedImage;

import Math.Vector2D;
import States.GameState;

public class Cadence extends PowerUps{
    public Cadence (Vector2D position, BufferedImage texture, GameState gameState) {
        super(position, texture, gameState);
        time = 0;
    }
}

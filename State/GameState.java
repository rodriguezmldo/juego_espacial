package State;

import java.awt.Graphics;
import GameObject.Spacecraft;
import Graphics.Assets;
import Math.Vector2D;

public class GameState {
    private Spacecraft player;

    public GameState () {
        player = new Spacecraft(new Vector2D(0, 0), Assets.player[0]);
    }

    public void update () {

    }

    public void draw(Graphics g) {
        player.draw(g);
    }
}

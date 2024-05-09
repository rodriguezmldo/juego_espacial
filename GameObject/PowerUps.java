package GameObject;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.Action;

import Math.Vector2D;
import States.GameState;

public class PowerUps extends MoveObject{
    private long time;
	private Action action;
	private BufferedImage typeTexture;



    public PowerUps(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public BufferedImage getTypeTexture() {
        return typeTexture;
    }

    public void setTypeTexture(BufferedImage typeTexture) {
        this.typeTexture = typeTexture;
    }

    @Override
    public void update(float dt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void draw(Graphics g) {
        throw new UnsupportedOperationException("Unimplemented method 'draw'");
    }

    void executeAction() {
		action.doAcxtion();
	}

}

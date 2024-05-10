package GameObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Graphics.Animation;
import Graphics.Assets;
import Math.Vector2D;
import States.GameState;

public class Spacecraft extends MoveObject{
    private Vector2D heading;	
	private Vector2D acceleration;

	private boolean accelerating = false;
	private long fireRate;
	
	private boolean spawning, visible;
	
	private long spawnTime, flickerTime, fastFireTime, bootsSpeedTime, slowSpeedTime;
	
	private boolean fastFireOn, slowSpeedOn, BoostSpeedOn;
	
	private long fireSpeed;

    public Spacecraft(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
        super(position, velocity, maxVel, texture, gameState);
        this.acceleration = new Vector2D(0, 1);
        this.
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
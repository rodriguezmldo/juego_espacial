package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.ImageIcon;
import graphics.Assets;
import input.KeyBoard;
import math.Vector2D;
import states.GameState;

public class Player extends MovingObject{
	private Vector2D heading;
	private double moving = 5;
	private long lastTime;
	
	public Player(Vector2D position, Vector2D velocity, double maxVel, ImageIcon texture,  GameState gameState) {
		super(position, velocity,  maxVel, texture, gameState);
		heading = new Vector2D(1, 0);
		lastTime = System.currentTimeMillis();
	}

	@Override
	public void update() {
		 if (KeyBoard.SHOOT && System.currentTimeMillis() - lastTime > Constants.FIRERATE) {
		        lastTime = System.currentTimeMillis();
		        gameState.getMovingObjects().add(new Laser(
	                getCenter().add(heading.scale(width)),
	                heading,
	                Constants.LASER_VEL,
	                Assets.laser,
	                gameState
	                ));
	    }
		
	    if (KeyBoard.UP && inLimit((int) (position.getY() - moving))) {
	        position = position.add(new Vector2D(0, -moving));
	    } else if (KeyBoard.DOWN && inLimit((int) (position.getY() + texture.getImage().getHeight(null) + moving))) {
	        position = position.add(new Vector2D(0, moving));
	    }
	    
	    collisionsWith();
	}

	public boolean inLimit(int limit) {
	    return limit >= 0 && limit <= Constants.HEIGHT - texture.getImage().getHeight(null) / 2;
	}


	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(texture.getImage(), (int)position.getX(), (int)position.getY(), null);
	}
	
	public Vector2D getCenter() {
		return new Vector2D(position.getX(), position.getY() - height/50);
	}
}

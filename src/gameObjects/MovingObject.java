package gameObjects;


import java.util.ArrayList;

import javax.swing.ImageIcon;
import math.Vector2D;
import states.GameState;

public abstract class MovingObject extends GameObject{
	protected Vector2D velocity;
	protected double maxVel;
	protected int width;
	protected int height;
	protected GameState gameState;
	public int score;
	
	protected void collisionsWith() {
	    ArrayList<MovingObject> movingObjects = gameState.getMovingObjects();
	    
	    for(int i = 0; i < movingObjects.size(); i++) {
	        MovingObject m = movingObjects.get(i);
	        
	        if (m.equals(this))
	            continue;
	        
	        double distance = m.getCenter().subtract(getCenter()).getMagnitude();
	        
	        if (distance < m.width / 2 + width / 2) {
	            // Colisión detectada, llama al método de manejo de colisiones
	            objectCollision(this, m);
	        }
	    }
	}
	
	private void objectCollision(MovingObject a, MovingObject b) {
	    if (!(a instanceof Asteroid) && !(b instanceof Asteroid)) {
	        a.Destroy();
	        b.Destroy();
	        score += Constants.ASTEROID_SCORE;
	    }
	    
	    if (!(a instanceof Planet) && !(b instanceof Planet)) {
	        a.Destroy();
	        b.Destroy();
	        score += Constants.PLANET_SCORE;
	    }
	    
	    if (!(a instanceof Blackhole) && !(b instanceof Blackhole)) {
	        a.Destroy();
	        b.Destroy();
	        score += Constants.BLACKHOLE_SCORE;
	    }
	    
	    System.out.println(score);
	}
	
	protected void Destroy() {
		gameState.getMovingObjects().remove(this);
	}

	public MovingObject(Vector2D position, Vector2D velocity, double maxVel, ImageIcon texture, GameState gameState) {
		super(position, texture);
		this.gameState = gameState;
		this.velocity = velocity;
		this.maxVel = maxVel;
		this.width = texture.getImage().getWidth(null);
		this.height = texture.getImage().getHeight(null);
		score = 0;
	}
	
	protected Vector2D getCenter(){
		return new Vector2D(position.getX(), position.getY() - height/50);
	}
}

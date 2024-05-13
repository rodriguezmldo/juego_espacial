package GameObject;

import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import Graphics.Assets;
import Math.Vector2D;
import States.GameState;

public abstract class MoveObject extends CosmicObject{
	
	protected Vector2D velocity;
	protected AffineTransform at;
	protected double angle;
	protected double maxVel;
	protected int width;
	protected int height;
	protected GameState gameState;
	
	protected boolean Dead;
	
	public MoveObject(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
		super(position, texture);
		this.velocity = velocity;
		this.maxVel = maxVel;
		this.gameState = gameState;
		width = texture.getWidth();
		height = texture.getHeight();
		Dead = false;
	}
	
	protected void collidesWith(){
		
		ArrayList<MoveObject> movingObjects = gameState.getMoveObjects(); 
		
		for(int i = 0; i < movingObjects.size(); i++){
			
			MoveObject m  = movingObjects.get(i);
			
			if(m.equals(this))
				continue;
			
			double distance = m.getCenter().subtract(getCenter()).getMagnitude();
			
			if(distance < m.width/2 + width/2 && movingObjects.contains(this) && !m.Dead && !Dead){
				objectCollision(this, m);
			}
		}
	}
	
	private void objectCollision(MoveObject a, MoveObject b) {
		
		Spacecraft p = null;
		
		if(a instanceof Spacecraft)
			p = (Spacecraft)a;
		else if(b instanceof Spacecraft)
			p = (Spacecraft)b;
		
		if(p != null && p.isSpawning()) 
			return;
		
		if(a instanceof Asteroid && b instanceof Asteroid)
			return;
		
		if(!(a instanceof PowerUps || b instanceof PowerUps)){
			a.Destroy();
			b.Destroy();
			return;
		}
		
		if(p != null){
			if(a instanceof Spacecraft){
				((PowerUps)b).executeAction();
				b.Destroy();
			}else if(b instanceof Spacecraft){
				((PowerUps)a).executeAction();
				a.Destroy();
			}
		}
		
	}
	
	protected void Destroy(){
		Dead = true;
	}
	
	protected Vector2D getCenter(){
		return new Vector2D(position.getX() + width/2, position.getY() + height/2);
	}
	
	public boolean isDead() {return Dead;}
	
}
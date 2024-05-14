package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import math.Vector2D;
import states.GameState;

public class Laser extends MovingObject{

	public Laser(Vector2D position, Vector2D velocity, double maxVel, ImageIcon texture,  GameState gameState) {
		super(position, velocity,  maxVel, texture, gameState);
		this.velocity = velocity.scale(maxVel);
	}
	
	@Override
	public void update() {
		position = position.add(velocity);	
		
		if (position.getX() < 0 || position.getX() > Constants.WIDTH) {
			Destroy();
		}
		
		collisionsWith();
	}
	
	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(texture.getImage(), (int)position.getX(), (int)position.getY(), null);
	}

	@Override
	protected Vector2D getCenter() {
		// TODO Auto-generated method stub
		return new Vector2D(position.getX(), position.getY() + width/2);
	}
}

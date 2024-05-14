package gameObjects;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;

import graphics.Assets;
import math.Vector2D;
import states.GameState;

public class Asteroid extends MovingObject {
	public Asteroid(Vector2D position, Vector2D velocity, double maxVel, ImageIcon texture, GameState gameState) {
		super(position, velocity, maxVel, texture, gameState);
		
		
	}
	

	@Override
	public void update() {
		position = position.add(velocity);
		
		if(position.getX() > Constants.WIDTH)
			position.setX(0);
		if(position.getY() > Constants.HEIGHT)
			position.setY(0);
		
		if(position.getX() < 0)
			position.setX(Constants.WIDTH);
		if(position.getY() < 0)
			position.setY(Constants.HEIGHT);
	}

	@Override
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(texture.getImage(), (int)position.getX(), (int)position.getY(), null);
	}

}

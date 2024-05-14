package gameObjects;

import java.awt.Graphics;
import javax.swing.ImageIcon;
import math.Vector2D;

public abstract class GameObject {
	protected ImageIcon texture;
	protected Vector2D position;
	
	public GameObject(Vector2D position, ImageIcon texture) {
		this.position = position;
		this.texture = texture;
	}
	
	public abstract void update();
	
	public abstract void draw(Graphics g);

	public Vector2D getPosition() {
		return position;
	}

	public void setPosition(Vector2D position) {
		this.position = position;
	}
}

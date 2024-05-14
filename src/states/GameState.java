package states;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;

import gameObjects.Asteroid;
import gameObjects.Blackhole;
import gameObjects.Constants;
import gameObjects.MovingObject;
import gameObjects.Planet;
import gameObjects.Player;
import graphics.Assets;
import math.Vector2D;

public class GameState {
	private Player player;
	private ArrayList<MovingObject> movingObjects = new ArrayList<MovingObject>();
	private int asteroids, planets, blackholes;
	private Random random = new Random();
	
	
	public GameState() {
		player = new Player(new Vector2D(100, 320), new Vector2D(), 0,	Assets.shipNormal, this);
		movingObjects.add(player);
		
		asteroids = 1; 
		planets = 1;
		blackholes = 1;
		
		startAsteroid();
		startPlanet();
		startBlackhole();
	}
	
	public void update() {
		for(int i = 0; i < movingObjects.size(); i++) {
			movingObjects.get(i).update();
		}
		
		for(int i = 0; i <movingObjects.size(); i++) {
			if(movingObjects.get(i) instanceof Asteroid)
				return;
		}
		
		for(int i = 0; i <movingObjects.size(); i++) {
			if(movingObjects.get(i) instanceof Planet)
				return;
		}
		
		startAsteroid();
		startPlanet();
		startBlackhole();
	}
	
	private void startBlackhole() {
	    for (int i = 0; i < planets; i++) {
	        double x = Math.random() * Constants.WIDTH; // Comenzar desde el borde derecho de la pantalla
	        double y = Math.random() * Constants.HEIGHT; // Posición vertical aleatoria
	        
	        ImageIcon texture = Assets.blackHole;
	        
	        double vx = -(Math.random() * 3 + 2); // Velocidad aleatoria en el rango [-2, -5] para ir de derecha a izquierda
	        double vy = Math.random() * 2 - 1; // Velocidad aleatoria en el rango [-1, 1] para movimiento vertical
	        
	        movingObjects.add(new Blackhole(
	                new Vector2D(x, y),
	                new Vector2D(vx, vy),
	                Constants.ASTEROID_VEL * Math.random() + 1, // Velocidad aleatoria en el rango [1, VELOCIDAD_MAX]
	                texture,
	                this
	                ));
	    }
	    blackholes++;
	}
	
	private void startPlanet() {
	    for (int i = 0; i < planets; i++) {
	        double x = Math.random() * Constants.WIDTH; // Comenzar desde el borde derecho de la pantalla
	        double y = Math.random() * Constants.HEIGHT; // Posición vertical aleatoria
	        
	        int randomIndex = (int) (Math.random() * Assets.planet.length);
	        ImageIcon texture = Assets.planet[randomIndex];
	        
	        double vx = -(Math.random() * 3 + 2); // Velocidad aleatoria en el rango [-2, -5] para ir de derecha a izquierda
	        double vy = Math.random() * 2 - 1; // Velocidad aleatoria en el rango [-1, 1] para movimiento vertical
	        
	        movingObjects.add(new Planet(
	                new Vector2D(x, y),
	                new Vector2D(vx, vy),
	                Constants.ASTEROID_VEL * Math.random() + 1, // Velocidad aleatoria en el rango [1, VELOCIDAD_MAX]
	                texture,
	                this
	                ));
	    }
	    planets++;
	}
	
	private void startAsteroid() {
	    for (int i = 0; i < asteroids; i++) {
	        double x = Math.random() * Constants.WIDTH; // Comenzar desde el borde derecho de la pantalla
	        double y = Math.random() * Constants.HEIGHT; // Posición vertical aleatoria
	        
	        ImageIcon texture = Assets.asteroid;
	        
	        double vx = -(Math.random() * 3 + 2); // Velocidad aleatoria en el rango [-2, -5] para ir de derecha a izquierda
	        double vy = Math.random() * 2 - 1; // Velocidad aleatoria en el rango [-1, 1] para movimiento vertical
	        
	        movingObjects.add(new Asteroid(
	                new Vector2D(x, y),
	                new Vector2D(vx, vy),
	                Constants.ASTEROID_VEL * Math.random() + 1, // Velocidad aleatoria en el rango [1, VELOCIDAD_MAX]
	                texture,
	                this
	                ));
	    }
	    asteroids++;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		for(int i = 0; i < movingObjects.size(); i++) {
			movingObjects.get(i).draw(g2d);
		}
	}

	public ArrayList<MovingObject> getMovingObjects() {
		return movingObjects;
	}

	public void setMovingObjects(ArrayList<MovingObject> movingObjects) {
		this.movingObjects = movingObjects;
	}
}

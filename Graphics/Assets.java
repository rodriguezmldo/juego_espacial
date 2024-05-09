package Graphics;

import java.awt.image.BufferedImage;

public class Assets {
	
	public static boolean loaded = false;
	public static float count = 0;
	public static float MAX_COUNT = 57;
	
	public static BufferedImage[] player = new BufferedImage[2];
	
	// effects
	
	public static BufferedImage[] shipSpeed = new BufferedImage[2]; 
	public static BufferedImage[] shipCadence = new BufferedImage[2];
	public static BufferedImage[] shipReduceSpeed = new BufferedImage[2];
	public static BufferedImage shipHealth;
	
	// explosion
	
	public static BufferedImage[] exp = new BufferedImage[5];
	
	// lasers
	
	public static BufferedImage laser;
	
	// CosmicDanger
	
	public static BufferedImage meteors;
    public static BufferedImage blackHole;
    public static BufferedImage[] planet = new BufferedImage[2];
;	
	// numbers
	
	public static BufferedImage[] numbers = new BufferedImage[11];
	
	public static BufferedImage life;
	
	// ui
	
	public static BufferedImage blueBtn;
	public static BufferedImage greyBtn;
	
	// power ups
	
	public static BufferedImage cadence, speed, reduceSpeed, health;
	
	public static void init()
	{
		shipHealth = loadImage("/Effects/shipRegenerate.gif");
		
		laser = loadImage("/Effects/laser.gif");
		
		meteors = loadImage("/CosmicDanger/asteroid.gif");

		blackHole = loadImage("/CosmicDanger/blackHola.gif");
		
		for(int i = 0; i < 2; i++) {
			player[i] = loadImage("/Player/ship" + i +".gif"); 
			shipSpeed[i] = loadImage("/Effects/shipBoost" + i + ".gif");
			shipCadence[i] = loadImage("/Effects/shipCadence" + i + ".gif");
			shipReduceSpeed[i] = loadImage("/Effects/shipReduce" + i + ".gif");
			planet[i] = loadImage("/CosmicDanger/planet" + i + ".gif");
		}
		
		for(int i = 0; i < exp.length; i++)
			exp[i] = loadImage("/explosion/"+ i +".png");
		
		for(int i = 0; i < numbers.length; i++)
			numbers[i] = loadImage("/numbers/"+ i +".png");
		
		greyBtn = loadImage("/ui/grey_button.png");
		blueBtn = loadImage("/ui/blue_button.png");
		
		cadence = loadImage("/PowerUp/powerupCadence.gif");
		speed = loadImage("/PowerUp/powerupBoost.gif");
		reduceSpeed = loadImage("/PowerUp/powerupReduce.gif");
		health = loadImage("/PowerUp/powerupHealth.gif");
		
		loaded = true;
		
	}

	public static BufferedImage loadImage(String path) {
		count ++;
		return Loader.ImageLoader(path);
	}
}
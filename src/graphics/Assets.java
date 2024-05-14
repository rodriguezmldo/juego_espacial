package graphics;

import javax.swing.ImageIcon;

public class Assets {
	
	public static boolean loaded = false;
	public static float count = 0;
	public static float MAX_COUNT = 57;
	
	public static ImageIcon shipNormal, shipShot;
	
	// effects
	
	public static ImageIcon[] shipSpeed = new ImageIcon[2]; 
	public static ImageIcon[] shipCadence = new ImageIcon[2];
	public static ImageIcon[] shipReduceSpeed = new ImageIcon[2];
	public static ImageIcon shipHealth;
	
	// explosion
	
	public static ImageIcon[] exp = new ImageIcon[5];
	
	// lasers
	
	public static ImageIcon laser;
	
	// CosmicDanger
	
	public static ImageIcon asteroid;
    public static ImageIcon blackHole;
    public static ImageIcon[] planet = new ImageIcon[2];
;	
	// numbers
	
	public static ImageIcon[] numbers = new ImageIcon[11];
	
	public static ImageIcon life;
	
	// ui
	
	public static ImageIcon blueBtn;
	public static ImageIcon greyBtn;
	
	// power ups
	
	public static ImageIcon cadence, speed, reduceSpeed, health;
	
	public static void init()
	{
		shipNormal = loadImage("/player/ship0.gif");
		shipShot = loadImage("/player/ship1.gif");
		shipHealth = loadImage("/effects/shipRegenerate.gif");
		laser = loadImage("/effects/laser.gif");
		asteroid = loadImage("/cosmicDanger/asteroid.gif");
		blackHole = loadImage("/cosmicDanger/blackHole.gif");
		
		for(int i = 0; i < 2; i++) {
			shipSpeed[i] = loadImage("/effects/shipBoost" + i + ".gif");
			shipCadence[i] = loadImage("/effects/shipCadence" + i + ".gif");
			shipReduceSpeed[i] = loadImage("/effects/shipReduce" + i + ".gif");
			planet[i] = loadImage("/cosmicDanger/planet" + i + ".gif");
		}
		
		for(int i = 0; i < exp.length; i++)
			exp[i] = loadImage("/explot/"+ i +".gif");
		
		greyBtn = loadImage("/ui/buttonGreen.png");
		blueBtn = loadImage("/ui/buttonBlue.png");
		
		cadence = loadImage("/powerUp/powerupCadence.gif");
		speed = loadImage("/powerUp/powerupBoost.gif");
		reduceSpeed = loadImage("/powerUp/powerupReduce.gif");
		health = loadImage("/powerUp/powerupHealth.gif");
		
		loaded = true;
		
	}

	public static ImageIcon loadImage(String path) {
		count ++;
		return Loader.ImageLoader(path);
	}
}
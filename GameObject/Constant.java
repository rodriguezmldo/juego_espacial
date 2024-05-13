package GameObject;

import javax.swing.filechooser.FileSystemView;

public class Constant {
	
	// frame dimensions
	
	public static final int WIDTH = 1280;
	public static final int HEIGHT = 720;
	
	// player properties
	
	public static final int FIRERATE = 300;
	public static final double DELTAANGLE = 0.1;
	public static final double ACC = 0.2;
	public static final double PLAYER_MAX_VEL = 7.0;
	public static final long FLICKER_TIME = 200;
	public static final long SPAWNING_TIME = 1500;
	public static final long GAME_OVER_TIME = 3000;
	
	// Laser properties
	
	public static final double LASER_VEL = 10.0;
	
	// ASTEROID properties
	
	public static final int ASTEROID_INIT_VEL = 2;
	
	public static final int ASTEROID_SCORE = 20;
	
	public static final int ASTEROID_MAX_VEL = 6;

    // Planet properties

    public static final double PLANET_INI_VELOCIDAD = 3;

    public static final int PLANET_SCORE = 15;

    public static final double PLANET_MAX_VEL = 5;
 
	
	// Blackhole properties

    public static final int BLACKHOLE_INI_VEL = 4;
	
	public static final int BLACKHOLE_MAX_VEL = 4;
	
	public static final int BLACKHOLE_SCORE = 60;
	
	
	public static final String SCORE_PATH = FileSystemView.getFileSystemView().getDefaultDirectory().getPath() +
			"/SaveData/DataFiles/profiles.txt"; // data.xml if you use XMLParser
	
	// This variables are required to use XMLParser
	
	public static final String PLAYER = "PLAYER";
	public static final String PLAYERS = "PLAYERS";
	
	// =============================================
	
	public static final long POWER_UP_DURATION = 10000;
	public static final long POWER_UP_SPAWN_TIME = 8000;
	
	public static final long SHIELD_TIME = 12000;
	public static final long DOUBLE_SCORE_TIME = 10000;
	public static final long FAST_FIRE_TIME = 14000;
	public static final long DOUBLE_GUN_TIME = 12000;
	
	public static final int SCORE_STACK = 1000;
	
}
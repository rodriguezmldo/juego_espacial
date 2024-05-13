package GameObject;

import java.awt.image.BufferedImage;
import Graphics.Assets;

public class PowerUpsTypes {
public enum PowerUpTypes {
	CADENCE("Cadence", Assets.cadence),
	LIFE("+1 LIFE", Assets.life),
	SPEED("SCORE x2", Assets.speed),
	REDUCE_SPEED("FAST FIRE", Assets.reduceSpeed),
	
	public String text;
	public BufferedImage texture;
	
	private PowerUpTypes(String text, BufferedImage texture){
		this.text = text;
		this.texture = texture;
	}
}
}

package GameObject;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import Graphics.Animation;
import Graphics.Assets;
import Math.Vector2D;
import States.GameState;

public class Spacecraft extends MoveObject{
	
    private Vector2D heading;	
	private Vector2D acceleration;

	private boolean accelerating = false;
	private long fireRate;
	
	private boolean spawning, visible;
	
	private long spawnTime, flickerTime, fastFireTime, bootsSpeedTime, slowSpeedTime;
	
	private boolean fastFireOn, slowSpeedOn, BoostSpeedOn;
	
	private long fireSpeed;
	
	public Spacecraft(Vector2D position, Vector2D velocity, double maxVel, BufferedImage texture, GameState gameState) {
		super(position, velocity, maxVel, texture, gameState);
		heading = new Vector2D(0, 1);
		acceleration = new Vector2D();
		fireRate = 0;
		spawnTime = 0;
		flickerTime = 0;
		fastFireTime = 0;
        bootsSpeedTime = 0;
        slowSpeedTime = 0;
		
		visible = true;
	}
	
	@Override
	public void update(float dt) 
	{
		
		fireRate += dt;
		
		if(fastFireOn) {
			fireSpeed = Constant.FIRERATE / 2;
			fastFireTime += dt;
		}else {
			fireSpeed = Constant.FIRERATE;
		}
		
		if(fastFireTime > Constant.FAST_FIRE_TIME) {
			fastFireOn = false;
			fastFireTime = 0;
		}
		
		if(spawning) {
			
			flickerTime += dt;
			spawnTime += dt;
			
			if(flickerTime > Constant.FLICKER_TIME) {
				
				visible = !visible;
				flickerTime = 0;
			}
			
			if(spawnTime > Constant.SPAWNING_TIME) {
				spawning = false;
				visible = true;
			}
			
		}
		
		if(KeyBoard.SHOOT &&  fireRate > fireSpeed && !spawning)
		{
			
			if(doubleGunOn) {
				Vector2D leftGun = getCenter();
				Vector2D rightGun = getCenter();
				
				Vector2D temp = new Vector2D(heading);
				temp.normalize();
				temp = temp.setDirection(angle - 1.3f);
				temp = temp.scale(width);
				rightGun = rightGun.add(temp);
				
				temp = temp.setDirection(angle - 1.9f);
				leftGun = leftGun.add(temp);
				
				Laser l = new Laser(leftGun, heading, Constant.LASER_VEL, angle, Assets.blueLaser, gameState);
				Laser r = new Laser(rightGun, heading, Constant.LASER_VEL, angle, Assets.blueLaser, gameState);
				
				gameState.getMovingObjects().add(0, l);
				gameState.getMovingObjects().add(0, r);
				
			}else {
				gameState.getMovingObjects().add(0,new Laser(
						getCenter().add(heading.scale(width)),
						heading,
						Constant.LASER_VEL,
						angle,
						Assets.blueLaser,
						gameState
						));
			}

			fireRate = 0;
			shoot.play();
		}
		
		if(shoot.getFramePosition() > 8500) {
			shoot.stop();
		}
		
		if(Keyboard.RIGHT)
			angle += Constant.DELTAANGLE;
		if(Keyboard.LEFT)
			angle -= Constant.DELTAANGLE;
		
		if(Keyboard.UP)
		{
			acceleration = heading.scale(Constant.ACC);
			accelerating = true;
		}else
		{
			if(velocity.getMagnitude() != 0)
				acceleration = (velocity.scale(-1).normalize()).scale(Constant.ACC/2);
			accelerating = false;
		}
		
		velocity = velocity.add(acceleration);
		
		velocity = velocity.limit(maxVel);
		
		position = position.add(velocity);
		
		if(position.getX() > Constant.WIDTH)
			position.setX(0);
		if(position.getY() > Constant.HEIGHT)
			position.setY(0);
		
		if(position.getX() < -width)
			position.setX(Constant.WIDTH);
		if(position.getY() < -height)
			position.setY(Constant.HEIGHT);
		
		if(shieldOn)
			shieldEffect.update(dt);
		
		collidesWith();
	}
	
	public void setShield() {
		if(shieldOn)
			shieldTime = 0;
		shieldOn = true;
	}
	
	public void setDoubleScore() {
		if(doubleScoreOn)
			doubleScoreTime = 0;
		doubleScoreOn = true;
	}
	
	public void setFastFire() {
		if(fastFireOn)
			fastFireTime = 0;
		fastFireOn = true;
	}
	
	public void setDoubleGun() {
		if(doubleGunOn)
			doubleGunTime = 0;
		doubleGunOn = true;
	}
	
	@Override
	public void Destroy() {
		spawning = true;
		gameState.playExplosion(position);
		spawnTime = 0;
		loose.play();
		if(!gameState.subtractLife(position)) {
			gameState.gameOver();
			super.Destroy();
		}
		resetValues();
		
	}
	
	private void resetValues() {
		
		angle = 0;
		velocity = new Vector2D();
		position = GameState.PLAYER_START_POSITION;
	}
	
	@Override
	public void draw(Graphics g) {
		
		if(!visible)
			return;
		
		
		Graphics2D g2d = (Graphics2D)g;
		
		AffineTransform at1 = AffineTransform.getTranslateInstance(position.getX() + width/2 + 5,
				position.getY() + height/2 + 10);
		
		AffineTransform at2 = AffineTransform.getTranslateInstance(position.getX() + 5, position.getY() + height/2 + 10);
		
		if(accelerating)
		{
			g2d.drawImage(Assets.shipSpeed, at1, null);
			g2d.drawImage(Assets.shipSpeed, at2, null);
		}
		
		
		
		if(shieldOn) {
			BufferedImage currentFrame = shieldEffect.getCurrentFrame();
			AffineTransform at3 = AffineTransform.getTranslateInstance(
					position.getX() - currentFrame.getWidth() / 2 + width/2,
					position.getY() - currentFrame.getHeight() / 2 + height/2);
			
			at3.rotate(angle, currentFrame.getWidth() / 2, currentFrame.getHeight() / 2);
					
			g2d.drawImage(shieldEffect.getCurrentFrame(), at3, null);
		}
		
		at = AffineTransform.getTranslateInstance(position.getX(), position.getY());
		
		at.rotate(angle, width/2, height/2);
		
		/*g2d.setColor(Color.RED);
		
		g2d.drawOval(
				(int)(getCenter().getX() - Constant.SHIELD_DISTANCE / 2),
				(int)(getCenter().getY() - Constant.SHIELD_DISTANCE / 2),
				Constant.SHIELD_DISTANCE,
				Constant.SHIELD_DISTANCE);*/
		
	}
	
	public boolean isSpawning() {return spawning;}
}
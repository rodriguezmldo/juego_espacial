package States;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import GameObject.Constant;
import GameObject.Messege;
import GameObject.Asteroid;
import GameObject.MoveObject;
import GameObject.Spacecraft;
import GameObject.PowerUps;
import Graphics.Animation;
import Graphics.Assets;
import io.JSONParser;
import io.ScoreData;
import Math.Vector2D;
import ui.Action;

public class GameState extends State{
	public static final Vector2D PLAYER_START_POSITION = new Vector2D(Constant.WIDTH/2 - Assets.shipNormal.getWidth()/2,
			Constant.HEIGHT/2 - Assets.shipNormal.getHeight()/2);
	
	private Spacecraft player;
	private ArrayList<MoveObject> MoveObjects = new ArrayList<MoveObject>();
	private ArrayList<Animation> explosions = new ArrayList<Animation>();
	private ArrayList<Messege> Messeges = new ArrayList<Messege>();
	
	private int score = 0;
	private int lives = 3;
	
	private int Asteroids;
	private int waves = 1;
	
	private long gameOverTimer;
	private boolean gameOver;
	
	private long ufoSpawner;
	private long powerUpSpawner;
	
	
	public GameState()
	{
		player = new Spacecraft(PLAYER_START_POSITION, new Vector2D(),
				Constant.PLAYER_MAX_VEL, Assets.shipNormal, this);
		
		gameOver = false;
		MoveObjects.add(player);
		
		Asteroids = 1;
		startWave();
		
		gameOverTimer = 0;
		ufoSpawner = 0;
		powerUpSpawner = 0;
		
		gameOver = false;
		
	}
	
	
	public void addScore(int value, Vector2D position) {
		
		Color c = Color.WHITE;
		String text = "+" + value + " score";
		
		score += value;
    }
	
	private void startWave(){
		
		Messeges.add(new Messege(new Vector2D(Constant.WIDTH/2, Constant.HEIGHT/2), false,
				"WAVE "+waves, Color.WHITE, true, Assets.fontBig));
		
		double x, y;
		
		for(int i = 0; i < Asteroids; i++){
			 
			x = i % 2 == 0 ? Math.random()*Constant.WIDTH : 0;
			y = i % 2 == 0 ? 0 : Math.random()*Constant.HEIGHT;
			
			BufferedImage texture = Assets.bigs[(int)(Math.random()*Assets.bigs.length)];
			
			MoveObjects.add(new Asteroid(
					new Vector2D(x, y),
					new Vector2D(0, 1).setDirection(Math.random()*Math.PI*2),
					Constant.Asteroid_INIT_VEL*Math.random() + 1,
					texture,
					this,
					));
			
		}
		Asteroids ++;
	}
	
	public void playExplosion(Vector2D position){
		explosions.add(new Animation(
				Assets.exp,
				50,
				position.subtract(new Vector2D(Assets.exp[0].getWidth()/2, Assets.exp[0].getHeight()/2))
				));
	}
	
	private void spawnBlackhole(){
		
		int rand = (int) (Math.random()*2);
		
		double x = rand == 0 ? (Math.random()*Constant.WIDTH): Constant.WIDTH;
		double y = rand == 0 ? Constant.HEIGHT : (Math.random()*Constant.HEIGHT);
		
		ArrayList<Vector2D> path = new ArrayList<Vector2D>();
		
		double posX, posY;
		
		posX = Math.random()*Constant.WIDTH/2;
		posY = Math.random()*Constant.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));

		posX = Math.random()*(Constant.WIDTH/2) + Constant.WIDTH/2;
		posY = Math.random()*Constant.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));
		
		posX = Math.random()*Constant.WIDTH/2;
		posY = Math.random()*(Constant.HEIGHT/2) + Constant.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));
		
		posX = Math.random()*(Constant.WIDTH/2) + Constant.WIDTH/2;
		posY = Math.random()*(Constant.HEIGHT/2) + Constant.HEIGHT/2;	
		path.add(new Vector2D(posX, posY));
		
		MoveObjects.add(new Ufo(
				new Vector2D(x, y),
				new Vector2D(),
				Constant.UFO_MAX_VEL,
				Assets.ufo,
				path,
				this
				));
		
	}

	private void spawnPowerUp() {
		
		final int x = (int) ((Constant.WIDTH - Assets.orb.getWidth()) * Math.random());
		final int y = (int) ((Constant.HEIGHT - Assets.orb.getHeight()) * Math.random());
		
		int index = (int) (Math.random() * (PowerUpTypes.values().length));
		
		PowerUpTypes p = PowerUpTypes.values()[index];
		
		final String text = p.text;
		Action action = null;
		Vector2D position = new Vector2D(x , y);
		
		switch(p) {
		case LIFE:
			action = new Action() {
				@Override
				public void doAction() {
					
					lives ++;
					Messeges.add(new Messege(
							position,
							false,
							text,
							Color.GREEN,
							false,
							Assets.fontMed
							));
				}
			};
			break;
		case SHIELD:
			action = new Action() {
				@Override
				public void doAction() {
					player.setShield();
					Messeges.add(new Messege(
							position,
							false,
							text,
							Color.DARK_GRAY,
							false,
							Assets.fontMed
							));
				}
			};
			break;
		case SCORE_X2:
			action = new Action() {
				@Override
				public void doAction() {
					player.setDoubleScore();
					Messeges.add(new Messege(
							position,
							false,
							text,
							Color.YELLOW,
							false,
							Assets.fontMed
							));
				}
			};
			break;
		case FASTER_FIRE:
			action = new Action() {
				@Override
				public void doAction() {
					player.setFastFire();
					Messeges.add(new Messege(
							position,
							false,
							text,
							Color.BLUE,
							false,
							Assets.fontMed
							));
				}
			};
			break;
		case SCORE_STACK:
			action = new Action() {
				@Override
				public void doAction() {
					score += 1000;
					Messeges.add(new Messege(
							position,
							false,
							text,
							Color.MAGENTA,
							false,
							Assets.fontMed
							));
				}
			};
			break;
		case DOUBLE_GUN:
			action = new Action() {
				@Override
				public void doAction() {
					player.setDoubleGun();
					Messeges.add(new Messege(
							position,
							false,
							text,
							Color.ORANGE,
							false,
							Assets.fontMed
							));
				}
			};
			break;
		default:
			break;
		}
		
		this.MoveObjects.add(new PowerUp(
				position,
				p.texture,
				action,
				this
				));
		
		
	}
	
	public void update(float dt)
	{
		
		if(gameOver)
			gameOverTimer += dt;
		
		powerUpSpawner += dt;
		ufoSpawner += dt;
		
		for(int i = 0; i < MoveObjects.size(); i++) {
			
			MoveObject mo = MoveObjects.get(i);
			
			mo.update(dt);
			if(mo.isDead()) {
				MoveObjects.remove(i);
				i--;
			}
			
		}
		
		for(int i = 0; i < explosions.size(); i++){
			Animation anim = explosions.get(i);
			anim.update(dt);
			if(!anim.isRunning()){
				explosions.remove(i);
			}
			
		}
		
		if(gameOverTimer > Constant.GAME_OVER_TIME) {
			
			try {
				ArrayList<ScoreData> dataList = JSONParser.readFile();
				dataList.add(new ScoreData(score));
				JSONParser.writeFile(dataList);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			backgroundMusic.stop();
			
			State.changeState(new MenuState());
		}
		
		if(powerUpSpawner > Constant.POWER_UP_SPAWN_TIME) {
			spawnPowerUp();
			powerUpSpawner = 0;
		}
		
		
		if(ufoSpawner > Constant.UFO_SPAWN_RATE) {
			spawnUfo();
			ufoSpawner = 0;
		}
		
		for(int i = 0; i < MoveObjects.size(); i++)
			if(MoveObjects.get(i) instanceof Asteroid)
				return;
		
		startWave();
		
	}
	
	public void draw(Graphics g)
	{	
		Graphics2D g2d = (Graphics2D)g;
		
		g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
		
		for(int i = 0; i < Messeges.size(); i++) {
			Messeges.get(i).draw(g2d);
			if(Messeges.get(i).isDead())
				Messeges.remove(i);
		}
		
		for(int i = 0; i < MoveObjects.size(); i++)
			MoveObjects.get(i).draw(g);
		
		for(int i = 0; i < explosions.size(); i++){
			Animation anim = explosions.get(i);
			g2d.drawImage(anim.getCurrentFrame(), (int)anim.getPosition().getX(), (int)anim.getPosition().getY(),
					null);
			
		}
		drawScore(g);
		drawLives(g);
	}
	
	private void drawScore(Graphics g) {
		
		Vector2D pos = new Vector2D(850, 25);
		
		String scoreToString = Integer.toString(score);
		
		for(int i = 0; i < scoreToString.length(); i++) {
			
			g.drawImage(Assets.numbers[Integer.parseInt(scoreToString.substring(i, i + 1))],
					(int)pos.getX(), (int)pos.getY(), null);
			pos.setX(pos.getX() + 20);
			
		}
		
	}
	
	private void drawLives(Graphics g){
		
		if(lives < 1)
			return;
		
		Vector2D livePosition = new Vector2D(25, 25);
		
		g.drawImage(Assets.life, (int)livePosition.getX(), (int)livePosition.getY(), null);
		
		g.drawImage(Assets.numbers[10], (int)livePosition.getX() + 40,
				(int)livePosition.getY() + 5, null);
		
		String livesToString = Integer.toString(lives);
		
		Vector2D pos = new Vector2D(livePosition.getX(), livePosition.getY());
		
		for(int i = 0; i < livesToString.length(); i ++)
		{
			int number = Integer.parseInt(livesToString.substring(i, i+1));
			
			if(number <= 0)
				break;
			g.drawImage(Assets.numbers[number],
					(int)pos.getX() + 60, (int)pos.getY() + 5, null);
			pos.setX(pos.getX() + 20);
		}
		
	}
	
	public ArrayList<MoveObject> getMoveObjects() {
		return MoveObjects;
	}
	
	public ArrayList<Messege> getMesseges() {
		return Messeges;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public boolean subtractLife(Vector2D position) {
		lives --;
		
		Messege lifeLostMesg = new Messege(
				position,
				false,
				"-1 LIFE",
				Color.RED,
				false,
				Assets.fontMed
				);
		Messeges.add(lifeLostMesg);
		
		return lives > 0;
	}
	
	
	public void gameOver() {
		Messege gameOverMsg = new Messege(
				PLAYER_START_POSITION,
				true,
				"GAME OVER",
				Color.WHITE,
				true,
				Assets.fontBig);
		
		this.Messeges.add(gameOverMsg);
		gameOver = true;
	}
	
}
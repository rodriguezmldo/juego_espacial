package input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoard implements KeyListener{
	
	private boolean[] keys = new boolean[256];
	
	public static boolean UP, DOWN, SHOOT;
	
	public KeyBoard()
	{
		UP = false;
		DOWN = false;
		SHOOT = false;
	}
	
	public void update()
	{
		UP = keys[KeyEvent.VK_W];
		DOWN = keys[KeyEvent.VK_W];
		SHOOT = keys[KeyEvent.VK_SPACE];
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}
	
	@Override
	public void keyTyped(KeyEvent e) {}
	
}

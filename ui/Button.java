package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import Graphics.Assets;
import Graphics.Text;
import Input.MouseInput;
import Math.Vector2D;

public class Button {
	
	private BufferedImage mouseOutImg;
	private BufferedImage mouseInImg;
	private boolean mouseIn;
	private Rectangle boundingBox;
	private Action action;
	private String text;
	
	public Button(
			BufferedImage mouseOutImg,
			BufferedImage mouseInImg,
			int x, int y,
			String text,
			Action action
			) {
		this.mouseInImg = mouseInImg;
		this.mouseOutImg = mouseOutImg;
		this.text = text;
		boundingBox = new Rectangle(x, y, mouseInImg.getWidth(), mouseInImg.getHeight());
		this.action = action;
	}
}
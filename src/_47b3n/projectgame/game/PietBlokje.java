package _47b3n.projectgame.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class PietBlokje {

	private int x, y, velX, velY;
	
	public PietBlokje(int x, int y) {
		this.x = x;
		this.y = y;
		velX = new Random().nextInt(10) - 5;
		velY = new Random().nextInt(10) - 5;
	}
	
	public void tick() {
		x += velX;
		y += velY;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 32, 32);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelX() {
		return velX;
	}

	public void setVelX(int velX) {
		this.velX = velX;
	}

	public int getVelY() {
		return velY;
	}

	public void setVelY(int velY) {
		this.velY = velY;
	}
	
}

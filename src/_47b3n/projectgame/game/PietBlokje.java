package _47b3n.projectgame.game;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import _47b3n.projectgame.engine.Game;

public class PietBlokje {

	private int x, y, velX, velY;
	private int speed = 5;
	private Color color;

	public PietBlokje(int x, int y) {
		this.x = x;
		this.y = y;
		velX = (new Random().nextInt(50) - 25) + 2;
		velY = (new Random().nextInt(50) - 25) + 2;
		color = new Color(new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(255), new Random().nextInt(155) + 100);
	}

	public void tick() {
		x += velX;
		y += velY;

		if (x + 32 > Game.WIDTH) {
			setVelX(-speed);
		}
		if (x < 0) {
			setVelX(speed);
		}
		if (y + 32 > Game.HEIGHT) {
			setVelY(-speed);
		}
		if (y < 0) {
			setVelY(speed);
		}
	}

	public void render(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 32, 32);
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

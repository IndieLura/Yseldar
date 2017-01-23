package _47b3n.projectgame.engine.game;

import _47b3n.projectgame.engine.Game;

public class Camera {
	
	private float x, y;
	
	public Camera(float x, float y) {
		this.x = x;
		this.y = y;
	}

	public void tick(Player player) {
		x = -player.getX() + Game.WIDTH / 2;
		y = -player.getY() + Game.HEIGHT / 2 - player.getHeight();
	}
	
	public float getX() {
		return x;
	}

	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}

	public void setY(float y) {
		this.y = y;
	}
	
}

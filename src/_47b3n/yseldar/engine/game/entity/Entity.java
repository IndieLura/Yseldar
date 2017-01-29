package _47b3n.yseldar.engine.game.entity;

import java.awt.Graphics;
import java.awt.Rectangle;

import _47b3n.yseldar.engine.gamestate.gamestates.InGame;

public abstract class Entity {
	protected float velX = 0.0F;
	protected float velY = 0.0F;
	protected boolean falling = true;
	protected boolean jumping = false;
	protected int facing = 1;
	protected float x;
	protected float y;
	protected EntityID id;
	protected InGame inGame;

	public Entity(float x, float y, EntityID id, InGame inGame) {
		this.x = x;
		this.y = y;
		this.id = id;
		this.inGame = inGame;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

	public abstract Rectangle getBounds();

	public boolean isFalling() {
		return falling;
	}

	public void setFalling(boolean falling) {
		this.falling = falling;
	}

	public boolean isJumping() {
		return jumping;
	}

	public void setJumping(boolean jumping) {
		this.jumping = jumping;
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

	public float getVelX() {
		return velX;
	}

	public float getVelY() {
		return velY;
	}

	public void setVelX(float velX) {
		this.velX = velX;
	}

	public void setVelY(float velY) {
		this.velY = velY;
	}

	public int getFacing() {
		return facing;
	}

	public EntityID getID() {
		return id;
	}
}

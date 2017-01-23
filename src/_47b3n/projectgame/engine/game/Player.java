package _47b3n.projectgame.engine.game;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import _47b3n.projectgame.engine.game.object.Entity;
import _47b3n.projectgame.engine.game.object.EntityID;
import _47b3n.projectgame.engine.game.object.objects.StoneBlock;
import _47b3n.projectgame.engine.game.object.objects.Tree;
import _47b3n.projectgame.engine.gamestate.gamestates.InGame;
import _47b3n.projectgame.engine.gfx.ImageLoader;
import _47b3n.projectgame.engine.gfx.SpriteSheet;

public class Player {

	private float x, y;
	private float velX, velY;
	private float width = 32, height = 32;
	private float speed = 5;

	private BufferedImage texture;

	private InGame inGame;
	private LinkedList<Entity> entities;

	public Player(int x, int y, InGame inGame) {
		this.x = x;
		this.y = y;
		this.inGame = inGame;

		entities = inGame.entities;

		texture = SpriteSheet.grabImage(ImageLoader.loadImage("/gfx/sheet.png"), 9, 8, 32, 32);
	}

	public void tick() {
		x += velX;
		y += velY;

		for (int i = 0; i < entities.size(); i++) {

			if (entities.get(i).getID() == EntityID.StoneBlock) {
				StoneBlock block = (StoneBlock) entities.get(i);
				if (getBoundsTop().intersects(block.getBounds())) {
					y = block.getY() + block.getHeight();
					velY = 0;
				}
				
				if (getBoundsBottom().intersects(block.getBounds())) {
					y = block.getY() - block.getHeight();
					velY = 0;
				}
				
				if (getBoundsLeft().intersects(block.getBounds())) {
					x = block.getX() + block.getWidth();
					velX = 0;
				}
				
				if (getBoundsRight().intersects(block.getBounds())) {
					x = block.getX() - block.getWidth();
					velX = 0;
				}
			}
			
			if (entities.get(i).getID() == EntityID.Tree) {
				Tree tree = (Tree) entities.get(i);
				if (getBoundsTop().intersects(tree.getBounds())) {
					y = tree.getY() + tree.getHeight();
					velY = 0;
				}
				
				if (getBoundsBottom().intersects(tree.getBounds())) {
					y = tree.getY() - tree.getHeight();
					velY = 0;
				}
				
				if (getBoundsLeft().intersects(tree.getBounds())) {
					x = tree.getX() + tree.getWidth();
					velX = 0;
				}
				
				if (getBoundsRight().intersects(tree.getBounds())) {
					x = tree.getX() - tree.getWidth();
					velX = 0;
				}
			}
		}
	}

	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, null);
	}

	public float getX() {
		return x;
	}

	public float getY() {
		return y;
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

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public Rectangle getBoundsBottom() {
		return new Rectangle((int) x + ((int) width / 2) - ((int) (width / 2) / 2), (int) y + ((int) height / 2),
				(int) width / 2, (int) height / 2);
	}

	public Rectangle getBoundsTop() {
		return new Rectangle((int) x + ((int) width / 2) - ((int) (width / 2) / 2), (int) y, (int) width / 2,
				(int) height / 2);
	}

	public Rectangle getBoundsRight() {
		return new Rectangle((int) x + (int) width - 5, (int) y + 5, (int) 5, (int) height - 10);
	}

	public Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

}

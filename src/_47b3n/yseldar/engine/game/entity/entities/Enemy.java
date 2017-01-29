package _47b3n.yseldar.engine.game.entity.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import _47b3n.yseldar.engine.game.Player;
import _47b3n.yseldar.engine.game.entity.Entity;
import _47b3n.yseldar.engine.game.entity.EntityID;
import _47b3n.yseldar.engine.gamestate.gamestates.InGame;
import _47b3n.yseldar.engine.gfx.ImageLoader;
import _47b3n.yseldar.engine.gfx.SpriteSheet;

public class Enemy extends Entity {

	private float speed = 1;

	private Player player;
	private LinkedList<Entity> entities;

	private BufferedImage texture;
	
	public Enemy(float x, float y, EntityID id, InGame inGame) {
		super(x, y, id, inGame);

		width = 32;
		height = 32;

		texture = SpriteSheet.grabImage(ImageLoader.loadImage("/gfx/sheet.png"), 9, 1, (int) width, (int) height);
		
		entities = inGame.getEntities();
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;

		player = inGame.getPlayer();

		collision();
		followPlayer();
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, null);
	}
	
	private void collision() {
		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			if (getBoundsTop().intersects(entity.getBounds())) {
				y = entity.getY() + entity.getHeight();
				setVelY(0);
			}

			if (getBoundsBottom().intersects(entity.getBounds())) {
				y = entity.getY() - entity.getHeight();
				setVelY(0);
			}

			if (getBoundsLeft().intersects(entity.getBounds())) {
				x = entity.getX() + entity.getWidth();
				setVelX(0);
			}

			if (getBoundsRight().intersects(entity.getBounds())) {
				x = entity.getX() - entity.getWidth();
				setVelX(0);
			}
		}
	}
	
	private void followPlayer() {
		if (playerNearby()) {
			if (x < player.getX()) {
				setVelX(speed);
			}
			if (x > player.getX()) {
				setVelX(-speed);
			}
			if (y < player.getY()) {
				setVelY(speed);
			}
			if (y > player.getY()) {
				setVelY(-speed);
			}
			if (x == player.getX()) {
				setVelX(0);
			}
			if (y == player.getY()) {
				setVelY(0);
			}
		} else {
			setVelX(0);
			setVelY(0);
		}
	}


	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

	private Rectangle getBoundsBottom() {
		return new Rectangle((int) x + ((int) width / 2) - ((int) (width / 2) / 2), (int) y + ((int) height / 2),
				(int) width / 2, (int) height / 2);
	}

	private Rectangle getBoundsTop() {
		return new Rectangle((int) x + ((int) width / 2) - ((int) (width / 2) / 2), (int) y, (int) width / 2,
				(int) height / 2);
	}

	private Rectangle getBoundsRight() {
		return new Rectangle((int) x + (int) width - 5, (int) y + 5, (int) 5, (int) height - 10);
	}

	private Rectangle getBoundsLeft() {
		return new Rectangle((int) x, (int) y + 5, (int) 5, (int) height - 10);
	}

	private Rectangle getRadius() {
		return new Rectangle((int) x + ((int) width / 2) - 300, (int) y + ((int) height / 2) - 300, 600, 600);
	}
	
	private boolean playerNearby() {
		return getRadius().intersects(player.getBounds());
	}

}

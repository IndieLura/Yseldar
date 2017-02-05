package _47b3n.yseldar.engine.game.entity.entities;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import _47b3n.yseldar.engine.game.entity.Entity;
import _47b3n.yseldar.engine.game.entity.EntityID;
import _47b3n.yseldar.engine.gamestate.gamestates.InGame;
import _47b3n.yseldar.engine.gfx.ImageLoader;
import _47b3n.yseldar.engine.gfx.SpriteSheet;

public class StoneBlock extends Entity {

	private BufferedImage texture;

	public StoneBlock(float x, float y, EntityID id, InGame inGame) {
		super(x, y, id, inGame);

		width = 32;
		height = 32;

		texture = SpriteSheet.grabImage(ImageLoader.loadImage("/gfx/sheet.png"), 2, 1, 32, 32);
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.drawImage(texture, (int) x, (int) y, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

}

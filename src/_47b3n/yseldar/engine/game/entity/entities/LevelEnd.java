package _47b3n.yseldar.engine.game.entity.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import _47b3n.yseldar.engine.game.entity.Entity;
import _47b3n.yseldar.engine.game.entity.EntityID;
import _47b3n.yseldar.engine.gamestate.gamestates.InGame;

public class LevelEnd extends Entity {

	public LevelEnd(float x, float y, EntityID id, InGame inGame) {
		super(x, y, id, inGame);

		width = 32;
		height = 32;
	}

	@Override
	public void tick() {

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.MAGENTA);
		g.fillRect((int) x, (int) y, (int) width, (int) height);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle((int) x, (int) y, (int) width, (int) height);
	}

}

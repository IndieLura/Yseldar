package _47b3n.yseldar.engine.gamestate;

import java.awt.Graphics;

public abstract class GameState {

	public abstract void tick();
	
	public abstract void render(Graphics g);

	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}

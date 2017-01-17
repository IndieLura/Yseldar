package _47b3n.projectgame.engine;

import java.awt.Graphics;

import _47b3n.projectgame.engine.gamestate.GameStateHandler;
import _47b3n.projectgame.engine.gamestate.gamestates.InGame;

public class Handler {

	private GameStateHandler gameStateHandler;
	
	public Handler() {
		gameStateHandler = new GameStateHandler(new InGame());
	}
	
	public void tick() {
		gameStateHandler.tick();
	}
	
	public void render(Graphics g) {
		gameStateHandler.render(g);
	}
	
}

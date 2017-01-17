package _47b3n.projectgame.engine;

import java.awt.Graphics;

import _47b3n.projectgame.engine.gamestate.GameState;
import _47b3n.projectgame.engine.gamestate.gamestates.InGame;

public class Handler {
	
	private GameState gameState;
	
	public Handler() {
		setGameState(new InGame());
	}
	
	public void tick() {
		gameState.tick();
	}
	
	public void render(Graphics g) {
		gameState.render(g);
	}
	
	public void setGameState(GameState gameState) {
		this.gameState = gameState;
	}
	
	public GameState getGameState() {
		return gameState;
	}
	
}

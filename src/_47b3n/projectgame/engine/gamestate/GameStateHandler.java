package _47b3n.projectgame.engine.gamestate;

import java.awt.Graphics;

public class GameStateHandler {

	private GameState gameState;
	
	public GameStateHandler(GameState gameState) {
		setGameState(gameState);
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

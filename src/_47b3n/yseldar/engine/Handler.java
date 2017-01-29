package _47b3n.yseldar.engine;

import java.awt.Graphics;

import _47b3n.yseldar.engine.gamestate.GameState;
import _47b3n.yseldar.engine.gamestate.gamestates.InGame;

public class Handler {
	
	private GameState gameState;
	private InGame inGame;
	
	public Handler() {
		inGame = new InGame();
		setGameState(inGame);
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
	
	public InGame getInGame() {
		return inGame;
	}
	
}

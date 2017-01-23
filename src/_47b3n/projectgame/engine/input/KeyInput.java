package _47b3n.projectgame.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import _47b3n.projectgame.engine.Handler;
import _47b3n.projectgame.engine.game.Player;

public class KeyInput implements KeyListener {

	private Handler handler;
	private Player player;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (handler.getGameState() == handler.getInGame()) {
			player = handler.getInGame().getPlayer();
			
			//CONTROLS OF PLAYER
			if (key == KeyEvent.VK_W) {
				player.setVelY(-player.getSpeed());
			}
			if (key == KeyEvent.VK_A) {
				player.setVelX(-player.getSpeed());
			}
			if (key == KeyEvent.VK_S) {
				player.setVelY(player.getSpeed());
			}
			if (key == KeyEvent.VK_D) {
				player.setVelX(player.getSpeed());
			}
			//END OF CONTROLS OF PLAYER
			
			if (key == KeyEvent.VK_H) {
				handler.getInGame().showHud(true);
			}
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		if (handler.getGameState() == handler.getInGame()) {
			
			//CONTROLS OF PLAYER
			if (key == KeyEvent.VK_W) {
				player.setVelY(0);
			}
			if (key == KeyEvent.VK_A) {
				player.setVelX(0);
			}
			if (key == KeyEvent.VK_S) {
				player.setVelY(0);
			}
			if (key == KeyEvent.VK_D) {
				player.setVelX(0);
			}
			//END OF CONTROLS OF PLAYER
			
			if (key == KeyEvent.VK_H) {
				handler.getInGame().showHud(false);
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {}
}

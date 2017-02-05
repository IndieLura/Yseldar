package _47b3n.yseldar.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import _47b3n.yseldar.engine.Handler;
import _47b3n.yseldar.engine.game.Player;
import _47b3n.yseldar.engine.gamestate.gamestates.InGame;

public class KeyInput implements KeyListener {

	private Handler handler;
	private Player player;

	public KeyInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		// INGAME CONTROLS
		if (handler.getGameState() instanceof InGame) {

			// CONTROLS OF PLAYER
			InGame inGame = (InGame) handler.getGameState();
			if (inGame.getPlayer() != null) {
				player = inGame.getPlayer();

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
			}
			// END OF CONTROLS OF PLAYER
		}
		// END OF INGAME CONTROLS
	}

	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		// INGAME CONTROLS
		if (handler.getGameState() instanceof InGame) {

			// CONTROLS OF PLAYER
			InGame inGame = (InGame) handler.getGameState();
			if (inGame.getPlayer() != null) {
				player = inGame.getPlayer();

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
				if (key == KeyEvent.VK_SPACE) {
					player.attack();
				}
			}
			// END OF CONTROLS OF PLAYER

			if (key == KeyEvent.VK_H) {
				if (inGame.showsHud() == true) {
					inGame.showHud(false);
				} else if (inGame.showsHud() == false) {
					inGame.showHud(true);
				}
			}
		}
		// END OF INGAME CONTROLS

		if (key == KeyEvent.VK_ESCAPE) {
			System.exit(1);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}

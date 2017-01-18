package _47b3n.projectgame.engine.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import _47b3n.projectgame.engine.Handler;

public class KeyInput implements KeyListener {

	private Handler handler;
	
	public KeyInput(Handler handler) {
		this.handler = handler;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		/*if (key == KeyEvent.VK_W) {
			handler.inGame.blok.setVelY(-1);
		}
		if (key == KeyEvent.VK_A) {
			handler.inGame.blok.setVelX(-1);
		}
		if (key == KeyEvent.VK_S) {
			handler.inGame.blok.setVelY(1);
		}
		if (key == KeyEvent.VK_D) {
			handler.inGame.blok.setVelX(1);
		}*/
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		/*handler.inGame.blok.setVelX(0);
		handler.inGame.blok.setVelY(0);*/
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

}

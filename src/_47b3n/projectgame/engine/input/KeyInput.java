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
		
		if (key == KeyEvent.VK_ESCAPE) {
			System.out.println("Exiting..");
			System.exit(1);
		}
		
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

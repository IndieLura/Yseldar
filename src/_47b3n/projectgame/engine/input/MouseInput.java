package _47b3n.projectgame.engine.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import _47b3n.projectgame.engine.Handler;

public class MouseInput implements MouseListener {

	private Handler handler;

	public MouseInput(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			System.out.println(handler.getGameState().toString());
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {

	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {

	}
}

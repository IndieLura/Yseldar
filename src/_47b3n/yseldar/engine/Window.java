package _47b3n.yseldar.engine;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Window {

	public Window(String title, int w, int h, Game game) {
		game.setMaximumSize(new Dimension(w, h));
		game.setPreferredSize(new Dimension(w, h));
		game.setMinimumSize(new Dimension(w, h));

		JFrame frame = new JFrame(title);
		frame.add(game);
		frame.pack();
		frame.setDefaultCloseOperation(3);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		game.start();
	}

}

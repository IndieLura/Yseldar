package _47b3n.projectgame.engine.game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import _47b3n.projectgame.engine.Game;

public class TextBubble {

	private int x, y;
	
	private String msg;
	private boolean show = false;
	
	private Font fontMsg;

	public TextBubble() {
		this.x = 0;
		this.y = Game.HEIGHT - 200;
		
		fontMsg = new Font("Verdana", Font.BOLD, 14);
	}
	
	public void toggleTextBubble(boolean show, String msg) {
		this.show = show;
		this.msg = msg;
	}

	public void tick() {
		
	}

	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.setFont(fontMsg);
		if (msg.contains("\n")) {
			for (String line : msg.split("\n")) {
		        g.drawString(line, x, y);
		        y += 18;
			}
		} else {
			g.drawString(msg, x, y);
		}
	}
	
	public boolean getShow() {
		return show;
	}

}

package _47b3n.projectgame.engine.gamestate.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import _47b3n.projectgame.engine.Game;
import _47b3n.projectgame.engine.gamestate.GameState;
import _47b3n.projectgame.game.PietBlokje;

public class InGame extends GameState {

	private float score = 0;
	
	private Font fontHud;
	
	public PietBlokje blok;
	
	public InGame() {
		fontHud = new Font("Verdana", Font.PLAIN, 12);
		blok = new PietBlokje(10, 10);
	}
	
	@Override
	public void tick() {
		score+= 0.1;
		blok.tick();
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);
		
		//START OF BACKGROUND
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		//END OF BACKGROUND
		
		//DRAW FROM HERE
		blok.render(g);
		//TO HERE
		
		//START OF HUD
		g.setColor(Color.BLACK);
		g.setFont(fontHud);
		g.drawString("SCORE: " + (int) score, 10, 20);
		//END OF HUD
	}

}

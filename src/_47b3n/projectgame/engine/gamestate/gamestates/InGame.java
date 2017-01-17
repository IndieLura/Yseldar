package _47b3n.projectgame.engine.gamestate.gamestates;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import _47b3n.projectgame.engine.Game;
import _47b3n.projectgame.engine.gamestate.GameState;

public class InGame extends GameState {

	@Override
	public void tick() {
		
	}

	@Override
	public void render(Graphics g) {
		g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
		
		g.setColor(Color.ORANGE);
		g.fillRect(new Random().nextInt(Game.WIDTH), new Random().nextInt(Game.HEIGHT), new Random().nextInt(20) + 5, new Random().nextInt(20) + 5);
	}

}

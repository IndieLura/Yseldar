package _47b3n.yseldar.engine.gamestate.gamestates;

import java.awt.Color;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

import java.util.LinkedList;

import _47b3n.yseldar.engine.Game;
import _47b3n.yseldar.engine.game.Camera;
import _47b3n.yseldar.engine.game.Player;
import _47b3n.yseldar.engine.game.entity.Entity;
import _47b3n.yseldar.engine.game.entity.EntityID;
import _47b3n.yseldar.engine.game.entity.entities.Enemy;
import _47b3n.yseldar.engine.game.entity.entities.LevelEnd;
import _47b3n.yseldar.engine.game.entity.entities.StoneBlock;
import _47b3n.yseldar.engine.game.entity.entities.Tree;
import _47b3n.yseldar.engine.gamestate.GameState;
import _47b3n.yseldar.engine.gfx.ImageLoader;

public class InGame extends GameState {

	private Font fontHud;
	private boolean showHud = true;

	private int level = 1;
	private int maxLevel = 2;
	
	private Player player;
	private Camera cam;
	
	public LinkedList<Entity> entities = new LinkedList<Entity>();

	private GradientPaint backgroundGradient;

	public InGame() {
		BufferedImage level1 = ImageLoader.loadImage("/levels/level1.bmp");
		loadLevel(level1);
		System.out.println("/levels/level" + level + ".bmp");

		fontHud = new Font("Verdana", Font.PLAIN, 12);
		cam = new Camera(0, 0);

		backgroundGradient = new GradientPaint(0, 0, new Color(100, 200, 244), 0, Game.HEIGHT + 400, new Color(84, 167, 204));
	}

	@Override
	public void tick() {
		player.tick();
		cam.tick(player);
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).tick();
		}

		if (player.getHealth() <= 0)
			restartLevel();
	}

	@Override
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_GASP);

		// START OF BACKGROUND
		g2d.setPaint(backgroundGradient);
		g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);
		// END OF BACKGROUND

		// DRAW FROM HERE
		g2d.translate((int) cam.getX(), (int) cam.getY());

		for (int i = 0; i < entities.size(); i++) {
			if (getBounds().intersects(entities.get(i).getBounds())) {				
				entities.get(i).render(g);
			}
		}
		player.render(g);

		g2d.translate((int) -cam.getX(), (int) -cam.getY());
		// TO HERE

		// START OF HUD
		if (showHud) {
			g.setColor(Color.BLACK);
			g.setFont(fontHud);
			g.drawString("SCORE: ", 10, 20);
			g.drawString("LEVEL: " + level, 10, 33);

			// HEALTH BAR
			g.drawString("HEALTH: ", 10, Game.HEIGHT - 10);

			g.setColor(Color.GREEN);
			g.fillRect(70, Game.HEIGHT - 21, (int) player.getHealth(), 12);

			g.setColor(Color.BLACK);
			g.drawRect(70, Game.HEIGHT - 21, 100, 12);
		}
		// END OF HUD
	}

	private void loadLevel(BufferedImage image) {
		int w = image.getWidth();
		int h = image.getHeight();
		System.out.println(w + " " + h);

		for (int xx = 0; xx < h; xx++) {
			for (int yy = 0; yy < w; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				if (red == 0 && green == 0 && blue == 255)
					player = new Player(xx * 32, yy * 32, this);
				if (red == 200 && green == 200 && blue == 200)
					addEntity(new StoneBlock(xx * 32, yy * 32, EntityID.StoneBlock, this));
				if (red == 0 && green == 255 && blue == 0)
					addEntity(new Tree(xx * 32, yy * 32, EntityID.Tree, this));
				if (red == 255 && green == 0 && blue == 255)
					addEntity(new LevelEnd(xx * 32, yy * 32, EntityID.LevelEnd, this));
				if (red == 123 && green == 123 && blue == 123)
					addEntity(new Enemy(xx * 32, yy * 32, EntityID.Enemy, this));
			}
		}

		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).getID() == EntityID.Enemy) {
				((Enemy) entities.get(i)).setPlayer(player);
			}
		}

	}

	public void levelUp() {
		level++;
		
		if (level <= maxLevel) {
			entities.clear();
			player.resetHealth();
			
			BufferedImage levelImg = ImageLoader.loadImage("/levels/level" + level + ".bmp");
			System.out.println("/levels/level" + level + ".bmp");
			loadLevel(levelImg);
		} else {
			System.out.println("Finish");
		}
	}
	
	private void restartLevel() {
		entities.clear();
		player.resetHealth();

		BufferedImage levelImg = ImageLoader.loadImage("/levels/level" + level + ".bmp");
		System.out.println("/levels/level" + level + ".bmp");
		loadLevel(levelImg);
	}

	public LinkedList<Entity> getEntities() {
		return entities;
	}

	public void addEntity(Entity entity) {
		entities.add(entity);
	}

	public void removeEntity(Entity entity) {
		entities.remove(entity);
	}

	public void showHud(boolean showHud) {
		this.showHud = showHud;
	}

	public boolean showsHud() {
		return showHud;
	}
	
	public Player getPlayer() {
		return player;
	}

	public Rectangle getBounds() {
		return new Rectangle((int) -cam.getX(), (int) -cam.getY(), Game.WIDTH, Game.HEIGHT);
	}

}

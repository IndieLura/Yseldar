package _47b3n.yseldar.engine;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import _47b3n.yseldar.engine.input.KeyInput;
import _47b3n.yseldar.engine.input.MouseInput;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = -1650647469312364898L;
	
	private String title = "YSELDAR";
	
	public static int WIDTH, HEIGHT;
	
	private Thread thread;
	private boolean running = false;
	
	private Handler handler;
	
	public Game() {
		new Window(title, 800, 600, this);
	}

	private void init() {
		WIDTH = getWidth();
		HEIGHT = getHeight();
		
		handler = new Handler();
		
		addKeyListener(new KeyInput(handler));
		addMouseListener(new MouseInput(handler));
	}
	
	@Override
	public void run() {
		this.requestFocus();
		init();
		
		long lastTime = System.nanoTime();
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 120.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				tick();
				updates++;
				delta--;
			}

			render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}

		}

	}

	private void tick() {
		handler.tick();
	}
	
	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		//Graphics2D g2d = (Graphics2D) g;

		handler.render(g);

		g.dispose();
		bs.show();
	}

	public void start() {
		if (running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public static void main(String[] args) {
		new Game();
	}
}

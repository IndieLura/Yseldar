package _47b3n.yseldar.engine.gfx;

import java.awt.image.BufferedImage;

public class SpriteSheet {

	public static BufferedImage grabImage(BufferedImage image, int col, int row, int width, int height) {
		BufferedImage img = image.getSubimage((col * width) - width, (row * height) - height, width, height);
		
		return img;
	}

}

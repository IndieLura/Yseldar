package _47b3n.projectgame.engine.gfx;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {

	private static BufferedImage image;

	public static BufferedImage loadImage(String path) {

		try {
			image = ImageIO.read(ImageLoader.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return image;
	}

}

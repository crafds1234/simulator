package com.simulator.resources;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.imageio.ImageIO;

public class BreadboardResources {
	
	private static BreadboardResources instance;
	
	private Map<String, Image> cache;
	
	private BreadboardResources() {
		super();
	}
	
	public static BreadboardResources getInstance() {
		if(instance == null) {
			instance = new BreadboardResources();
		}
		
		return instance;
	}
	
	public Image getBackground() {
		InputStream io = getClass().getResourceAsStream("bg.png");
		Image scaledImage = null;
		try {
			Image image = ImageIO.read(io);
			return image;
			//scaledImage = image.getScaledInstance(550, 460, 0);
		} catch (IOException e) {

			e.printStackTrace();
		}

		return scaledImage;
	}
}

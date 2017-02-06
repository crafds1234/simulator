package com.simulator.util;

import java.awt.Image;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.simulator.model.LogicGate;
import com.simulator.model.components.AndLogicGate;
import com.simulator.model.components.LightBulb;
import com.simulator.model.components.NandLogicGate;
import com.simulator.model.components.OrLogicGate;
import com.simulator.model.components.BSwitch;
import com.simulator.model.components.XnorLogicGate;
import com.simulator.model.components.XorLogicGate;
import com.simulator.resources.BreadboardResources;

public class LogicGateImageFactory {

	private static LogicGateImageFactory factory;

	public final String OR = "or";
	public final String AND = "and";
	public final String NAND = "NAND";
	public final String XNOR = "xnor";
	public final String XOR = "xor";

	public final int IMAGE_WIDTH = 60;
	public final int IMAGE_HEIGHT = 50;

	private Map<String, Image> cache;

	private LogicGateImageFactory() {
		cache = new HashMap<>();

		try {
			InputStream io1 = BreadboardResources.class.getResourceAsStream("lightbulboff.png");
			Image image1 = ImageIO.read(io1);
			Image scaledImage1 = image1.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, 0);
			cache.put("lightoff", scaledImage1);

			InputStream io2 = BreadboardResources.class.getResourceAsStream("lightbulbon.png");
			Image image2 = ImageIO.read(io2);
			Image scaledImage2 = image2.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, 0);
			cache.put("lighton", scaledImage2);
			
//			InputStream io3 = BreadboardResources.class.getResourceAsStream("switchoff.png");
//			Image image3 = ImageIO.read(io3);
//			Image scaledImage3 = image3.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, 0);
//			cache.put("switchoff", scaledImage3);
//			
//			InputStream io4 = BreadboardResources.class.getResourceAsStream("switchon.png");
//			Image image4 = ImageIO.read(io4);
//			Image scaledImage4 = image4.getScaledInstance(IMAGE_WIDTH, IMAGE_HEIGHT, 0);
//			cache.put("switchon", scaledImage4);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static LogicGateImageFactory getInstance() {
		if (factory == null) {
			factory = new LogicGateImageFactory();
		}

		return factory;
	}

	private Image getImageFromCache(String key) {
		Image image = cache.get(key);
		return image;
	}

	private void setImageToCache(String key, Image image) {
		cache.put(key, image);
	}

	public Image getGateImage(String gate) throws IOException {
		Image cachedImage = getImageFromCache(gate);
		if (cachedImage != null) {
			return cachedImage;
		}

		InputStream io = BreadboardResources.class.getResourceAsStream(gate + ".png");
		Image image = ImageIO.read(io);
		Image scaledImage = image.getScaledInstance(60, 50, 0);

		setImageToCache(gate, scaledImage);

		return scaledImage;
	}

	public LogicGate getGateModel(String key) {
		LogicGate gate = null;

		switch (key) {
		case OR:
			gate = new OrLogicGate();
			break;
		case AND:
			gate = new AndLogicGate();
			break;
		case NAND:
			gate = new NandLogicGate();
			break;
		case XNOR:
			gate = new XnorLogicGate();
			break;
		case XOR:
			gate = new XorLogicGate();
			break;
		default:
			break;
		}
		gate.setHeight(IMAGE_HEIGHT);
		gate.setWidth(IMAGE_WIDTH);
		gate.setLabel(key);
		return gate;
	}

	public LightBulb getNewLightBulb() {
		LightBulb bulb = new LightBulb(cache.get("lightoff"), cache.get("lighton"));
		bulb.setHeight(IMAGE_HEIGHT);
		bulb.setWidth(IMAGE_WIDTH);
		return bulb;
	}
	
	public BSwitch getNewSwitch() {
		BSwitch bSwitch = new BSwitch(cache.get("switchoff"), cache.get("switchon"));
		bSwitch.setHeight(IMAGE_HEIGHT);
		bSwitch.setWidth(IMAGE_WIDTH);
		return bSwitch;
	}

}

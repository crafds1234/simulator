package com.simulator.util;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.simulator.model.LogicGate;
import com.simulator.model.components.AndLogicGate;
import com.simulator.model.components.NandLogicGate;
import com.simulator.model.components.OrLogicGate;
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
	}
	
	public static LogicGateImageFactory getInstance() {
		if(factory == null) {
			factory = new LogicGateImageFactory();
		}
		
		return factory;
	}
	
	private Image getImageFromCache(String key) {
		Image image = cache.get(key);
		return image;
	}
	
	private void setImageToCache(String key , Image image) {
		cache.put(key, image);
	}
	
	public Image getGateImage(String gate) throws IOException {
		Image cachedImage = getImageFromCache(gate);
		if(cachedImage != null) {
			return cachedImage;
		}
		
		InputStream io = BreadboardResources.class.getResourceAsStream(gate + ".png");
		Image image = ImageIO.read(io);
		Image scaledImage = image.getScaledInstance(60, 50, 0);
		
		setImageToCache(gate, scaledImage);
		
		return scaledImage;
	}
	
	public LogicGate getGateModel(String key) {
		LogicGate gate = null;;
		
		switch(key) {
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

}

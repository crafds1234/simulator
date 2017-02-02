package com.simulator.components;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.simulator.components.events.CanvasMouseListener;
import com.simulator.components.events.CanvasMouseMotionListener;
import com.simulator.model.LogicGate;
import com.simulator.util.LogicGateImageFactory;

public class BreadboardCanvas extends Canvas {
	
	/**	 * 	 */
	private static final long serialVersionUID = -2080848459113950071L;
	
	private LogicGateImageFactory factory;
	
	private List<LogicGate> entities;
	
	
	public BreadboardCanvas() {
		super();
		setSize(550, 460);
		setBackground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		entities = new ArrayList<>();
		factory = LogicGateImageFactory.getInstance();
		
		addMouseListener(new CanvasMouseListener(this));
		addMouseMotionListener(new CanvasMouseMotionListener(this));
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		for (LogicGate gate : entities) {
			g.drawImage(gate.getImage(), gate.getCenterX(), gate.getCenterY(), null);
			g.drawString(gate.getLabel(), gate.getCenterX() + 15,gate.getCenterY() - 5 );
		}
	}
	
	public void addLogictGateToPaint(String strGate, int x, int y) {
		try {
			LogicGate gate = factory.getGateModel(strGate);
			Image image = factory.getGateImage(strGate);
			gate.setImage(image);
			gate.setX(x);
			gate.setY(y);
			
			entities.add(gate);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("lol buggers");
		}

	}
	
	public void removeLogictGateToPaint(LogicGate gate) {
		if(entities.contains(gate)) {
			entities.remove(gate);
		}
	}
	
	public void clear() {
		getGraphics().clearRect(0, 0, 550, 460);
	}
	
	public boolean hasAnyHitBox(int x , int y) {
		for (LogicGate logicGate : entities) {
			if(logicGate.isHitbox(x, y)) {
				return true;
			}
		}
		return false;
	}

	public List<LogicGate> getEntities() {
		return entities;
	}

	public void setEntities(List<LogicGate> entities) {
		this.entities = entities;
	}
}

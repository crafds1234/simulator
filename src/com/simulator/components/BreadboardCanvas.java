package com.simulator.components;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import com.simulator.components.events.CanvasMouseListener;
import com.simulator.components.events.CanvasMouseMotionListener;
import com.simulator.model.LogicGate;
import com.simulator.model.Subscriber;
import com.simulator.resources.BreadboardResources;
import com.simulator.util.EntitiesManagerFactory;
import com.simulator.util.LogicGateImageFactory;

public class BreadboardCanvas extends Canvas implements Subscriber {
	
	/**	 * 	 */
	private static final long serialVersionUID = -2080848459113950071L;
	
	private EntitiesManagerFactory entitiesManager;
	private BreadboardResources resourceManager;
	
	public BreadboardCanvas() {
		super();
		setSize(550, 460);
		setBackground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		resourceManager = BreadboardResources.getInstance();
		entitiesManager = EntitiesManagerFactory.getInstance();
		entitiesManager.addSubscriber(this);
		
		addMouseListener(new CanvasMouseListener());
		addMouseMotionListener(new CanvasMouseMotionListener());
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
	}
	
	@Override
	public void update(Graphics g) {
		super.update(g);
		for (LogicGate gate : entitiesManager.getLogicGateEntities()) {
			g.drawImage(gate.getImage(), gate.getCenterX(), gate.getCenterY(), null);
			g.drawString(gate.getLabel(), gate.getCenterX() + 15,gate.getCenterY() - 5 );
		}
		
//		for (LogicGate gate : entitiesManager.getEntities()) {
//			if(gate.getFirstConnectionEntry() != null && gate.getSecondConnectionEntry() != null) {
//				
//			}
//		}
	}
	
	
	
	public void clear() {
		getGraphics().clearRect(0, 0, 550, 460);
	}

	@Override
	public void respond() {
		repaint();
	}
	
}

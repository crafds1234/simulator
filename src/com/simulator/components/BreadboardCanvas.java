package com.simulator.components;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;

import com.simulator.components.events.CanvasMouseListener;
import com.simulator.components.events.CanvasMouseMotionListener;
import com.simulator.model.ConnectionEntry;
import com.simulator.model.LogicGate;
import com.simulator.model.Subscriber;
import com.simulator.model.components.LightBulb;
import com.simulator.resources.BreadboardResources;
import com.simulator.util.EntitiesManagerFactory;

public class BreadboardCanvas extends Canvas implements Subscriber {

	/** * */
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

		for (LightBulb bulb : entitiesManager.getLightBulbEntities()) {
			g.drawImage(bulb.getImage(), bulb.getCenterX(), bulb.getCenterY(), null);
		}

		for (LogicGate gate : entitiesManager.getLogicGateEntities()) {
			g.drawImage(gate.getImage(), gate.getCenterX(), gate.getCenterY(), null);
			g.drawString(gate.getLabel(), gate.getCenterX() + 15, gate.getCenterY() - 5);
			g.drawOval(gate.getConnectorFirstX(), gate.getConnectorFirstY(), 8, 8);
			g.drawOval(gate.getConnectorSecondX(), gate.getConnectorSecondY(), 8, 8);
			g.drawOval(gate.getConnectorThirdX(), gate.getConnectorThirdY(), 8, 8);

			Color defaultColor = g.getColor();
			if (gate.getFirstConnectionEntry().isHasConnection()) {
				ConnectionEntry entry = gate.getFirstConnectionEntry();
				LogicGate entityBind = (LogicGate) entry.getEntityBind();
				g.setColor(Color.BLUE);
				g.drawLine(gate.getConnectorFirstX(), gate.getConnectorFirstY(), entityBind.getConnectorThirdX(),
						entityBind.getConnectorThirdY());
				g.setColor(defaultColor);
			}

			if (gate.getSecondConnectionEntry().isHasConnection()) {
				ConnectionEntry entry = gate.getSecondConnectionEntry();
				LogicGate entityBind = (LogicGate) entry.getEntityBind();
				g.setColor(Color.BLUE);
				g.drawLine(gate.getConnectorSecondX(), gate.getConnectorSecondY(), entityBind.getConnectorThirdX(),
						entityBind.getConnectorThirdY());
				g.setColor(defaultColor);
			}
		}

	}

	public void clear() {
		getGraphics().clearRect(0, 0, 550, 460);
	}

	@Override
	public void respond() {
		repaint();
	}

}

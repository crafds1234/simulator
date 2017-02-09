package com.simulator.components;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;

import com.simulator.components.events.CanvasMouseListener;
import com.simulator.components.events.CanvasMouseMotionListener;
import com.simulator.model.ConnectionEntry;
import com.simulator.model.LogicGate;
import com.simulator.model.Subscriber;
import com.simulator.model.components.BSwitch;
import com.simulator.model.components.LightBulb;
import com.simulator.resources.BreadboardResources;
import com.simulator.util.EntitiesManagerFactory;

public class BreadboardCanvas extends Canvas implements Subscriber, Printable {

	/** * */
	private static final long serialVersionUID = -2080848459113950071L;
	
	public static Canvas canvas;

	private EntitiesManagerFactory entitiesManager;
	private BreadboardResources resourceManager;

	private final int MARGINY = 4;
	private final int MARGINX = 4;

	public BreadboardCanvas() {
		super();
		setSize(550, 460);
		setBackground(Color.WHITE);
		setCursor(new Cursor(Cursor.HAND_CURSOR));

		canvas = this;
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
		Color defaultColor = g.getColor();
		for (LightBulb bulb : entitiesManager.getLightBulbEntities()) {
			g.drawImage(bulb.getImage(), bulb.getCenterX(), bulb.getCenterY(), null);
			g.drawOval(bulb.getConnectorFirstX(), bulb.getConnectorFirstY(), 8, 8);

			if (!bulb.getFirstConnectionEntry().isHasConnection()) {
				continue;
			}
			g.setColor(Color.BLUE);
			ConnectionEntry entry = bulb.getFirstConnectionEntry();
			if (entry.getEntityBind() instanceof BSwitch) {
				BSwitch entityBind = (BSwitch) entry.getEntityBind();
				g.drawLine(bulb.getConnectorFirstX() + MARGINX, bulb.getConnectorFirstY() + MARGINY,
						entityBind.getConnectorFirstX() + MARGINX, entityBind.getConnectorFirstY() + MARGINY);
			} else {
				LogicGate entityBind = (LogicGate) entry.getEntityBind();
				g.drawLine(bulb.getConnectorFirstX() + MARGINX, bulb.getConnectorFirstY() + MARGINY,
						entityBind.getConnectorThirdX() + MARGINX, entityBind.getConnectorThirdY() + MARGINY);
			}

			g.setColor(defaultColor);
		}

		for (BSwitch bSwitch : entitiesManager.getSwitchEntities()) {
			g.drawImage(bSwitch.getImage(), bSwitch.getCenterX(), bSwitch.getCenterY(), null);
			g.drawOval(bSwitch.getConnectorFirstX(), bSwitch.getConnectorFirstY(), 8, 8);
		}

		for (LogicGate gate : entitiesManager.getLogicGateEntities()) {
			g.drawImage(gate.getImage(), gate.getCenterX(), gate.getCenterY(), null);
			g.drawString(gate.getLabel(), gate.getCenterX() + 15, gate.getCenterY() - 5);
			g.drawOval(gate.getConnectorFirstX(), gate.getConnectorFirstY(), 8, 8);
			g.drawOval(gate.getConnectorSecondX(), gate.getConnectorSecondY(), 8, 8);
			g.drawOval(gate.getConnectorThirdX(), gate.getConnectorThirdY(), 8, 8);

			g.setColor(Color.BLUE);
			if (gate.getFirstConnectionEntry().isHasConnection()) {
				ConnectionEntry entry = gate.getFirstConnectionEntry();
				if (entry.getEntityBind() instanceof BSwitch) {
					BSwitch entityBind = (BSwitch) entry.getEntityBind();
					g.drawLine(gate.getConnectorFirstX() + MARGINX, gate.getConnectorFirstY() + MARGINY,
							entityBind.getConnectorFirstX() + MARGINX, entityBind.getConnectorFirstY() + MARGINY);

				} else {
					LogicGate entityBind = (LogicGate) entry.getEntityBind();
					g.drawLine(gate.getConnectorFirstX() + MARGINX, gate.getConnectorFirstY() + MARGINY,
							entityBind.getConnectorThirdX() + MARGINX, entityBind.getConnectorThirdY() + MARGINY);

				}

			}

			if (gate.getSecondConnectionEntry().isHasConnection()) {
				ConnectionEntry entry = gate.getSecondConnectionEntry();
				if (entry.getEntityBind() instanceof BSwitch) {
					BSwitch entityBind = (BSwitch) entry.getEntityBind();
					g.drawLine(gate.getConnectorSecondX() + MARGINX, gate.getConnectorSecondY() + MARGINY,
							entityBind.getConnectorFirstX() + MARGINX, entityBind.getConnectorFirstY() + MARGINY);
				} else {
					LogicGate entityBind = (LogicGate) entry.getEntityBind();
					g.drawLine(gate.getConnectorSecondX() + MARGINX, gate.getConnectorSecondY() + MARGINY,
							entityBind.getConnectorThirdX() + MARGINX, entityBind.getConnectorThirdY() + MARGINY);
				}
			}

			g.setColor(defaultColor);
		}

	}

	public void clear() {
		getGraphics().clearRect(0, 0, 550, 460);
	}

	@Override
	public void respond() {
		repaint();
	}

	@Override
	public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
		// TODO Auto-generated method stub
		return 0;
	}

}

package com.simulator.components.events;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import com.simulator.components.BreadboardCanvas;
import com.simulator.model.AppStates;
import com.simulator.model.LogicGate;
import com.simulator.util.ApplicationStateManager;
import com.simulator.util.EntitiesManagerFactory;
import com.simulator.util.LogicGateImageFactory;

public class CanvasMouseListener implements MouseListener {
	
	
	private LogicGateImageFactory factory;
	private ApplicationStateManager stateManager;
	private EntitiesManagerFactory entitiesManager;
	
	public CanvasMouseListener() {
		super();
		factory = LogicGateImageFactory.getInstance();
		stateManager = ApplicationStateManager.getInstance();
		entitiesManager = EntitiesManagerFactory.getInstance();
	}
	
	private void doConnection(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(!entitiesManager.hasAnyHitBox(x, y) && !(entitiesManager.getEntityOnHitBox(x, y) instanceof LogicGate)) {
			System.out.println("Nothing selected");
			return;
		}
		
		System.out.println("Connecting ");
		if(stateManager.isConnectingStart()) {
			LogicGate firstGate = (LogicGate) entitiesManager.getEntityOnHitBox(x, y);
			entitiesManager.setConnectingFirstGate(firstGate);
			stateManager.setState(AppStates.CONNECT_END);
		} else {
			LogicGate firstGate = entitiesManager.getConnectingFirstGate();
			LogicGate secondGate = (LogicGate) entitiesManager.getEntityOnHitBox(x, y);
			stateManager.setState(AppStates.EMPTY);
		}

			
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		
		if(stateManager.isConnecting()) {
			doConnection(e);
			return; //do nothing besides connect
		}
		
		if(entitiesManager.hasAnyHitBox(x, y)) {
			stateManager.setState(AppStates.DRAG); // existing component is selected
		} else if(stateManager.isAdding()) {
			entitiesManager.addLogictGateToPaint(stateManager.getGateToAdd(), e.getX(), e.getY());				
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse Entered");
	}

	@Override
	public void mouseExited(MouseEvent e) {
		
	}

}

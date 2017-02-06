package com.simulator.components.events;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import com.simulator.components.BreadboardCanvas;
import com.simulator.model.CanvasEntity;
import com.simulator.model.LogicGate;
import com.simulator.util.ApplicationStateManager;
import com.simulator.util.EntitiesManagerFactory;
import com.simulator.util.LogicGateImageFactory;

public class CanvasMouseMotionListener implements MouseMotionListener {
	
	private LogicGateImageFactory factory;
	private ApplicationStateManager stateManager;
	private EntitiesManagerFactory entitiesManager;
	
	public CanvasMouseMotionListener() {
		super();
		factory = LogicGateImageFactory.getInstance();
		stateManager = ApplicationStateManager.getInstance();
		entitiesManager = EntitiesManagerFactory.getInstance();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(stateManager.isDragging()) {
			int x = e.getX();
			int y = e.getY();
			CanvasEntity entity = entitiesManager.getEntityOnHitBox(x, y);
			if(entity == null) {
				return; // will not trigger
			}
			
			entitiesManager.updateEntityPosition(entity, x, y);
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public void showTransparentOverlay() {
		
	}

}

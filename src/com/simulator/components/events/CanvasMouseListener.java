package com.simulator.components.events;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import com.simulator.components.BreadboardCanvas;
import com.simulator.model.LogicGate;
import com.simulator.util.ApplicationStateManager;
import com.simulator.util.LogicGateImageFactory;

public class CanvasMouseListener implements MouseListener {
	
	private BreadboardCanvas canvas;
	
	private LogicGateImageFactory factory;
	
	private ApplicationStateManager stateManager;
	
	public CanvasMouseListener(BreadboardCanvas canvas) {
		super();
		this.canvas = canvas;
		factory = LogicGateImageFactory.getInstance();
		stateManager = ApplicationStateManager.getInstance();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if(!canvas.hasAnyHitBox(x, y) && stateManager.isAdding()) {
			canvas.addLogictGateToPaint(stateManager.getGateToAdd(), e.getX(), e.getY());				
		}

		canvas.repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		System.out.println("Mouse Released");
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		System.out.println("Mouse Entered");
		//canvas.clear();
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}

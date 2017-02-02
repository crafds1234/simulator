package com.simulator.components.events;

import java.awt.Canvas;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.List;

import com.simulator.components.BreadboardCanvas;
import com.simulator.model.LogicGate;
import com.simulator.model.Subscriber;
import com.simulator.util.LogicGateImageFactory;

public class CanvasMouseMotionListener implements MouseMotionListener {
	
	private BreadboardCanvas canvas;
	
	private LogicGateImageFactory factory;
	
	public CanvasMouseMotionListener(BreadboardCanvas canvas) {
		super();
		this.canvas = canvas;
		factory = LogicGateImageFactory.getInstance();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}
	
	public void showTransparentOverlay() {
		
	}

}

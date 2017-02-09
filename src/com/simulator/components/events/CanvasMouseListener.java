package com.simulator.components.events;

import java.awt.Dialog;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import com.simulator.components.BreadboardFrame;
import com.simulator.components.BreadboardOptionDialog;
import com.simulator.components.LightBulbOptionDialog;
import com.simulator.components.SwitchOptionDialog;
import com.simulator.model.AppStates;
import com.simulator.model.CanvasEntity;
import com.simulator.model.LogicGate;
import com.simulator.model.components.BSwitch;
import com.simulator.model.components.LightBulb;
import com.simulator.util.ApplicationStateManager;
import com.simulator.util.EntitiesManagerFactory;

public class CanvasMouseListener implements MouseListener {

	private ApplicationStateManager stateManager;
	private EntitiesManagerFactory entitiesManager;

	public CanvasMouseListener() {
		super();

		stateManager = ApplicationStateManager.getInstance();
		entitiesManager = EntitiesManagerFactory.getInstance();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if (stateManager.isAdding()) {
			entitiesManager.addEntityToPaint(stateManager.getGateToAdd(), e.getX(), e.getY());
			stateManager.setState(AppStates.EMPTY); // done adding
		} else if (entitiesManager.hasAnyHitBox(x, y)) {
			CanvasEntity entity = entitiesManager.getEntityOnHitBox(x, y);
			Dialog dialog = null;
			if(entity instanceof BSwitch) {
				dialog = new SwitchOptionDialog(BreadboardFrame.frame, (BSwitch) entity);
			} else if(entity instanceof LogicGate) { //show logic gate options
				dialog = new BreadboardOptionDialog(BreadboardFrame.frame, entity);
			} else if(entity instanceof LightBulb) {
				dialog = new LightBulbOptionDialog(BreadboardFrame.frame, (LightBulb) entity);
			}
			dialog.setVisible(true);
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();

		if (entitiesManager.hasAnyHitBox(x, y)) {
			stateManager.setState(AppStates.DRAG);
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {

	}

}

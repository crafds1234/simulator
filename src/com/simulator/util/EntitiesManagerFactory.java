package com.simulator.util;

import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import com.simulator.model.CanvasEntity;
import com.simulator.model.LogicGate;
import com.simulator.model.Publisher;
import com.simulator.model.Subscriber;
import com.simulator.model.components.LightBulb;

public class EntitiesManagerFactory extends Publisher<Subscriber> {
	
	/**	 * 	 */
	private static final long serialVersionUID = 1L;

	private static EntitiesManagerFactory factory;
	
	private LogicGateImageFactory logicGateImageFactory;
	
	private List<CanvasEntity> entities;
	
	private List<LogicGate> logicGates;
	
	private List<LightBulb> lightBulbs;
	
	private LogicGate connectingFirstGate;

	private EntitiesManagerFactory() {
		entities = new ArrayList<>();
		logicGates = new ArrayList<>();
		lightBulbs = new ArrayList<>();
		logicGateImageFactory = LogicGateImageFactory.getInstance();
	}
	
	public static EntitiesManagerFactory getInstance() {
		if(factory == null) {
			factory = new EntitiesManagerFactory();
		}
		
		return factory;
	}
	
	public void updateEntityPosition(CanvasEntity gate, int x, int y) {
		if(!entities.contains(gate)) {
			return; //false alarm
		}
		gate.setX(x);
		gate.setY(y);
		notifySubscribers();
	}
	
	public void addEntity(CanvasEntity entity) {
		if(entity == null) {
			return;
		}
		entities.add(entity);
		
		if(entity instanceof LogicGate) {
			logicGates.add((LogicGate) entity);
		} else if(entity instanceof LightBulb) {
			lightBulbs.add((LightBulb) entity);
		}
		
		notifySubscribers();
	}
	
	public void removeEntity(LogicGate gate) {
		if(gate == null || !(gate instanceof LogicGate)) {
			return;
		}
		entities.remove(gate);
		notifySubscribers();
	}
	
	public void clear() {
		entities.clear();
		logicGates.clear();
		lightBulbs.clear();
		notifySubscribers();
	}

	public List<CanvasEntity> getEntities() {
		return entities;
	}
	
	public List<LogicGate> getLogicGateEntities() {
		return logicGates;
	}
	
	public List<LightBulb> getLightBulbEntities() {
		return lightBulbs;
	}
	
	public CanvasEntity getEntityOnHitBox(int x, int y) {
		CanvasEntity firstInstance = null;
		for (CanvasEntity logicGate : entities) {
			if(logicGate.isHitbox(x, y)) {
				firstInstance = logicGate;
				break;
			}
		}
		
		return firstInstance;
	}
	
	public boolean hasAnyHitBox(int x , int y) {
		for (CanvasEntity logicGate : entities) {
			if(logicGate.isHitbox(x, y)) {
				return true;
			}
		}
		return false;
	}
	
	public void addLogictGateToPaint(String strGate, int x, int y) {
		try {
			LogicGate gate = logicGateImageFactory.getGateModel(strGate);
			Image image = logicGateImageFactory.getGateImage(strGate);
			gate.setImage(image);
			gate.setX(x);
			gate.setY(y);
			
			addEntity(gate);
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("lol buggers");
		}

	}

	public LogicGate getConnectingFirstGate() {
		return connectingFirstGate;
	}

	public void setConnectingFirstGate(LogicGate connectingFirstGate) {
		this.connectingFirstGate = connectingFirstGate;
	}
	

}

package com.simulator.components;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.simulator.model.LogicGate;
import com.simulator.model.components.BSwitch;
import com.simulator.model.components.LightBulb;
import com.simulator.util.ApplicationStateManager;
import com.simulator.util.EntitiesManagerFactory;

public class LightBulbOptionDialog extends Dialog {

	/** * */
	private static final long serialVersionUID = -7538661923335231388L;

	private Button close;
	private Button connect1;

	private final LightBulb entity;

	private ApplicationStateManager statemanager;
	private EntitiesManagerFactory entitymanager;

	public LightBulbOptionDialog(Frame owner, LightBulb entity) {
		super(owner, true);

		this.entity = entity;
		setBackground(Color.gray);
		setResizable(false);
		setLocationRelativeTo(BreadboardFrame.frame);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		statemanager = ApplicationStateManager.getInstance();
		entitymanager = EntitiesManagerFactory.getInstance();
		close = new Button("Close");
		connect1 = new Button("Connect to output");

		setEventListeners();

		Panel panel = new Panel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setPreferredSize(new Dimension(200, 200));

		if (statemanager.getCurrentLogicGate() != null || statemanager.getbSwitchFirstEntity() != null) {
			panel.add(connect1);
		} else {
			close.setLabel("Please choose a gate..");
		}

		panel.add(close);
		add(panel);

		setSize(200, 200);

	}

	private void setEventListeners() {
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				dispose();
			}
		});

		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		connect1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (statemanager.isConnectedToSwitch()) {
					BSwitch bSwitch = (BSwitch) statemanager.getbSwitchFirstEntity();

					entity.setFirstConnectionEntry(bSwitch.getFirstConnectionEntry());
					entity.getFirstConnectionEntry().setHasConnection(true);
				} else {
					LogicGate gate = (LogicGate) statemanager.getCurrentLogicGate();

					entity.setFirstConnectionEntry(gate.getConnectionResult());
					entity.getFirstConnectionEntry().setHasConnection(true);
				}
				statemanager.setbSwitchFirstEntity(null);
				statemanager.setCurrentLogicGate(null);
				
				statemanager.notifySubscribers();
				entitymanager.notifySubscribers();
				dispose();
			}
		});

	}

}

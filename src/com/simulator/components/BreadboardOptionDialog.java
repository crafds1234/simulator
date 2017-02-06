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

import com.simulator.model.CanvasEntity;
import com.simulator.model.LogicGate;
import com.simulator.util.ApplicationStateManager;
import com.simulator.util.EntitiesManagerFactory;

public class BreadboardOptionDialog extends Dialog {

	/** * */
	private static final long serialVersionUID = -7538661923335231388L;

	private Button close;
	private Button connect1;
	private Button connect2;
	private Button connect3;

	private final CanvasEntity entity;

	private ApplicationStateManager statemanager;
	private EntitiesManagerFactory entitymanager;

	public BreadboardOptionDialog(Frame owner, CanvasEntity entity) {
		super(owner, true);

		this.entity = entity;
		setBackground(Color.gray);
		setResizable(false);
		setLocationRelativeTo(BreadboardFrame.frame);
		setLayout(new FlowLayout(FlowLayout.CENTER));

		statemanager = ApplicationStateManager.getInstance();
		entitymanager = EntitiesManagerFactory.getInstance();
		close = new Button("Close");
		connect1 = new Button("Connect to line 1");
		connect2 = new Button("Connect to line 2");
		connect3 = new Button("Connect output to..");

		setEventListeners();

		Panel panel = new Panel();
		panel.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel.setPreferredSize(new Dimension(200, 200));

		if (statemanager.getCurrentLogicGate() != null) {
			panel.add(connect1);
			panel.add(connect2);
		} else {
			panel.add(connect3);
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
				LogicGate gate = (LogicGate) statemanager.getCurrentLogicGate();
				LogicGate gate2 = (LogicGate) entity;
				gate2.setFirstConnectionEntry(gate.getConnectionResult());
				gate2.getFirstConnectionEntry().setHasConnection(true);

				statemanager.setCurrentLogicGate(null);
				statemanager.notifySubscribers();
				entitymanager.notifySubscribers();
				dispose();
			}
		});

		connect2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LogicGate gate = (LogicGate) statemanager.getCurrentLogicGate();
				LogicGate gate2 = (LogicGate) entity;
				gate2.setSecondConnectionEntry(gate.getConnectionResult());
				gate2.getSecondConnectionEntry().setHasConnection(true);

				statemanager.setCurrentLogicGate(null);
				statemanager.notifySubscribers();
				entitymanager.notifySubscribers();
				dispose();
			}
		});

		connect3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				statemanager.setCurrentLogicGate(entity);
				dispose();
			}
		});
	}

}

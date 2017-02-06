package com.simulator.components;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.simulator.components.events.SimulatorWindowAdapter;

public class BreadboardStartFrame extends Frame implements ActionListener {

	public BreadboardStartFrame() {
		super("Breadbord Simulator");
		setLayout(new BorderLayout());
		setSize(800, 530);
		setResizable(false);
		setLocationRelativeTo(null);

		setEventListeners();

		Button button = new Button("Start");
		button.setPreferredSize(new Dimension(200, 100));
		button.addActionListener(this);
		add(button, BorderLayout.SOUTH);

		Label label = new Label("Breadboard Simulator", Label.CENTER);
		label.setPreferredSize(new Dimension(530, 150));
		Font font = new Font("Serif", Font.BOLD, 30);
		label.setFont(font);

		add(label, BorderLayout.NORTH);
	}

	private void setEventListeners() {
		addWindowListener(new SimulatorWindowAdapter());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setVisible(false);
		BreadboardFrame frame = new BreadboardFrame();
		frame.display();
	}

}

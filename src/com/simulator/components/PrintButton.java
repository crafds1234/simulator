package com.simulator.components;

import java.awt.Button;
import java.awt.Canvas;
import java.awt.PrintJob;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

public class PrintButton extends Button implements ActionListener {

	/** * */
	private static final long serialVersionUID = 4355370911528846018L;

	private Canvas canvas = BreadboardCanvas.canvas;

	public PrintButton(String val) {
		super(val);
		addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String name = "Print job";
		Properties properties = new Properties();
		PrintJob pj = Toolkit.getDefaultToolkit().getPrintJob(BreadboardFrame.frame, name, properties);
		if (pj != null) {
			canvas.printAll(pj.getGraphics());
			pj.end();
		}
	}

}

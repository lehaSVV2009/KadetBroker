package com.kadet.kadetBroker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;

public class LoggerPanel extends JPanel {

	private JTextArea loggerTextArea = new JTextArea();
	
	public LoggerPanel () {
		initComponents();
	}
	
	private void initComponents () {
		
		loggerTextArea.setEditable(false);
		
		setBorder(BorderFactory.createTitledBorder(Strings.LOGGER_LABEL));
		
		setLayout(new BorderLayout());
		add(new JScrollPane(loggerTextArea), BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(500, 100));
	}
	
	public void addText (String text) {
        loggerTextArea.append(text + "\n");
	}

    public void refresh () {

    }

}

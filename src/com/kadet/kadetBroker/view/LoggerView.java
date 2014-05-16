package com.kadet.kadetBroker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;

public class LoggerView extends AbstractView {

	private Map<Integer, StringBuilder> viewIdTextMap = new HashMap<Integer, StringBuilder>(); 
	
	private JTextArea loggerTextArea = new JTextArea();
	
	public LoggerView() {
		initComponents();
	}
	
	private void initComponents () {
		
		loggerTextArea.setEditable(false);
		
		setBorder(BorderFactory.createTitledBorder(Strings.LOGGER_LABEL));
		
		setLayout(new BorderLayout());
		add(loggerTextArea, BorderLayout.CENTER);
		
		setPreferredSize(new Dimension(500, 100));
	}
	
	public void addViewIdText (Integer viewId, String text) {
		if (viewIdTextMap.containsKey(viewId)) {
			viewIdTextMap.get(viewId).append(text);
		} else {
			viewIdTextMap.put(viewId, new StringBuilder(text));
		}
	}
	
	@Override
	public void refresh() {
		
	}

}

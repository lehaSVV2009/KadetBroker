package com.kadet.kadetBroker.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;

public class LoggerPanel extends JPanel {

	private Map<View, StringBuilder> viewTextMap = new HashMap<View, StringBuilder>();

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
	
	public void addViewText (View view, String text) {
		if (viewTextMap.containsKey(view)) {
			viewTextMap.get(view).append(text).append('\n');
		} else {
			viewTextMap.put(view, new StringBuilder(text).append('\n'));
		}
	}

    public void refresh () {
        View activeView = ViewManager.getInstance().getActiveView();
        StringBuilder loggerText = viewTextMap.get(activeView);
        loggerTextArea.setText(loggerText != null ? loggerText.toString() : "");
    }

}

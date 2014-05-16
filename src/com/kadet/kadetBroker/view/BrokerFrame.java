package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.fwk.ViewFactory;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.*;
import java.awt.*;

public class BrokerFrame extends JFrame {

	
	private LoggerView loggerView;
	
	private JTabbedPane tabsPanel;
	
	
	public BrokerFrame() {
		init();
	}
	
	private void init () {
		
		this.tabsPanel = new JTabbedPane();
		this.loggerView = ViewFactory.createLoggerView();
		
		setTitle(Strings.APP_TITLE); 
        setMinimumSize(new Dimension(600, 600));
        pack();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
        setLayout(new BorderLayout());
		add(tabsPanel, BorderLayout.CENTER);
		add(loggerView, BorderLayout.SOUTH);
		
	}
	
	
	public void addTab (String tab, AbstractView view) {
		tabsPanel.addTab(tab, view);
	}

	
}

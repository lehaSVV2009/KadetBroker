package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.fwk.ViewFactory;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class BrokerFrame extends JFrame {

	
	private LoggerView loggerView;
	
	private JTabbedPane tabsPanel;
	
	
	public BrokerFrame() {
		init();
	}
	
	private void init () {
		
		tabsPanel = new JTabbedPane();
        tabsPanel.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged (ChangeEvent e) {
                System.out.println("Tab was changed!" + ((AbstractView)tabsPanel.getSelectedComponent()).getViewId());
                AbstractView view = (AbstractView)tabsPanel.getSelectedComponent();
                view.refresh();
            }
        });
		loggerView = ViewFactory.createLoggerView();
		
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

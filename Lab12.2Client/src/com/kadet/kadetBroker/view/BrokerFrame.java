package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.fwk.ViewFactory;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrokerFrame extends JFrame {

	private static Logger logger = Logger.getLogger(BrokerFrame.class.getName());

	private LoggerPanel loggerPanel;

	private JTabbedPane tabsPanel;
	
	
	public BrokerFrame() {
		init();
	}
	
	private void init () {

		tabsPanel = new JTabbedPane();
        tabsPanel.addChangeListener(new ChangeListener() {

            private View oldView;

            @Override
            public void stateChanged (ChangeEvent e) {

                View view = (View)tabsPanel.getSelectedComponent();
                ViewManager.getInstance().setActiveView(view);
                view.refresh();

                logger.log(Level.INFO, Strings.TAB_WAS_CHANGED + ": " + tabsPanel.getSelectedIndex());

            }
        });

        loggerPanel = ViewFactory.createLoggerView();


        this.addWindowFocusListener(new WindowFocusListener() {

            @Override
            public void windowGainedFocus (WindowEvent e) {
                ViewManager.getInstance().setActiveLoggerPanel(loggerPanel);
                ViewManager.getInstance().setActiveView((View)tabsPanel.getSelectedComponent());
            }

            @Override
            public void windowLostFocus (WindowEvent e) {

            }

        });


        setTitle(Strings.APP_TITLE);
        setMinimumSize(new Dimension(600, 600));
        pack();
        setLocationRelativeTo(null);
        
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		
        setLayout(new BorderLayout());
		add(tabsPanel, BorderLayout.CENTER);
		add(loggerPanel, BorderLayout.SOUTH);
		
	}
	
	
	public void addTab (String tab, JComponent view) {
		tabsPanel.addTab(tab, view);
	}

	
}

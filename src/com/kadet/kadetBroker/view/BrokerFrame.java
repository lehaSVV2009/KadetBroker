package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.exception.KadetException;
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

            private View oldView;

            @Override
            public void stateChanged (ChangeEvent e) {

                //TODO: change to addActiveViews
                View view = (View)tabsPanel.getSelectedComponent();
                ViewManager.getInstance().setActiveView(view);
                view.refresh();


                /*try {

                    View view = (View)tabsPanel.getSelectedComponent();
                    ViewManager.getInstance().addActiveView(view);
                    view.refresh();

                    if (oldView != null) {
                        ViewManager.getInstance().removeActiveView(oldView);
                    }
                    System.out.println("\nOld view: " + oldView + "\nNew View" + view);

                    oldView = view;

                } catch (KadetException e1) {
                    e1.printStackTrace();
                }*/
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
	
	
	public void addTab (String tab, JComponent view) {
		tabsPanel.addTab(tab, view);
	}

	
}

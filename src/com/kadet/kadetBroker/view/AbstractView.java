package com.kadet.kadetBroker.view;

import javax.swing.JPanel;

public abstract class AbstractView extends JPanel {

	private static int viewsNumber = 0;
	 
	private int viewId;
	
	public AbstractView() {
		this.viewId = viewsNumber++;
	}
	
	
	public abstract void refresh ();
	
	public int getViewId () {
		return viewId;
	}
	
}

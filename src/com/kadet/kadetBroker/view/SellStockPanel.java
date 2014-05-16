package com.kadet.kadetBroker.view;

import javax.swing.JButton;

import com.kadet.kadetBroker.actions.ButtonAction;
import com.kadet.kadetBroker.entity.Share;
import com.kadet.kadetBroker.util.Strings;

public class SellStockPanel extends StockPanel {
	
	private JButton sellButton = new JButton(Strings.SELL_STOCK_BUTTON);
	
	public SellStockPanel(Share share) {
		super(share);
		init();
	}
	
	private void init () {

		sellButton.addActionListener(
				new ButtonAction());
		
		add(sellButton);
		
	}

}

package com.kadet.kadetBroker.view;

import javax.swing.JButton;

import com.kadet.kadetBroker.actions.ButtonAction;
import com.kadet.kadetBroker.entity.Share;
import com.kadet.kadetBroker.util.Strings;

public class BuyStockPanel extends StockPanel {
	
	private JButton buyButton = new JButton(Strings.BUY_STOCK_BUTTON);
	
	public BuyStockPanel(Share share) {
		super(share);
		init();
	}
	
	private void init () {
		
		buyButton.addActionListener(
				new ButtonAction());
		
		add(buyButton);
		
	}

	
}

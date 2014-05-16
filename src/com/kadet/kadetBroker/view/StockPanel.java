package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;

import javax.swing.*;
import java.awt.*;

public abstract class StockPanel extends AbstractView {

    protected Customer customer;
	protected Share share;
	
	protected JLabel stockNameLabel = new JLabel();
	protected JLabel stockPriceLabel = new JLabel();
	protected JLabel stocksQuantityLabel = new JLabel();
	protected JTextField stocksNumberToBuyOrSellTextField = new JTextField();
	
	public StockPanel(Share share) {
		this.share = share;
		init();
	}
	
	private void init () {
		
		stockNameLabel.setText(share.getStock().getSymbol());
		stockPriceLabel.setText(String.valueOf(share.getStock().getPrice()));
		stocksQuantityLabel.setText(String.valueOf(share.getQuantity()));
		stocksNumberToBuyOrSellTextField.setText(String.valueOf(share.getQuantity()));
		
		setLayout(new GridLayout());
		add(stockNameLabel);
		add(stockPriceLabel);
		add(stocksQuantityLabel);
		add(stocksNumberToBuyOrSellTextField);
		
		
	}

	
	
	@Override
	public void refresh() {
		// TODO Auto-generated method stub
		
	}
	
	public Share getShare () {
		return share;
	}
	
}

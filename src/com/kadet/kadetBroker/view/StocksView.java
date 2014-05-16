package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.entity.Share;
import com.kadet.kadetBroker.entity.Stock;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout.Group;
import java.util.ArrayList;
import java.util.List;

public class StocksView extends AbstractView {

	private List<Share> yourStocks = new ArrayList<Share>();

	private List<Share> freeStocks = new ArrayList<Share>();

    private JLabel yourStocksLabel = new JLabel(Strings.YOUR_STOCKS_LABEL);
    private JPanel yourStocksPanel = new JPanel();
    private List<StockPanel> yourStocksPanels = new ArrayList<StockPanel>();

	
	private JLabel freeStocksLabel = new JLabel(Strings.FREE_STOCKS_LABEL);
	private JPanel freeStocksPanel = new JPanel();
	private List<StockPanel> freeStocksPanels = new ArrayList<StockPanel>();
	
	
	public StocksView() {
		
		//TODO: remove Later
		
		Stock stock1 = new Stock("ABS", 123123);
		Share share1 = new Share(stock1, 10);
		yourStocks.add(share1);

		Stock stock2 = new Stock("ABC2", 123123);
		Share share2 = new Share(stock2, 0);
		yourStocks.add(share2);
		Stock stock3 = new Stock("ABC", 123123);
		Share share3 = new Share(stock3, 123);
		yourStocks.add(share3);
		
		Stock astock1 = new Stock("ABC", 123123);
		Share ashare1 = new Share(astock1, 9);
		freeStocks.add(ashare1);

		Stock astock2 = new Stock("ABC2", 123123);
		Share ashare2 = new Share(astock2, 12);
		freeStocks.add(ashare2);
		Stock astock3 = new Stock("ABC3", 123123);
		Share ashare3 = new Share(astock3, 12);
		freeStocks.add(ashare3);
		
		Stock astock4 = new Stock("ABC", 123123);
		Share ashare4 = new Share(astock4, 9);
		freeStocks.add(ashare4);

		Stock astock5 = new Stock("ABC2", 123123);
		Share ashare5 = new Share(astock5, 12);
		freeStocks.add(ashare5);
		Stock astock6 = new Stock("ABC3", 123123);
		Share ashare6 = new Share(astock6, 12);
		freeStocks.add(ashare6);
		
				
		init();
	}
	
	
	private void init () {
		
		yourStocksPanels = createSellStockPanelsFromStocks(yourStocks);
		freeStocksPanels = createBuyStockPanelsFromStocks(freeStocks);
		
		yourStocksPanel = createPanelFromStockPanels(yourStocksPanels);
		freeStocksPanel = createPanelFromStockPanels(freeStocksPanels);
		
		GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup()
					.addComponent(yourStocksLabel)
					.addComponent(yourStocksPanel)
					.addComponent(freeStocksLabel)
					.addComponent(freeStocksPanel)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(yourStocksLabel)
					.addComponent(yourStocksPanel)
					.addComponent(freeStocksLabel)
					.addComponent(freeStocksPanel)
		);
		
	}
	
	private JPanel createPanelFromStockPanels (List<StockPanel> stockPanels) {
		JPanel panel = new JPanel();
		GroupLayout layout = new GroupLayout(panel);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		panel.setLayout(layout);
		Group parallelGroup = layout.createParallelGroup(Alignment.LEADING);
		Group sequentialGroup = layout.createSequentialGroup();
		for (StockPanel stockPanel : stockPanels) {
			parallelGroup.addComponent(stockPanel);
			sequentialGroup.addComponent(stockPanel);
		}
		layout.setHorizontalGroup(parallelGroup);
		layout.setVerticalGroup(sequentialGroup);
		return panel;
	}
	
	private List<StockPanel> createSellStockPanelsFromStocks (List<Share> shares) {
		List<StockPanel> stockPanels = new ArrayList<StockPanel>();
		for (Share share : shares) {
			stockPanels.add(createSellStockPanel(share));
		}
		return stockPanels;
	}
	

	private List<StockPanel> createBuyStockPanelsFromStocks (List<Share> shares) {
		List<StockPanel> stockPanels = new ArrayList<StockPanel>();
		for (Share share : shares) {
			stockPanels.add(createBuyStockPanel(share));
		}
		return stockPanels;
	}
	
	private StockPanel createSellStockPanel (Share share) {
		StockPanel stockPanel = new SellStockPanel(share);
		return stockPanel;
	}

	private StockPanel createBuyStockPanel (Share share) {
		StockPanel stockPanel = new BuyStockPanel(share);
		return stockPanel;
	}

	@Override
	public void refresh() {
		
	}

}
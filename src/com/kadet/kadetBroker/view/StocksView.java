package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StocksView extends AbstractView {

    private Customer currentCustomer;

	private List<Share> yourShares = new ArrayList<Share>();
    private List<Share> freeShares = new ArrayList<Share>();

    private JLabel yourSharesLabel = new JLabel(Strings.YOUR_STOCKS_LABEL);
    private JTable yourSharesTable = new JTable();
	private JScrollPane yourSharesTableScrollPane;

    private JLabel shareNameForSellLabel = new JLabel(Strings.STOCK_NAME_LABEL);
    private JTextField shareNameForSellTextField = new JTextField();
    private JLabel sharesNumberForSellLabel = new JLabel(Strings.STOCK_QUANTITY_LABEL);
    private JTextField sharesNumberForSellNumberField = new JTextField();
    private JButton sellButton = new JButton(Strings.SELL_STOCK_BUTTON);


	private JLabel freeSharesLabel = new JLabel(Strings.FREE_STOCKS_LABEL);
    private JTable freeSharesTable = new JTable();
    private JScrollPane freeSharesTableScrollPane;


    private JLabel shareNameForBuyLabel = new JLabel(Strings.STOCK_NAME_LABEL);
    private JTextField shareNameForBuyTextField = new JTextField();
    private JLabel sharesNumberForBuyLabel = new JLabel(Strings.STOCK_QUANTITY_LABEL);
    private JTextField sharesNumberForBuyNumberField = new JTextField();
    private JButton buyButton = new JButton(Strings.BUY_STOCK_BUTTON);


    public StocksView() {
		init();
	}
	
	
	private void init () {

        yourSharesTableScrollPane = new JScrollPane(yourSharesTable);
        freeSharesTableScrollPane = new JScrollPane(freeSharesTable);

        //TODO: add validators to number textFields

        GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		setLayout(layout);
		layout.setHorizontalGroup(
                layout.createParallelGroup()
                        .addComponent(yourSharesLabel)
                        .addComponent(yourSharesTableScrollPane)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(shareNameForSellLabel)
                                        .addComponent(shareNameForSellTextField)
                                        .addComponent(sharesNumberForSellLabel)
                                        .addComponent(sharesNumberForSellNumberField)
                                        .addComponent(sellButton)
                        )
                        .addComponent(freeSharesLabel)
                        .addComponent(freeSharesTableScrollPane)
                        .addGroup(
                                layout.createSequentialGroup()
                                        .addComponent(shareNameForBuyLabel)
                                        .addComponent(shareNameForBuyTextField)
                                        .addComponent(sharesNumberForBuyLabel)
                                        .addComponent(sharesNumberForBuyNumberField)
                                        .addComponent(buyButton)
                        )
        );
		layout.setVerticalGroup(
                layout.createSequentialGroup()
                        .addComponent(yourSharesLabel)
                        .addComponent(yourSharesTableScrollPane)
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(shareNameForSellLabel)
                                        .addComponent(shareNameForSellTextField)
                                        .addComponent(sharesNumberForSellLabel)
                                        .addComponent(sharesNumberForSellNumberField)
                                        .addComponent(sellButton)
                        )
                        .addComponent(freeSharesLabel)
                        .addComponent(freeSharesTableScrollPane)
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(shareNameForBuyLabel)
                                        .addComponent(shareNameForBuyTextField)
                                        .addComponent(sharesNumberForBuyLabel)
                                        .addComponent(sharesNumberForBuyNumberField)
                                        .addComponent(buyButton)
                        )
        );
		
	}

    public void setFreeShares (List<Share> freeShares) {
        this.freeShares = freeShares;
    }

    public void setYourShares (List<Share> yourShares) {
        this.yourShares = yourShares;
    }

    public void setCurrentCustomer (Customer currentCustomer) {
        this.currentCustomer = currentCustomer;
    }

    @Override
	public void refresh() {

        // TODO: yourShares = ...
        freeShares = Dispatcher.getInstance().getFreeShares();

        yourSharesTable.setModel(
                new SharesTableModel(yourShares));
        freeSharesTable.setModel(
                new SharesTableModel(freeShares));

    }

}
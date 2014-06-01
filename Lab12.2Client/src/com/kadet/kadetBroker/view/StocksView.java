package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.actions.ShareTextFieldsActions;
import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.ModelChangeListener;
import com.kadet.kadetBroker.fwk.PropertyChangingType;
import com.kadet.kadetBroker.fwk.RegistryManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.PortfolioTO;
import com.kadet.kadetBroker.to.ShareTO;
import com.kadet.kadetBroker.rmi.RMIUtils;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.StocksViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

import javax.swing.*;

import java.rmi.RemoteException;
import java.util.List;

public class StocksView extends JPanel implements View, CurrentCustomerContainer {

    private StocksViewModel stocksViewModel;

    private JLabel yourSharesLabel = new JLabel(Strings.YOUR_SHARES_LABEL);
    private JTable yourSharesTable = new JTable();
	private JScrollPane yourSharesTableScrollPane;

    private JLabel shareNameForSellLabel = new JLabel(Strings.STOCK_NAME_LABEL);
    private JTextField shareNameForSellTextField = new JTextField();
    private JLabel sharesNumberForSellLabel = new JLabel(Strings.STOCK_QUANTITY_LABEL);
    private JTextField sharesNumberForSellNumberField = new JTextField();
    private JButton sellButton = new JButton(Strings.SELL_STOCK_BUTTON);


	private JLabel stocksLabel = new JLabel(Strings.STOCKS_LABEL);
    private JTable stocksTable = new JTable();
    private JScrollPane stocksTableScrollPane;


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
        stocksTableScrollPane = new JScrollPane(stocksTable);

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
                        .addComponent(stocksLabel)
                        .addComponent(stocksTableScrollPane)
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
                        .addComponent(stocksLabel)
                        .addComponent(stocksTableScrollPane)
                        .addGroup(
                                layout.createParallelGroup()
                                        .addComponent(shareNameForBuyLabel)
                                        .addComponent(shareNameForBuyTextField)
                                        .addComponent(sharesNumberForBuyLabel)
                                        .addComponent(sharesNumberForBuyNumberField)
                                        .addComponent(buyButton)
                        )
        );

        shareNameForSellTextField.getDocument().addDocumentListener(new ShareTextFieldsActions());
        shareNameForBuyTextField.getDocument().addDocumentListener(new ShareTextFieldsActions());

        sharesNumberForSellNumberField.getDocument().addDocumentListener(new ShareTextFieldsActions());
        sharesNumberForBuyNumberField.getDocument().addDocumentListener(new ShareTextFieldsActions());

	}

    @Override
	public void refresh() {
    }


    @Override
    public void setViewModel (ViewModel viewModel) {
        this.stocksViewModel = (StocksViewModel) viewModel;

        stocksTable.setModel(
                new StocksTableModel(stocksViewModel.getStockTOs()));

        yourSharesTable.setModel(
                new SharesTableModel(stocksViewModel.getPortfolioTO())
        );

        shareNameForSellTextField.getDocument().putProperty(Strings.STOCK_ID_TEXT_FIELD, stocksViewModel.getShareTOForSelling());
        shareNameForBuyTextField.getDocument().putProperty(Strings.STOCK_ID_TEXT_FIELD, stocksViewModel.getShareTOForBuying());

        sharesNumberForSellNumberField.getDocument().putProperty(Strings.STOCKS_QUANTITY_TEXT_FIELD, stocksViewModel.getShareTOForSelling());
        sharesNumberForBuyNumberField.getDocument().putProperty(Strings.STOCKS_QUANTITY_TEXT_FIELD, stocksViewModel.getShareTOForBuying());
    }

    @Override
    public ViewModel getViewModel () {
        return stocksViewModel;
    }

    @Override
    public void refreshByCurrentCustomer (CustomerTO customerTO) {

        // Get Customer Shares
        Dispatcher dispatcher = Dispatcher.getInstance();
        CommandManager commandManager = CommandManager.getInstance();

        if(dispatcher.hasPortfolioOfCustomer(customerTO)) {
            resetPortfolioTO(dispatcher.getPortfolioTO(customerTO));
        } else {
    		try {
    			
    			Command command = RegistryManager.getInstance().getCommand(RMIUtils.RMI_GET_PORTFOLIO);
    	        command.setTO(customerTO);
    			command.execute();
                dispatcher.addPortfolioTO((PortfolioTO)command.getResult());

            } catch (KadetException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		} catch (RemoteException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
            resetPortfolioTO(
                    dispatcher.hasPortfolioOfCustomer(customerTO) ? dispatcher.getPortfolioTO(customerTO) : dispatcher.getDefaultPortfolioTO());
        }

        yourSharesTable.setModel(
                new SharesTableModel(stocksViewModel.getPortfolioTO())
        );
    }

    private void resetPortfolioTO (PortfolioTO newPortfolioTO) {

        PortfolioTO oldPortfolioTO = stocksViewModel.getPortfolioTO();

        CustomerTO oldCustomerTO = oldPortfolioTO.getCustomerTO();
        CustomerTO newCustomerTO = newPortfolioTO.getCustomerTO();
        oldCustomerTO.setId(newCustomerTO.getId());
        oldCustomerTO.setName(newCustomerTO.getName());
        oldCustomerTO.setAddress(newCustomerTO.getAddress());

        List<ShareTO> oldShareTOs = oldPortfolioTO.getShareTOs();
        List<ShareTO> newSharesTO = newPortfolioTO.getShareTOs();
        oldShareTOs.clear();
        for (ShareTO shareTO : newSharesTO) {
            oldShareTOs.add(shareTO);
        }

    }

}
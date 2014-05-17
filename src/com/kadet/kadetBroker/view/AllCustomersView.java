package com.kadet.kadetBroker.view;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.kadet.kadetBroker.actions.ButtonAction;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.util.Strings;

public class AllCustomersView extends AbstractView {

    private Customer currentCustomer = null;
	private List<Customer> customers = new ArrayList<Customer>();
	
	private JScrollPane tableScrollPane = new JScrollPane();
	private JTable customersTable = new JTable();
	
	private JButton addCustomerButton = new JButton(Strings.ADD_CUSTOMER_BUTTON);
	private JButton removeCustomerButton = new JButton(Strings.REMOVE_CUSTOMER_BUTTON);
	private JButton updateCustomerButton = new JButton(Strings.UPDATE_CUSTOMER_BUTTON);

	public AllCustomersView(List<Customer> customers) {
        this.customers = customers;
		init();
	}
	
	private void init () {

        customersTable.setModel(
                new CustomersTableModel(customers));

		tableScrollPane = new JScrollPane(customersTable);

		ButtonAction buttonAction 
				= new ButtonAction();
		addCustomerButton.addActionListener(buttonAction);
		removeCustomerButton.addActionListener(buttonAction);
		updateCustomerButton.addActionListener(buttonAction);
		
		GroupLayout layout = new GroupLayout(this);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup()
				.addComponent(tableScrollPane)
				.addGroup(
						layout.createSequentialGroup()
								.addComponent(addCustomerButton)
								.addComponent(updateCustomerButton)
								.addComponent(removeCustomerButton)
						)
		);
			
		layout.setVerticalGroup(
			layout.createSequentialGroup()
            	.addComponent(tableScrollPane)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(addCustomerButton)
								.addComponent(removeCustomerButton)
								.addComponent(updateCustomerButton)
						)
        );

		refresh();
			
		
	}
	
	
	@Override
	public void refresh() {
	/*	customers = Dispatcher.getInstance().getAllCustomers();
		customersTable.setModel(
				new CustomersTableModel(customers));
		*/
	}

}

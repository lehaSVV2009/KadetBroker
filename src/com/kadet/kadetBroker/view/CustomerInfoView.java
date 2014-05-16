package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.*;

public class CustomerInfoView extends AbstractView {

	private Customer customer;
	
	private JLabel customerIdLabel = new JLabel(Strings.CUSTOMER_ID_LABEL);
	private JTextField customerIdTextField = new JTextField();
	
	private JLabel customerNameLabel = new JLabel(Strings.CUSTOMER_NAME_LABEL);
	private JTextField customerNameTextField = new JTextField();
	
	private JLabel customerAddressLabel = new JLabel(Strings.CUSTOMER_ADDRESS_LABEL);
	private JTextField customerAddressTextField = new JTextField();
	
	public CustomerInfoView () {
		init();
	}
	
	private void init () {
		
		GroupLayout layout = new GroupLayout(this);
		setLayout(layout);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		layout.setHorizontalGroup(
			layout.createSequentialGroup()
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
								.addComponent(customerIdLabel)
								.addComponent(customerNameLabel)
								.addComponent(customerAddressLabel)
						)
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addComponent(customerIdTextField)
								.addComponent(customerNameTextField)
								.addComponent(customerAddressTextField)
						)
		);
		
		layout.setVerticalGroup(
			layout.createSequentialGroup()
            	.addGroup(
            			layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
				                .addComponent(customerIdLabel)
				                .addComponent(customerIdTextField))
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(customerNameLabel)
								.addComponent(customerNameTextField))
				.addGroup(
						layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(customerAddressLabel)
								.addComponent(customerAddressTextField))
        );
		refresh();
		
	}
	
	@Override
	public void refresh() {
		
	}

}
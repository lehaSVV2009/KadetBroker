package com.kadet.kadetBroker.dialog;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 17.05.14
 * Time: 22:22
 *
 * @author SarokaA
 */
public class AddCustomerDialog extends JDialog implements View {

    private Customer customer;

    private JLabel customerNameLabel = new JLabel(Strings.CUSTOMER_NAME_LABEL);
    private JTextField customerNameTextField = new JTextField();
    private JLabel customerAddressLabel = new JLabel(Strings.CUSTOMER_ADDRESS_LABEL);
    private JTextField customerAddressTextField = new JTextField();

    private JButton addButton = new JButton(Strings.ADD_CUSTOMER_BUTTON);
    private JButton resetButton = new JButton(Strings.RESET_CUSTOMER_BUTTON);

    public AddCustomerDialog () {
        init();
    }

    public void setCustomer (Customer customer) {
        this.customer = customer;
    }

    public void init () {

        setModal(true);

        setTitle(Strings.ADD_CUSTOMER_DIALOG);
        setMinimumSize(new Dimension(300, 300));
        setPreferredSize(new Dimension(300, 300));
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setLayout(new GridLayout(2, 2));
        textFieldsPanel.add(customerNameLabel);
        textFieldsPanel.add(customerNameTextField);
        textFieldsPanel.add(customerAddressLabel);
        textFieldsPanel.add(customerAddressTextField);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(addButton);
        buttonsPanel.add(resetButton);

        add(textFieldsPanel);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    @Override
    public void refresh () {

    }

    @Override
    public void refresh (Object changedObject) {

    }

}

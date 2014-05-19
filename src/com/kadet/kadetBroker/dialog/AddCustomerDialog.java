package com.kadet.kadetBroker.dialog;

import com.kadet.kadetBroker.actions.AddCustomerButtonsActions;
import com.kadet.kadetBroker.actions.CustomerTextFieldsActions;
import com.kadet.kadetBroker.dto.CustomerDTO;
import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.PropertyChangingType;
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

    private CustomerDTO customerDTO;

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

    public void init () {

        setModal(true);

        setTitle(Strings.ADD_CUSTOMER_DIALOG);
        setMinimumSize(new Dimension(300, 300));
        setPreferredSize(new Dimension(300, 300));
        setLocationRelativeTo(null);

        initActions();

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

    private void initActions () {

        addButton.addActionListener(new AddCustomerButtonsActions());
        resetButton.addActionListener(new AddCustomerButtonsActions());

        customerNameTextField.getDocument().addDocumentListener(new CustomerTextFieldsActions());

        customerAddressTextField.getDocument().addDocumentListener(new CustomerTextFieldsActions());

    }

    @Override
    public void refresh () {

    }

    @Override
    public void refresh (PropertyChangingType changingType, Object changedObject) {

    }

    @Override
    public void setModel (DTO model) {
        this.customerDTO = (CustomerDTO) model;
        this.customer = customerDTO.getCustomer();
        customerNameTextField.getDocument().putProperty(Strings.NAME_TEXT_FIELD, customer);
        customerAddressTextField.getDocument().putProperty(Strings.ADDRESS_TEXT_FIELD, customer);
    }

    @Override
    public DTO getModel () {
        return customerDTO;
    }
}

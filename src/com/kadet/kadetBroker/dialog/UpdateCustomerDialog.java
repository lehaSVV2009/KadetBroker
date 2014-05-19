package com.kadet.kadetBroker.dialog;

import com.kadet.kadetBroker.actions.CustomerTextFieldsActions;
import com.kadet.kadetBroker.actions.UpdateCustomerButtonsActions;
import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.dto.UpdateCustomerDTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.PropertyChangingType;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.View;

import javax.swing.*;
import java.awt.*;

/**
 * Date: 18.05.14
 * Time: 0:05
 *
 * @author SarokaA
 */
public class UpdateCustomerDialog extends JDialog implements View{

    private UpdateCustomerDTO updateCustomerDTO;

    private Customer oldCustomer;
    private Customer newCustomer;

    private JLabel customerIdLabel = new JLabel(Strings.CUSTOMER_ID_LABEL);
    private JTextField customerIdTextField = new JTextField();
    private JLabel customerNameLabel = new JLabel(Strings.CUSTOMER_NAME_LABEL);
    private JTextField customerNameTextField = new JTextField();
    private JLabel customerAddressLabel = new JLabel(Strings.CUSTOMER_ADDRESS_LABEL);
    private JTextField customerAddressTextField = new JTextField();

    private JButton updateButton = new JButton(Strings.UPDATE_CUSTOMER_BUTTON);
    private JButton resetButton = new JButton(Strings.RESET_CUSTOMER_BUTTON);

    public UpdateCustomerDialog () {
        init();
    }

    public void init () {

        setModal(true);

        setTitle(Strings.UPDATE_CUSTOMER_DIALOG);
        setMinimumSize(new Dimension(300, 300));
        setPreferredSize(new Dimension(300, 300));
        setLocationRelativeTo(null);

        customerIdTextField.setEditable(false);

        initActions();

        setLayout(new BorderLayout());

        JPanel textFieldsPanel = new JPanel();
        textFieldsPanel.setLayout(new GridLayout(3, 2));
        textFieldsPanel.add(customerIdLabel);
        textFieldsPanel.add(customerIdTextField);
        textFieldsPanel.add(customerNameLabel);
        textFieldsPanel.add(customerNameTextField);
        textFieldsPanel.add(customerAddressLabel);
        textFieldsPanel.add(customerAddressTextField);

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.add(updateButton);
        buttonsPanel.add(resetButton);

        add(textFieldsPanel);
        add(buttonsPanel, BorderLayout.SOUTH);
    }

    private void initActions () {

        customerNameTextField.getDocument().addDocumentListener(new CustomerTextFieldsActions());
        customerAddressTextField.getDocument().addDocumentListener(new CustomerTextFieldsActions());

        updateButton.addActionListener(new UpdateCustomerButtonsActions());
        resetButton.addActionListener(new UpdateCustomerButtonsActions());
    }


    @Override
    public void refresh () {
        customerIdTextField.setText(oldCustomer.getId());
        customerNameTextField.setText(oldCustomer.getName());
        customerAddressTextField.setText(oldCustomer.getAddress());
    }


    @Override
    public void refresh (PropertyChangingType changingType, Object changedObject) {

    }

    @Override
    public void setModel (DTO model) {
        this.updateCustomerDTO = (UpdateCustomerDTO) model;
        this.oldCustomer = updateCustomerDTO.getOldCustomer();
        this.newCustomer = updateCustomerDTO.getNewCustomer();

        newCustomer.setId(oldCustomer.getId());
        newCustomer.setName(oldCustomer.getName());
        newCustomer.setAddress(oldCustomer.getAddress());

        customerNameTextField.getDocument().putProperty(Strings.NAME_TEXT_FIELD, newCustomer);
        customerAddressTextField.getDocument().putProperty(Strings.ADDRESS_TEXT_FIELD, newCustomer);
    }

    @Override
    public DTO getModel () {
        return updateCustomerDTO;
    }
}

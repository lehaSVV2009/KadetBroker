package com.kadet.kadetBroker.dialog;

import com.kadet.kadetBroker.actions.CustomerTextFieldsActions;
import com.kadet.kadetBroker.actions.UpdateCustomerButtonsActions;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.PropertyChangingType;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.View;
import com.kadet.kadetBroker.viewModel.UpdateCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Date: 18.05.14
 * Time: 0:05
 *
 * @author SarokaA
 */
public class UpdateCustomerDialog extends JDialog implements View{

    private UpdateCustomerViewModel viewModel;

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

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                super.windowClosing(e);
                View view = UpdateCustomerDialog.this;
                ViewManager.getInstance().removeView(view);
                ControllerManager.getInstance().removeControllersByView(view);
            }
        });
    }


    @Override
    public void refresh () {
        repaint();
    }


    @Override
    public void refresh (PropertyChangingType changingType, Object changedObject) {

    }
/*
    @Override
    public void setModel (TO model) {
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
    public TO getViewModel () {
        return updateCustomerDTO;
    }*/


    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (UpdateCustomerViewModel) viewModel;

        CustomerTO newCustomerTO = this.viewModel.getNewCustomerTO();
        CustomerTO oldCustomerTO = this.viewModel.getOldCustomerTO();

        newCustomerTO.setId(oldCustomerTO.getId());
        newCustomerTO.setName(oldCustomerTO.getName());
        newCustomerTO.setAddress(oldCustomerTO.getAddress());

        customerNameTextField.getDocument().putProperty(Strings.NAME_TEXT_FIELD, newCustomerTO);
        customerAddressTextField.getDocument().putProperty(Strings.ADDRESS_TEXT_FIELD, newCustomerTO);

        customerIdTextField.setText(newCustomerTO.getId());
        customerNameTextField.setText(newCustomerTO.getName());
        customerAddressTextField.setText(newCustomerTO.getAddress());
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }

}

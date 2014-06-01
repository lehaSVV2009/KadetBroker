package com.kadet.kadetBroker.dialog;

import com.kadet.kadetBroker.actions.AddCustomerButtonsActions;
import com.kadet.kadetBroker.actions.CustomerTextFieldsActions;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.ControllerManager;
import com.kadet.kadetBroker.fwk.PropertyChangingType;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.View;
import com.kadet.kadetBroker.viewModel.AddCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Date: 17.05.14
 * Time: 22:22
 *
 * @author SarokaA
 */
public class AddCustomerDialog extends JDialog implements View {

	private AddCustomerViewModel viewModel;
	
    /*private CustomerTO customerDTO;

    private Customer customer;
*/
    private JLabel customerIdLabel = new JLabel(Strings.CUSTOMER_ID_LABEL);
    private JTextField customerIdTextField = new JTextField();
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
        textFieldsPanel.setLayout(new GridLayout(3, 2));
        textFieldsPanel.add(customerIdLabel);
        textFieldsPanel.add(customerIdTextField);
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

        //TODO: add Window Close Listener (kill View and Controller)

        addButton.addActionListener(new AddCustomerButtonsActions());
        resetButton.addActionListener(new AddCustomerButtonsActions());

        customerIdTextField.getDocument().addDocumentListener(new CustomerTextFieldsActions());

        customerNameTextField.getDocument().addDocumentListener(new CustomerTextFieldsActions());

        customerAddressTextField.getDocument().addDocumentListener(new CustomerTextFieldsActions());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                super.windowClosing(e);
                View view = AddCustomerDialog.this;
                ViewManager.getInstance().removeView(view);
                ControllerManager.getInstance().removeControllersByView(view);
            }
        });
    }

    @Override
    public void refresh () {

    }


    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (AddCustomerViewModel) viewModel;

        customerIdTextField.getDocument().putProperty(Strings.ID_TEXT_FIELD, ((AddCustomerViewModel) viewModel).getNewCustomerTO());
        customerNameTextField.getDocument().putProperty(Strings.NAME_TEXT_FIELD, ((AddCustomerViewModel) viewModel).getNewCustomerTO());
        customerAddressTextField.getDocument().putProperty(Strings.ADDRESS_TEXT_FIELD, ((AddCustomerViewModel) viewModel).getNewCustomerTO());
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }
}

package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.dialog.AddCustomerDialog;
import com.kadet.kadetBroker.dto.AddCustomerDTO;
import com.kadet.kadetBroker.dto.AllCustomersDTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.view.AllCustomersView;
import com.kadet.kadetBroker.view.View;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * Date: 19.05.14
 * Time: 15:22
 *
 * @author SarokaA
 */
public class CustomerTextFieldsActions implements DocumentListener {

    @Override
    public void insertUpdate (DocumentEvent e) {
        updateCustomerField(e);
    }

    @Override
    public void removeUpdate (DocumentEvent e) {
        updateCustomerField(e);
    }

    @Override
    public void changedUpdate (DocumentEvent e) {
        updateCustomerField(e);
    }

    private void updateCustomerField (DocumentEvent e) {
        try {
            Document document = e.getDocument();
            if (document.getProperty(Strings.NAME_TEXT_FIELD) != null) {
                Customer customer = (Customer) document.getProperty(Strings.NAME_TEXT_FIELD);
                customer.setName(document.getText(0, document.getLength()));
            }
            if (document.getProperty(Strings.ADDRESS_TEXT_FIELD) != null) {
                Customer customer = (Customer) document.getProperty(Strings.ADDRESS_TEXT_FIELD);
                customer.setAddress(document.getText(0, document.getLength()));
            }
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
}

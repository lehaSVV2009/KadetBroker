package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.Strings;

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
                CustomerTO customer = (CustomerTO) document.getProperty(Strings.NAME_TEXT_FIELD);
                customer.setName(document.getText(0, document.getLength()));
            }
            if (document.getProperty(Strings.ADDRESS_TEXT_FIELD) != null) {
                CustomerTO customer = (CustomerTO) document.getProperty(Strings.ADDRESS_TEXT_FIELD);
                customer.setAddress(document.getText(0, document.getLength()));
            }
            if (document.getProperty(Strings.ID_TEXT_FIELD) != null) {
                CustomerTO customer = (CustomerTO) document.getProperty(Strings.ID_TEXT_FIELD);
                customer.setId(document.getText(0, document.getLength()));
            }
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
}

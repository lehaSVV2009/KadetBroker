package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.to.ShareTO;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;

/**
 * Date: 26.05.14
 * Time: 15:49
 *
 * @author SarokaA
 */
public class ShareTextFieldsActions implements DocumentListener {

    @Override
    public void insertUpdate (DocumentEvent e) {
        updateShareField(e);
    }

    @Override
    public void removeUpdate (DocumentEvent e) {
        updateShareField(e);
    }

    @Override
    public void changedUpdate (DocumentEvent e) {
        updateShareField(e);
    }

    private void updateShareField (DocumentEvent e) {
        try {
            Document document = e.getDocument();
            if (document.getProperty(Strings.STOCK_ID_TEXT_FIELD) != null) {
                ShareTO shareTO = (ShareTO) document.getProperty(Strings.STOCK_ID_TEXT_FIELD);
                shareTO.getStockTO().setId(document.getText(0, document.getLength()));
            }
            if (document.getProperty(Strings.STOCKS_QUANTITY_TEXT_FIELD) != null) {
                ShareTO shareTO = (ShareTO) document.getProperty(Strings.STOCKS_QUANTITY_TEXT_FIELD);
                // TODO: integer validation
                shareTO.setQuantity(
                        Integer.parseInt(document.getText(0, document.getLength())));
            }
        } catch (BadLocationException e1) {
            e1.printStackTrace();
        }
    }
}

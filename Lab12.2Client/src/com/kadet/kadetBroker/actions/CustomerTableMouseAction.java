package com.kadet.kadetBroker.actions;

import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.to.CustomerTO;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Date: 17.05.14
 * Time: 22:42
 *
 * @author SarokaA
 */
public class CustomerTableMouseAction extends MouseAdapter {

    @Override
    public void mouseClicked (MouseEvent e) {
        if (e.getClickCount() == 1) {

            JTable customersTable = (JTable)e.getSource();
            int selectedRowIndex = customersTable.getSelectedRow();
            String id = (String)customersTable.getModel().getValueAt(selectedRowIndex, 0);
            String name = (String)customersTable.getModel().getValueAt(selectedRowIndex, 1);
            String address = (String)customersTable.getModel().getValueAt(selectedRowIndex, 2);

            CustomerTO currentCustomer = new CustomerTO();
            currentCustomer.setId(id);
            currentCustomer.setName(name);
            currentCustomer.setAddress(address);

            ViewManager.getInstance().notifyByCurrentCustomer(currentCustomer);

        }
    }
}

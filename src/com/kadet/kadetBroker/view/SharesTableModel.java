package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Date: 17.05.14
 * Time: 6:36
 *
 * @author SarokaA
 */
public class SharesTableModel implements TableModel {

    private List<Share> shares;
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();


    public SharesTableModel (List<Share> shares) {
        this.shares = shares;
    }

    @Override
    public void addTableModelListener(TableModelListener arg0) {
        listeners.add(arg0);
    }

    @Override
    public Class<?> getColumnClass(int arg0) {
        return String.class;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return "Name";
            case 1:
                return "Price";
            case 2:
                return "Quantity";
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return shares.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Share share = shares.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return share.getStock().getSymbol();
            case 1:
                return share.getStock().getPrice();
            case 2:
                return share.getQuantity();
        }
        return "";
    }

    @Override
    public boolean isCellEditable(int arg0, int arg1) {
        return false;
    }

    @Override
    public void removeTableModelListener(TableModelListener arg0) {
        listeners.remove(arg0);
    }

    @Override
    public void setValueAt(Object arg0, int arg1, int arg2) {

    }

}

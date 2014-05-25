package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.to.PortfolioTO;
import com.kadet.kadetBroker.to.ShareTO;
import com.kadet.kadetBroker.util.Strings;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.HashSet;
import java.util.Set;

/**
 * Date: 25.05.14
 * Time: 14:35
 *
 * @author SarokaA
 */
public class SharesTableModel implements TableModel {

    private PortfolioTO portfolioTO;

    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();


    public SharesTableModel (PortfolioTO portfolioTO) {
        this.portfolioTO = portfolioTO;
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
                return Strings.STOCK_SYMBOL_COLUMN;
            case 1:
                return Strings.STOCK_PRICE_COLUMN;
            case 2 :
                return Strings.STOCK_QUANTITY_LABEL;
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return portfolioTO.getShareTOs().size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ShareTO shareTO = portfolioTO.getShareTOs().get(rowIndex);
        switch (columnIndex) {
            case 0 :
                return shareTO.getStockTO().getSymbol();
            case 1 :
                return shareTO.getStockTO().getPrice();
            case 2 :
                return shareTO.getQuantity();
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

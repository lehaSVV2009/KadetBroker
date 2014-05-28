package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.to.StockTO;
import com.kadet.kadetBroker.util.Strings;

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
public class StocksTableModel implements TableModel {

    private List<StockTO> stockTOs;
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();


    public StocksTableModel (List<StockTO> stockTOs) {
        this.stockTOs = stockTOs;
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
        return 2;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch (columnIndex) {
            case 0:
                return Strings.STOCK_SYMBOL_COLUMN;
            case 1:
                return Strings.STOCK_PRICE_COLUMN;
        }
        return "";
    }

    @Override
    public int getRowCount() {
        return stockTOs.size();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        StockTO stockTO = stockTOs.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return stockTO.getSymbol();
            case 1:
                return stockTO.getPrice();
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

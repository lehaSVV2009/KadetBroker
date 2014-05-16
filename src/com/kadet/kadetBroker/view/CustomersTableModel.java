package com.kadet.kadetBroker.view;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import com.kadet.kadetBroker.entity.Customer;

public class CustomersTableModel implements TableModel {

	private List<Customer> customers;
	private Set<TableModelListener> listeners = new HashSet<TableModelListener>();


	public CustomersTableModel (List<Customer> customers) {
		this.customers = customers;
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
			return "Id";
		case 1:
			return "Name";
		case 2:
			return "Address";
		}
		return "";
	}

	@Override
	public int getRowCount() {
		return customers.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Customer customer = customers.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return customer.getId();
		case 1:
			return customer.getName();
		case 2:
			return customer.getAddr();
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
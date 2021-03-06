package com.kadet.kadetBroker.util;

public final class Strings {


	public static final String APP_TITLE = "Broker Tool";
	
	public static final String ADD_CUSTOMER_BUTTON = "Add Customer";
	public static final String REMOVE_CUSTOMER_BUTTON = "Remove Customer";
	public static final String UPDATE_CUSTOMER_BUTTON = "Update Customer";
	public static final String REFRESH_CUSTOMERS_BUTTON = "Refresh";

	public static final String BUY_STOCK_BUTTON = "Buy";
	public static final String SELL_STOCK_BUTTON = "Sell";
    public static final String YOUR_SHARES_LABEL = "Your Shares";
    public static final String STOCKS_LABEL = "All Stocks";
    public static final String STOCK_NAME_LABEL = "Name: ";
    public static final String STOCK_QUANTITY_LABEL = "Quantity: ";


	public static final String CUSTOMER_ID_LABEL = "ID: ";
	public static final String CUSTOMER_NAME_LABEL = "Name: ";
	public static final String CUSTOMER_ADDRESS_LABEL = "Address: ";
	
	public static final String ALL_CUSTOMERS_TAB = "All Customers";
	public static final String CUSTOMER_INFO_TAB = "Customer Info";
	public static final String STOCKS_TAB = "Stocks";

	public static final String LOGGER_LABEL = "Logger";


    /**
     * TextFields TYPES
     */
    public static final String TEXT_FIELD_TYPE = "TextFieldType";
    public static final String ID_TEXT_FIELD = "IdTextField";
    public static final String NAME_TEXT_FIELD = "NameTextField";
    public static final String ADDRESS_TEXT_FIELD = "AddressTextField";

    public static final String STOCK_ID_TEXT_FIELD = "StockIdTextField";
    public static final String STOCKS_QUANTITY_TEXT_FIELD = "StocksQuantityTextField";


    /**
     * Table Fields
     */
    public static final String ID_TABLE_COLUMN_NAME = "Id";
    public static final String NAME_TABLE_COLUMN_NAME = "Name";
    public static final String ADDRESS_TABLE_COLUMN_NAME = "Address";

    public static final String STOCK_SYMBOL_COLUMN = "Symbol";
    public static final String STOCK_PRICE_COLUMN = "Price";

    /**
     * Logger Texts
     */
    public static final String CHOOSE_CUSTOMER = "Please, choose Customer!";


    /**
     * Dialogs
     */
    public static final String ADD_CUSTOMER_DIALOG = "Add new customer";
    public static final String UPDATE_CUSTOMER_DIALOG = "Update customer";

    public static final String RESET_CUSTOMER_BUTTON = "Reset";

    /**
     * Exceptions
     */
    public static final String CAN_NOT_FIND_CUSTOMER_EXCEPTION = "Can not find customer!";
    public static final String CAN_NOT_FIND_CUSTOMER_PORTFOLIO_EXCEPTION = "Can not find customer portfolio!";
    public static final String THERE_IS_NO_SUCH_VIEW_EXCEPTION = "There is no such view in the ViewManager!";

    public static final String CAN_NOT_SEND_DATA = "Can not send data to server!";
    public static final String CAN_NOT_RECEIVE_DATA = "Can not receive data from server!";
    public static final String CAN_NOT_WORK_WITH_SERVER = "Can not work with server!";
    public static final String THREAD_DOES_NOT_CAN_SLEEP = "Thread doesn't can sleep!";


    public static final String PROPERTY_FILE_WAS_NOT_FOUND = "Property file was not found!";
    public static final String READ_PROPERTY_FILE_ERROR = "Read property file error!";

    public static final String UNABLE_TO_INSTANTIATE = "Unable to instantiate: ";
    public static final String NOT_CORRECT_CLASS_NAME = "Not correct class name: ";


    public static final String WRONG_NAME_OF_CONTROLLER_METHOD = "Wrong name of controller method: ";
    public static final String CAN_NOT_INVOKE_CONTROLLER = "Can not invoke controller!";


    /**
     * commands.properties
     */
    public static final String ADD_CUSTOMER_COMMAND = "addCustomerCommand";
    public static final String GET_ALL_CUSTOMERS_COMMAND = "getAllCustomersCommand";
    public static final String REMOVE_CUSTOMER_COMMAND = "removeCustomerCommand";
    public static final String UPDATE_CUSTOMER_COMMAND = "updateCustomerCommand";
    public static final String GET_ALL_STOCKS_COMMAND = "getAllStocksCommand";
    public static final String GET_PORTFOLIO_COMMAND = "getPortfolioCommand";

    
    
    /**
     * RMI
     */
    public static final String CAN_NOT_GET_DATA_FROM_SERVER = "Can not get data from server!";


    /**
     *  Logger INFO
     */
    public static final String ADD_CUSTOMER_WAS_PRESSED = "Add Customer Button was pressed!";
    public static final String REMOVE_CUSTOMER_WAS_PRESSED = "Remove Customer Button was pressed!";
    public static final String UPDATE_CUSTOMER_WAS_PRESSED = "Update Customer Button was pressed!";
    public static final String REFRESH_CUSTOMERS_WAS_PRESSED = "Refresh Customers Button was pressed!";

    public static final String TAB_WAS_CHANGED = "Tab was changed!";

    public static final String NEW_CONTROLLER_WAS_CREATED = "New controller was created!";
    public static final String CONTROLLER_WAS_REMOVED = "Controller was removed!";
    public static final String NEW_VIEW_WAS_CREATED = "New view was created!";
    public static final String VIEW_WAS_REMOVED = "View was removed!";

    /**
     *  Logger Error
     */
    public static final String INITIALIZE_EXCEPTION = "Exception in initialization";
    public static final String REMOTE_EXCEPTION = "Exception with remote";

    public static final String INCORRECT_NEW_CUSTOMER = "Incorrect New Customer!";
    public static final String INCORRECT_UPDATING = "Incorrect updating!";
}

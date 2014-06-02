package com.kadet.kadetBroker.util;

/**
 * Date: 20.05.14
 * Time: 1:10
 *
 * @author Кадет
 */
public final class Strings {

    public static final String RESOURCES_PATH = "resources";

    public static final String DAO_PROPERTIES_PATH = RESOURCES_PATH + "/" + "dao.properties";
    public static final String SQL_BUILDERS_PROPERTIES_PATH = RESOURCES_PATH + "/" + "sql_builders.properties";
    public static final String DB_PROPERTIES_PATH = RESOURCES_PATH + "/" + "db.properties";
    public static final String SERVER_PROPERTIES_PATH = RESOURCES_PATH + "/" + "server.properties";
    public static final String COMMANDS_PROPERTIES_PATH = RESOURCES_PATH + "/" + "commands.properties";

    /**
     * server.properties
     */
    public static final String PORT_PROPERTY_NAME = "port";

    /**
     * DB
     */
    public static final String JDBC_DRIVER = "jdbc_driver";
    public static final String LOGIN = "login";
    public static final String PASSWORD = "password";
    public static final String URL = "url";

    public static final String DB_NAME = "PUBLIC";
    public static final String CUSTOMERS_TABLE = "CUSTOMER";
    public static final String STOCKS_TABLE = "STOCK";
    public static final String SHARES_TABLE = "SHARES";

    public static final String CUSTOMER_ID = "SSN";
    public static final String CUSTOMER_NAME = "CUST_NAME";
    public static final String CUSTOMER_ADDRESS = "ADDRESS";

    public static final String STOCK_ID = "SYMBOL";
    public static final String STOCK_PRICE = "PRICE";

    public static final String SHARE_SSN = "SSN";
    public static final String SHARE_SYMBOL = "SYMBOL";
    public static final String SHARE_QUANTITY = "QUANTITY";


    /**
     *  Fine
     */
    public static final String SERVLET_CONTAINER_WAS_REGISTERED = "Servlet container was registered: ";

    /**
     * Info
     */
    public static final String NEW_SERVLET_WAS_CREATED = "New servlet was created!";
    public static final String NEW_COMMAND_WAS_CREATED = "New command was created!";
    public static final String START_TO_EXECUTE_COMMAND = "Start to execute command!";
    public static final String NEW_SESSION_WAS_CREATED = "New session was created!";
    public static final String NEW_TRANSACTION_WAS_CREATED = "New transaction was created!";
    public static final String SQL_REQUEST = "Sql Request: ";
    public static final String DATA_WAS_RECEIVED_FROM_CACHE = "Data was received from the session cache!";
    public static final String RESULT_TO = "Result TO: ";


    /**
     * Exceptions
     */
    public static final String UNABLE_TO_INSTANTIATE = "Unable to instantiate: ";
    public static final String NOT_CORRECT_CLASS_NAME = "Not correct class name: ";


    public static final String CAN_NOT_CREATE_RMI_REGISTRY = "Can not create rmi registry!";
    public static final String RMI_REGISTRY_WAS_NOT_CREATED = "RMI Registry was not created!";
    public static final String CAN_NOT_REBIND_OBJECT = "Can not rebind object!";

    public static final String CAN_NOT_CREATE_SERVLET_CONTAINER = "Can not create servlet container!";

    public static final String CAN_NOT_CREATE_SQL_BUILDER = "Can not create sql Builder!";


    public static final String COMMAND_HAS_FAILED = "Command has failed!";

    public static final String CAN_NOT_EXECUTE_SQL = "Can not execute SQL!";

    public static final String CAN_NOT_FIND_REQUIRED_JDBC_DRIVER = "Can not find required jdbc driver!";

    /**
     * Sql Exceptions
     */
    public static final String ID_IS_ALREADY_USED = "Id is already used!";


    public static final String BAD_TO_OBJECT_FOR_BUILDING_SQL_QUERY = "Bad Transfer Object for building sql query";
    public static final String BAD_PORT_PROPERTY = "Not correct port property!";
    public static final String OPERATION_ERROR = "Operation was failed!";

    public static final String PROPERTY_FILE_WAS_NOT_FOUND = "Property file was not found!";
    public static final String READ_PROPERTY_FILE_ERROR = "Read property file error!";

    /**
     * DB Exception
     */
    public static final String BAD_DATA_FOR_THE_CONNECTION_TO_THE_DB = "Bad data for the connection to the db!";
    public static final String BAD_CONNECTION_STATEMENT = "Bad connection statement!";
    public static final String BAD_RESULT_SET = "Bad result set!";


}

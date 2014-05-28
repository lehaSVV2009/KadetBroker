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
     * Exceptions
     */
    public static final String NOT_CORRECT_CLASS_NAME = "Not correct class name: ";
    public static final String BAD_TO_OBJECT_FOR_BUILDING_SQL_QUERY = "Bad Transfer Object for building sql query";
    public static final String BAD_PORT_PROPERTY = "Not correct port property!";
    public static final String OPERATION_ERROR = "Operation was failed!";

    /**
     * DB Exception
     */
    public static final String BAD_DATA_FOR_THE_CONNECTION_TO_THE_DB = "Bad data for the connection to the db!";
    public static final String BAD_CONNECTION_STATEMENT = "Bad connection statement!";
    public static final String BAD_RESULT_SET = "Bad result set!";


}

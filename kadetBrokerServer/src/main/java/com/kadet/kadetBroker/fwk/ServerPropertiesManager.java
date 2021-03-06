package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Paths;
import com.kadet.kadetBroker.util.Strings;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Date: 20.05.14
 * Time: 1:07
 *
 * @author Кадет
 */
public class ServerPropertiesManager {

    private static ServerPropertiesManager instance = new ServerPropertiesManager();

    public static ServerPropertiesManager getInstance () {
        return instance;
    }

    private ServerPropertiesManager() {}

    private Properties daoProperties = new Properties();
    private Properties sqlBuildersProperties = new Properties();
    private Properties dbProperties = new Properties();
    private Properties serverProperties = new Properties();
    private Properties commandProperties = new Properties();


    public void initProperties () throws KadetException {
        initSqlBuilderProperties(Paths.SQL_BUILDERS_PROPERTIES_PATH);
        initDAOProperties(Paths.DAO_PROPERTIES_PATH);
        initDBProperties(Paths.DB_PROPERTIES_PATH);
        initServerProperties(Paths.SERVER_PROPERTIES_PATH);
        initCommandProperties(Paths.COMMANDS_PROPERTIES_PATH);
    }


    private void initSqlBuilderProperties (String sqlBuildersPropertiesPath) throws KadetException {
        initPropertyFile(sqlBuildersProperties, sqlBuildersPropertiesPath);
    }


    private void initDAOProperties (String daoPropertiesPath) throws KadetException {
        initPropertyFile(daoProperties, daoPropertiesPath);
    }


    private void initDBProperties (String dbPropertiesPath) throws KadetException {
        initPropertyFile(dbProperties, dbPropertiesPath);
    }


    private void initServerProperties (String serverPropertiesPath) throws KadetException {
        initPropertyFile(serverProperties, serverPropertiesPath);
    }


    private void initCommandProperties (String commandPropertiesPath) throws KadetException {
        initPropertyFile(commandProperties, commandPropertiesPath);
    }


    private void initPropertyFile (Properties properties, String path) throws KadetException {
        try {
            properties.load(getClass().getResourceAsStream(path));
        } catch (FileNotFoundException e) {
            throw new KadetException(Strings.PROPERTY_FILE_WAS_NOT_FOUND + ": " + path);
        } catch (IOException e) {
            throw new KadetException(Strings.READ_PROPERTY_FILE_ERROR + ": " + path);
        }
    }


    /**
     *  Get class name of command by it variable in commands.properties
     */
    public String getCommandClassName (String commandName) {
        return commandProperties.getProperty(commandName);
    }


    /**
     *  Get class name of sql builder by it variable in sqlBuilders.properties
     */
    public String getSqlBuilderClassNameByVariable (String variable) {
        return sqlBuildersProperties.getProperty(variable);
    }


    /**
     *  Get class name of dao by it variable in sqlBuilders.properties
     */
    public String getDAOClassNameByVariable (String variable) {
        return daoProperties.getProperty(variable);
    }


    /**
     *  Get port from server.properties
     */
    public int getPort () throws KadetException {
        String portString = serverProperties.getProperty(Strings.PORT_PROPERTY_NAME);
        try {
            int port = (Integer.parseInt(portString));
            return port;
        } catch (NumberFormatException e) {
            throw new KadetException(Strings.BAD_PORT_PROPERTY + ": " + portString);
        }
    }

    /**
     * @return for example "org.apache.derby.jdbc.ClientDriver"
     */
    public String getJDBCDriverClassName() {
        return dbProperties.getProperty(Strings.JDBC_DRIVER);
    }


    /**
     * @return for example jdbc:derby:C:\\Users\\SarokaA\\StockMarket
     */
    public String getURL () {
        return dbProperties.getProperty(Strings.URL);
    }


    public String getLogin () {
        return dbProperties.getProperty(Strings.LOGIN);
    }


    public String getPassword () {
        return dbProperties.getProperty(Strings.PASSWORD);
    }


}

package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
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

    private ServerPropertiesManager () {}

    private Properties daoProperties = new Properties();
    private Properties sqlBuildersProperties = new Properties();
    private Properties dbProperties = new Properties();
    private Properties serverProperties = new Properties();
    private Properties commandProperties = new Properties();

    public void initProperties () throws KadetException {
        initSqlBuilderProperties(Strings.SQL_BUILDERS_PROPERTIES_PATH);
        initDAOProperties(Strings.DAO_PROPERTIES_PATH);
        initDBProperties(Strings.DB_PROPERTIES_PATH);
        initServerProperties(Strings.SERVER_PROPERTIES_PATH);
        initCommandProperties(Strings.COMMANDS_PROPERTIES_PATH);
    }

    private void initSqlBuilderProperties (String sqlBuildersPropertiesPath) throws KadetException {
        try {
            sqlBuildersProperties.load(new FileInputStream(sqlBuildersPropertiesPath));
        } catch (FileNotFoundException e) {
            throw new KadetException("");
        } catch (IOException e) {
            throw new KadetException("");
        }
    }

    private void initDAOProperties (String daoPropertiesPath) throws KadetException {
        try {
            daoProperties.load(new FileInputStream(daoPropertiesPath));
        } catch (FileNotFoundException e) {
            throw new KadetException("");
        } catch (IOException e) {
            throw new KadetException("");
        }
    }

    private void initDBProperties (String dbPropertiesPath) throws KadetException {
        try {
            dbProperties.load(new FileInputStream(dbPropertiesPath));
        } catch (FileNotFoundException e) {
            throw new KadetException("");
        } catch (IOException e) {
            throw new KadetException("");
        }
    }

    private void initServerProperties (String serverPropertiesPath) throws KadetException {
        try {
            serverProperties.load(new FileInputStream(serverPropertiesPath));
        } catch (FileNotFoundException e) {
            throw new KadetException("");
        } catch (IOException e) {
            throw new KadetException("");
        }
    }

    private void initCommandProperties (String commandPropertiesPath) throws KadetException {
        try {
            commandProperties.load(new FileInputStream(commandPropertiesPath));
        } catch (FileNotFoundException e) {
            throw new KadetException("Not correct path to commands.properties");
        } catch (IOException e) {
            throw new KadetException("Not correct path to commands.properties");
        }
    }

    public String getCommandClassName (String commandName) {
        return commandProperties.getProperty(commandName);
    }


    public String getSqlBuilderClassNameByVariable (String variable) {
        return sqlBuildersProperties.getProperty(variable);
    }

    public String getDAOClassNameByVariable (String variable) {
        return daoProperties.getProperty(variable);
    }

    public int getPort () throws KadetException {
        try {
            String portString = serverProperties.getProperty(Strings.PORT_PROPERTY_NAME);
            int port = (Integer.parseInt(portString));
            return port;
        } catch (NumberFormatException e) {
            throw new KadetException(Strings.BAD_PORT_PROPERTY);
        }
    }

}

package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.security.Decrypter;
import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;
import com.kadet.kadetBroker.util.Strings;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 20.05.14
 * Time: 0:21
 *
 * @author Кадет
 */
public class SqlEngine {

    private static Logger logger = Logger.getLogger(SqlEngine.class.getName());

    private static SqlEngine instance = new SqlEngine();

    public static SqlEngine getInstance () {
        return instance;
    }

    private Connection connection;

    private SqlEngine () {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_FIND_REQUIRED_JDBC_DRIVER, e);
            e.printStackTrace();
        }
    }

    private Connection getConnection () throws KadetException {
        try {
            ServerPropertiesManager propertiesManager = ServerPropertiesManager.getInstance();
            String url = propertiesManager.getURL();
            String login = propertiesManager.getLogin();
            String passwordHash = propertiesManager.getPassword();
            String password = Decrypter.decryptToString(passwordHash);
            return DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Strings.BAD_DATA_FOR_THE_CONNECTION_TO_THE_DB + ": " + e);
            throw new KadetException(Strings.BAD_DATA_FOR_THE_CONNECTION_TO_THE_DB);
        }
    }


    /**
     *  Execute Sql String like "select * from Customer"
     *
     * @return  Object with ResultSet (if select) or with int value (if insert, update, delete)
     * This value is a number of effected rows
     */
    public DBAnswer execute (String sqlRequest, SqlStatementType sqlStatementType) throws KadetException {
        if (connection == null) {
            connection = getConnection();
        }
        try {
            DBAnswer dbAnswer = new DBAnswer();
            Statement statement = connection.createStatement();
            switch (sqlStatementType) {
                case INSERT :
                case UPDATE :
                case DELETE : {
                    int answer = statement.executeUpdate(sqlRequest);
                    dbAnswer.setResult(answer);
                    break;
                }
                case SELECT : {
                    ResultSet resultSet = statement.executeQuery(sqlRequest);
                    dbAnswer.setResultSet(resultSet);
                    break;
                }
            }
            return dbAnswer;
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            logger.log(Level.SEVERE, Strings.ID_IS_ALREADY_USED + ": " + e);
            throw new KadetException(Strings.ID_IS_ALREADY_USED);
        } catch (SQLException e) {
            logger.log(Level.SEVERE, Strings.CAN_NOT_EXECUTE_SQL + ": " + e);
        	throw new KadetException(Strings.CAN_NOT_EXECUTE_SQL);
        }
    }
}

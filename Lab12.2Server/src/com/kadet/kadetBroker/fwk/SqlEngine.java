package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;
import com.kadet.kadetBroker.util.Strings;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.Calendar;
import java.util.Map;

/**
 * Date: 20.05.14
 * Time: 0:21
 *
 * @author Кадет
 */
public class SqlEngine {

    private static SqlEngine instance = new SqlEngine();

    public static SqlEngine getInstance () {
        return instance;
    }

    private Connection connection;

    private SqlEngine () {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Can not find class org.apache.derby.jdbc.ClientDriver");
        }
    }

    private Connection getConnection () throws KadetException {
        try {
            // TODO: from db.properties
            // TODO: hash
            // Path IBA : jdbc:derby:C:\\Users\\SarokaA\\StockMarket
            // PAth IBA Center: jdbc:derby:C:\\Users\\user\\MyDB
            return DriverManager.getConnection("jdbc:derby:C:\\Users\\SarokaA\\StockMarket", "public", "public");
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KadetException(Strings.BAD_DATA_FOR_THE_CONNECTION_TO_THE_DB);
        }
    }


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
                }
            }
            return dbAnswer;
        } catch (SQLException e) {
        	e.printStackTrace();
            throw new KadetException(Strings.BAD_CONNECTION_STATEMENT);
        } finally {

        }
    }
}

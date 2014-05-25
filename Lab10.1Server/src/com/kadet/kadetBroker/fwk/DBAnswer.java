package com.kadet.kadetBroker.fwk;

import java.sql.ResultSet;

/**
 * Date: 22.05.14
 * Time: 7:21
 *
 * @author SarokaA
 */
public class DBAnswer {

    private int result = -1;
    private ResultSet resultSet;

    public int getResult () {
        return result;
    }

    public boolean hasResultSet () {
        return resultSet != null && result == -1;
    }

    public void setResult (int result) {
        this.result = result;
    }

    public ResultSet getResultSet () {
        return resultSet;
    }

    public void setResultSet (ResultSet resultSet) {
        this.resultSet = resultSet;
    }
}

package com.kadet.kadetBroker.transaction;

import com.kadet.kadetBroker.fwk.DBAnswer;
import com.kadet.kadetBroker.sqlBuilder.SqlStatementType;

/**
 * Date: 31.05.14
 * Time: 19:28
 *
 * @author SarokaA
 */
public class SqlOperation {

    private String sql;
    private SqlStatementType sqlStatementType;

    public SqlOperation(String sql, SqlStatementType sqlStatementType) {
        this.sql = sql;
        this.sqlStatementType = sqlStatementType;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public void setSqlStatementType(SqlStatementType sqlStatementType) {
        this.sqlStatementType = sqlStatementType;
    }

    public String getSql() {
        return sql;
    }

    public SqlStatementType getSqlStatementType() {
        return sqlStatementType;
    }
}

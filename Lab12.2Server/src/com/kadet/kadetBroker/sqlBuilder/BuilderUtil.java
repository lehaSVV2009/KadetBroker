package com.kadet.kadetBroker.sqlBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 20.05.14
 * Time: 15:05
 *
 * @author SarokaA
 */
public class BuilderUtil {

    private SqlStatementType sqlStatementType = SqlStatementType.SELECT;

    private List<String> columns = new ArrayList<String>();

    private List<String> tables = new ArrayList<String>();

    private List<String> joins = new ArrayList<String>();

    private List<String> leftJoins = new ArrayList<String>();

    private List<String> wheres = new ArrayList<String>();

    private List<String> orderBys = new ArrayList<String>();

    private List<String> groupBys = new ArrayList<String>();

    private List<String> havings = new ArrayList<String>();

    public BuilderUtil (SqlStatementType sqlStatementType) {
        this.sqlStatementType = sqlStatementType;
    }

    private void appendList(StringBuilder sql, List<String> list, String init,
                            String sep) {
        boolean first = true;
        for (String s : list) {
            if (first) {
                sql.append(init);
            } else {
                sql.append(sep);
            }
            sql.append(s);
            first = false;
        }
    }

    public BuilderUtil column(String name) {
        columns.add(name);
        return this;
    }

    public BuilderUtil column(String name, boolean groupBy) {
        columns.add(name);
        if (groupBy) {
            groupBys.add(name);
        }
        return this;
    }

    public BuilderUtil from(String table) {
        tables.add(table);
        return this;
    }

    public BuilderUtil groupBy(String expr) {
        groupBys.add(expr);
        return this;
    }

    public BuilderUtil having(String expr) {
        havings.add(expr);
        return this;
    }

    public BuilderUtil join(String join) {
        joins.add(join);
        return this;
    }

    public BuilderUtil leftJoin(String join) {
        leftJoins.add(join);
        return this;
    }

    public BuilderUtil orderBy(String name) {
        orderBys.add(name);
        return this;
    }



    @Override
    public String toString() {

        StringBuilder sql = new StringBuilder();
        switch (sqlStatementType) {
            case SELECT : {
                sql.append("select ");
                if (columns.size() == 0) {
                    sql.append("* ");
                }
                break;
            }
            case DELETE : {
                sql.append("delete ");
            }
        }

        if (columns.size() != 0) {
            appendList(sql, columns, "", ", ");
        }

        appendList(sql, tables, " from ", ", ");
        appendList(sql, joins, " join ", " join ");
        appendList(sql, leftJoins, " left join ", " left join ");
        appendList(sql, wheres, " where ", " and ");
        appendList(sql, groupBys, " group by ", ", ");
        appendList(sql, havings, " having ", " and ");
        appendList(sql, orderBys, " order by ", ", ");

        return sql.toString();
    }

    public BuilderUtil where(String expr) {
        wheres.add(expr);
        return this;
    }

}

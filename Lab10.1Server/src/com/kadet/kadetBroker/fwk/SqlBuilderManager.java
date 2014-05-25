package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.sqlBuilder.SqlBuilder;
import com.kadet.kadetBroker.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 20.05.14
 * Time: 0:49
 *
 * @author Кадет
 */
public class SqlBuilderManager {

    private static SqlBuilderManager instance = new SqlBuilderManager();

    public static SqlBuilderManager getInstance () {
        return instance;
    }

    private SqlBuilderManager () {}

    private List<SqlBuilder> sqlBuilders = new ArrayList<SqlBuilder>();

    public SqlBuilder getSqlBuilder (String sqlBuilderClassName) throws KadetException {
        for (SqlBuilder sqlBuilder : sqlBuilders) {
            if (sqlBuilder.getClass().getName().equals(sqlBuilderClassName)) {
                return sqlBuilder;
            }
        }
        try {
            SqlBuilder sqlBuilder = (SqlBuilder)Class.forName(sqlBuilderClassName).newInstance();
            return sqlBuilder;
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        throw new KadetException(Strings.NOT_CORRECT_CLASS_NAME + sqlBuilderClassName);
    }

}

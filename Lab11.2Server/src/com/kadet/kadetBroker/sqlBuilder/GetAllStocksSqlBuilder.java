package com.kadet.kadetBroker.sqlBuilder;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 22.05.14
 * Time: 14:30
 *
 * @author SarokaA
 */
public class GetAllStocksSqlBuilder implements SqlBuilder {
    @Override
    public String build (TO to) throws KadetException {
        return new BuilderUtil(SqlStatementType.SELECT)
                .from(Strings.STOCKS_TABLE)
                .toString();
    }

}

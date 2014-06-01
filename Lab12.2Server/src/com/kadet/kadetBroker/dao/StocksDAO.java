package com.kadet.kadetBroker.dao;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.StockTO;
import com.kadet.kadetBroker.to.StocksListTO;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 14:30
 *
 * @author SarokaA
 */
public class StocksDAO implements DAO {

    @Override
    public TO getTOFromDBAnswer (ResultSet resultSet) throws KadetException {
        StocksListTO stocksListTO = new StocksListTO();
        List<StockTO> stockTOs = new ArrayList<StockTO>();
        try {
            while (resultSet.next()) {
                StockTO stockTO = new StockTO();
                stockTO.setId(resultSet.getString(Strings.STOCK_ID));
                stockTO.setPrice(resultSet.getFloat(Strings.STOCK_PRICE));
                stockTOs.add(stockTO);
                stocksListTO.addStockTO(stockTO);
            }
        } catch (SQLException e) {
            throw new KadetException(Strings.BAD_RESULT_SET);
        }
        return stocksListTO;
    }

}

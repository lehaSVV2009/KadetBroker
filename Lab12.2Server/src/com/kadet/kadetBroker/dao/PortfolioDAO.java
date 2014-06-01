package com.kadet.kadetBroker.dao;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.PortfolioTO;
import com.kadet.kadetBroker.to.ShareTO;
import com.kadet.kadetBroker.to.StockTO;
import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Date: 25.05.14
 * Time: 15:06
 *
 * @author SarokaA
 */
public class PortfolioDAO implements DAO {

    @Override
    public TO getTOFromDBAnswer (ResultSet resultSet) throws KadetException {
        PortfolioTO portfolioTO = new PortfolioTO();
        List<ShareTO> shareTOs = new ArrayList<ShareTO>();
        try {
            while (resultSet.next()) {
                ShareTO shareTO = new ShareTO();
                StockTO stockTO = new StockTO();
                stockTO.setId(resultSet.getString(Strings.SHARE_SYMBOL));
                shareTO.setQuantity(resultSet.getInt(Strings.SHARE_QUANTITY));
                stockTO.setPrice(resultSet.getFloat(Strings.STOCK_PRICE));
                shareTO.setStockTO(stockTO);
                shareTOs.add(shareTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new KadetException(Strings.BAD_RESULT_SET);
        }
        portfolioTO.setShareTOs(shareTOs);
        return portfolioTO;
    }

}

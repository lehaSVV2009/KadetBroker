package com.kadet.kadetBroker.viewModel;

import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.PortfolioTO;
import com.kadet.kadetBroker.to.StockTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 14:40
 *
 * @author SarokaA
 */
public class StocksViewModel implements ViewModel {

    private List<StockTO> stockTOs = new ArrayList<StockTO>();

    private PortfolioTO portfolioTO;

    public void addStock (StockTO stockTO) {
        stockTOs.add(stockTO);
    }

    public void setStockTOs (List<StockTO> stockTOs) {
        this.stockTOs = stockTOs;
    }

    public List<StockTO> getStockTOs () {
        return stockTOs;
    }

    public void setPortfolioTO (PortfolioTO portfolioTO) {
        this.portfolioTO = portfolioTO;
    }

    public PortfolioTO getPortfolioTO () {
        return portfolioTO;
    }
}

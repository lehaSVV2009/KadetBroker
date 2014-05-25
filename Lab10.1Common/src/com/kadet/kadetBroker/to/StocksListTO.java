package com.kadet.kadetBroker.to;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 14:25
 *
 * @author SarokaA
 */
public class StocksListTO implements TO {

    private List<StockTO> stockTOs = new ArrayList<StockTO>();

    public void addStockTO (StockTO stockTO) {
        stockTOs.add(stockTO);
    }

    public List<StockTO> getStockTOs () {
        return stockTOs;
    }

    public void setStockTOs (List<StockTO> stockTOs) {
        this.stockTOs = stockTOs;
    }
}

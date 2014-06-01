package com.kadet.kadetBroker.to;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 14:18
 *
 * @author SarokaA
 */
public class ShareTO implements TO, Entity<Integer> {

    private StockTO stockTO;
    private int quantity;

    private int id;

    public StockTO getStockTO () {
        return stockTO;
    }

    public void setStockTO (StockTO stockTO) {
        this.stockTO = stockTO;
    }

    public int getQuantity () {
        return quantity;
    }

    public void setQuantity (int quantity) {
        this.quantity = quantity;
    }

    @Override
    public Integer getId () {
        return id;
    }

    @Override
    public void setId (Integer id) {
        this.id = id;
    }
}

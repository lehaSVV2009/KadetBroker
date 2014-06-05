package com.kadet.kadetBroker.to;


/**
 * Date: 22.05.14
 * Time: 14:16
 *
 * @author SarokaA
 */
public class StockTO implements TO, Entity<String> {

    private String symbol;
    private float price;

    public float getPrice () {
        return price;
    }

    public void setPrice (float price) {
        this.price = price;
    }

    @Override
    public String getId () {
        return symbol;
    }

    @Override
    public void setId (String id) {
        this.symbol = id;
    }
}

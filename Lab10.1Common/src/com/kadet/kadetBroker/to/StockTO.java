package com.kadet.kadetBroker.to;

import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

/**
 * Date: 22.05.14
 * Time: 14:16
 *
 * @author SarokaA
 */
public class StockTO implements TO, Entity<String> {

    private String symbol;
    private float price;

    public String getSymbol () {
        return symbol;
    }

    public void setSymbol (String symbol) {
        this.symbol = symbol;
    }

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

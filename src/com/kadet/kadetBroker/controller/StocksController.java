package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.dto.StocksDTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Share;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 8:16
 *
 * @author SarokaA
 */
public class StocksController implements Controller {

    private StocksDTO stocksDTO;

    private List<Share> freeShares;
    private List<Share> yourShares;
    private Customer currentCustomer;

    @Override
    public void setModel (DTO model) {
        this.stocksDTO = (StocksDTO) model;
        this.freeShares = stocksDTO.getFreeShares();
        this.yourShares = stocksDTO.getYourShares();
        this.currentCustomer = stocksDTO.getCurrentCustomer();
    }

    @Override
    public DTO getModel () {
        return stocksDTO;
    }
}

package com.kadet.kadetBroker.model;

import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.entity.Portfolio;
import com.kadet.kadetBroker.entity.Share;
import com.kadet.kadetBroker.entity.Stock;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 5:39
 *
 * @author Кадет
 */
public class DataModel {

    private List<Portfolio> portfolios = new ArrayList<Portfolio>();
    private List<Share> freeShares = new ArrayList<Share>();


    public void addPortfolio (Portfolio portfolio) {
        portfolios.add(portfolio);
    }

    public void addCustomer (Customer customer) {
        portfolios.add(new Portfolio(customer));
    }

    public void updateCustomer (Customer customer) {
        for (Portfolio portfolio : portfolios) {
            Customer customerFromList = portfolio.getCustomer();
            if (customerFromList.getId().equals(customer.getId())) {
                customerFromList = customer;
            }
        }
    }

    public void removeCustomer (Customer customer) {
        for (Portfolio portfolio : portfolios) {
            Customer customerFromList = portfolio.getCustomer();
            if (customerFromList.getId().equals(customer.getId())) {
                portfolio = null;
                portfolios.remove(portfolio);
            }
        }

    }

    public Customer getCustomer (Customer customer) throws KadetException {
        for (Portfolio portfolio : portfolios) {
            Customer customerFromList = portfolio.getCustomer();
            if (customerFromList.getId().equals(customer.getId())) {
                return customer;
            }
        }
        throw new KadetException(Strings.CAN_NOT_FIND_CUSTOMER_EXCEPTION);
    }

    public Portfolio getPortfolio (Customer customer) throws KadetException {
        for (Portfolio portfolio : portfolios) {
            Customer customerFromList = portfolio.getCustomer();
            if (customerFromList.getId().equals(customer.getId())) {
                return portfolio;
            }
        }
        throw new KadetException(Strings.CAN_NOT_FIND_CUSTOMER_PORTFOLIO_EXCEPTION);
    }


    public List<Share> getFreeShares () {
        return freeShares;
    }

    public List<Share> getCustomerShares (Customer customer) throws KadetException {
        Portfolio portfolio = getPortfolio(customer);
        return portfolio.getShares();
    }

    public void sellCustomerStocks (Customer customer, Stock stock, int stocksNumber) {

    }

    public void buyStocks (Customer customer, Stock stock, int stocksNumber) {

    }


}

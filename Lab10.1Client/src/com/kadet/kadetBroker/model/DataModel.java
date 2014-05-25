package com.kadet.kadetBroker.model;

import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.PortfolioTO;
import com.kadet.kadetBroker.to.StockTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 16.05.14
 * Time: 5:39
 *
 * @author Кадет
 */
public class DataModel {


    private List<CustomerTO> customerTOs = new ArrayList<CustomerTO>();

    private List<PortfolioTO> portfolioTOs = new ArrayList<PortfolioTO>();

    private List<StockTO> stockTOs = new ArrayList<StockTO>();

    /**
     *
     *  Customers
     *
     */
    public void addCustomerTO (CustomerTO customerTO) {
        customerTOs.add(customerTO);
    }

    public List<CustomerTO> getCustomerTOs () {
        return customerTOs;
    }

    public void setCustomerTOs (List<CustomerTO> customerTOs) {
        this.customerTOs = customerTOs;
    }

    public void updateCustomerTO (CustomerTO customerTO) {
        for (CustomerTO customerTOFromList : customerTOs) {
            if (customerTOFromList.getId().equals(customerTO.getId())) {
                customerTOFromList.setName(customerTO.getName());
                customerTOFromList.setAddress(customerTO.getAddress());
            }
        }
    }

    public void removeCustomerTO (CustomerTO customerTO) {
        for (int customerIndex = 0; customerIndex < customerTOs.size(); ++customerIndex) {
            CustomerTO customerTOFromList = customerTOs.get(customerIndex);
            if (customerTOFromList.getId().equals(customerTO.getId())) {
                customerTOs.remove(customerTOFromList);
                --customerIndex;
            }
        }
    }


    /**
     *
     *
     *  Stocks
     *
     */

    public void setStockTOs (List<StockTO> stockTOs) {
        this.stockTOs = stockTOs;
    }

    public List<StockTO> getStockTOs () {
        return stockTOs;
    }

    public void addPortfolioTO (PortfolioTO portfolioTO) {
        boolean oldPortfolio = false;
        for (PortfolioTO portfolioTOFromList : portfolioTOs) {
            if (portfolioTO.getCustomerTO().getId().equals(portfolioTOFromList.getCustomerTO().getId())) {
                portfolioTOFromList.setCustomerTO(portfolioTO.getCustomerTO());
                portfolioTOFromList.setShareTOs(portfolioTO.getShareTOs());
                oldPortfolio = true;
            }
        }
        if (!oldPortfolio) {
            portfolioTOs.add(portfolioTO);
        }
    }

    public PortfolioTO getPortfolioTO (CustomerTO customerTO) {
        for (PortfolioTO portfolioTO : portfolioTOs) {
            if (portfolioTO.getCustomerTO().getId().equals(customerTO.getId())) {
                return portfolioTO;
            }
        }
        return null;
    }

    /*private List<Portfolio> portfolios = new ArrayList<Portfolio>();
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
                customerFromList.setName(customer.getName());
                customerFromList.setAddress(customer.getAddress());
            }
        }
    }

    public void removeCustomer (Customer customer) {
        for (int portfolioIndex = 0; portfolioIndex < portfolios.size(); ++portfolioIndex) {
            Customer customerFromList = portfolios.get(portfolioIndex).getCustomer();
            if (customerFromList.getId().equals(customer.getId())) {
                portfolios.remove(portfolioIndex);
                --portfolioIndex;
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

    public void buyStocks (Customer customer, Stock stock, int stocksNumber) {}

    public List<Customer> getAllCustomers () {
        List<Customer> customers = new ArrayList<Customer>();
        for (Portfolio portfolio : portfolios) {
            customers.add(portfolio.getCustomer());
        }
        return customers;
    }

    public void setFreeShares (List<Share> freeShares) {
        this.freeShares = freeShares;
    }    */
}
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
        portfolioTOs.clear();
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
}
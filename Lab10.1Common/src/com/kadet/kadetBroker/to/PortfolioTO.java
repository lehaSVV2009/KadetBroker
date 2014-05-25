package com.kadet.kadetBroker.to;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 22.05.14
 * Time: 14:50
 *
 * @author SarokaA
 */
public class PortfolioTO implements TO {

    private CustomerTO customerTO;
    private List<ShareTO> shareTOs = new ArrayList<ShareTO>();

    public CustomerTO getCustomerTO () {
        return customerTO;
    }

    public void setCustomerTO (CustomerTO customerTO) {
        this.customerTO = customerTO;
    }

    public List<ShareTO> getShareTOs () {
        return shareTOs;
    }

    public void setShareTOs (List<ShareTO> shareTOs) {
        this.shareTOs = shareTOs;
    }

    public void addShareTO (ShareTO shareTO) {
        shareTOs.add(shareTO);
    }

}

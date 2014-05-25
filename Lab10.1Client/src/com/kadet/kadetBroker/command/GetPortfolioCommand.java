package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.to.PortfolioTO;

/**
 * Date: 25.05.14
 * Time: 14:21
 *
 * @author SarokaA
 */
public class GetPortfolioCommand extends AbstractCommand {

    private static final long serialVersionUID = 15L;

    @Override
    public void execute () {
        System.out.println("GetPortfolioCommand");
        Dispatcher.getInstance().addPortfolioTO((PortfolioTO)getResult());
        System.out.println("Portfolio shares number: " + ((PortfolioTO)getResult()).getShareTOs().size());
    }
}

package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.to.StocksListTO;

/**
 * Date: 22.05.14
 * Time: 14:15
 *
 * @author SarokaA
 */
public class GetAllStocksCommand extends AbstractCommand {

    private static final long serialVersionUID = 14L;

    @Override
    public void execute () {

        Dispatcher.getInstance().setStockTOs((StocksListTO)getResult());

        System.out.println("--GetAllStocksCommand--");
        System.out.println("Size: " + ((StocksListTO)getResult()).getStockTOs().size());
    }

}

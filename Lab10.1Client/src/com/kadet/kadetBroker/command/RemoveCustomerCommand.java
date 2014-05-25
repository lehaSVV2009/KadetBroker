package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.to.CustomerTO;

/**
 * Date: 20.05.14
 * Time: 16:18
 *
 * @author SarokaA
 */
public class RemoveCustomerCommand extends AbstractCommand {

    private static final long serialVersionUID = 12L;

    @Override
    public void execute () {
        System.out.println("Client.RemoveCustomerCommand from Server was received" + getResult());

        CustomerTO customerTO = (CustomerTO) getResult();
        Dispatcher.getInstance().removeCustomerTO(customerTO);
    }

}

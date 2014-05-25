package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.to.CustomerTO;

/**
 * Date: 20.05.14
 * Time: 16:19
 *
 * @author SarokaA
 */
public class UpdateCustomerCommand extends AbstractCommand {

    private static final long serialVersionUID = 13L;

    @Override
    public void execute () {
        System.out.println("Client.UpdateCustomerCommand from Server was received" + getResult());
        CustomerTO customerTO = (CustomerTO) getResult();
        Dispatcher.getInstance().updateCustomerTO(customerTO);
    }
}

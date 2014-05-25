package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.ViewManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.TO;

/**
 * Date: 22.05.14
 * Time: 1:44
 *
 * @author SarokaA
 */
public class AddCustomerCommand extends AbstractCommand {

    private static final long serialVersionUID = 10L;


    @Override
    public void execute () {
        System.out.println("Client.AddCustomerCommand from Server was received" + getResult());
        Dispatcher.getInstance().addCustomerTO((CustomerTO) getResult());
    }

}

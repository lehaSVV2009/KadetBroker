package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.to.CustomersListTO;

/**
 * Date: 20.05.14
 * Time: 0:58
 *
 * @author Кадет
 */
public class GetAllCustomersCommand extends AbstractCommand {

    private static final long serialVersionUID = 11L;


    @Override
    public void execute () {

        Dispatcher.getInstance().setCustomerTOs((CustomersListTO) getResult());
        /*System.out.println("Client.GetAllCustomersCommand from Server was received" + getResult());
        CustomersListTO customersListTO = (CustomersListTO) getResult();
        for (CustomerTO customerTO : customersListTO.getCustomerTOsList()) {
            System.out.println("Customer: " + customerTO.getId() + "---" + customerTO.getName() + "---" + customerTO.getAddress());
        }*/
    }
}

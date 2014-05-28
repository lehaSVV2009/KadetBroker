package com.kadet.kadetBroker.controller;


import java.rmi.RemoteException;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.*;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.RMIUtils;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.AddCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

/**
 * Date: 18.05.14
 * Time: 6:55
 *
 * @author SarokaA
 */
public class AddCustomerController implements Controller {


    private AddCustomerViewModel viewModel;

    public void addCustomer () {

		try {
			Command command = RegistryManager.getInstance().getCommand(RMIUtils.RMI_ADD_CUSTOMER);
	        command.setTO(viewModel.getNewCustomerTO());
			command.execute();

            Dispatcher.getInstance().addCustomerTO((CustomerTO) command.getResult());

		} catch (KadetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }



    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (AddCustomerViewModel) viewModel;
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }
}

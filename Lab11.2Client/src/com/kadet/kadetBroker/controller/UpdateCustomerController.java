package com.kadet.kadetBroker.controller;

import java.rmi.RemoteException;

import com.kadet.kadetBroker.command.Command;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.CommandManager;
import com.kadet.kadetBroker.fwk.Dispatcher;
import com.kadet.kadetBroker.fwk.RegistryManager;
import com.kadet.kadetBroker.to.CustomerTO;
import com.kadet.kadetBroker.util.RMIUtils;
import com.kadet.kadetBroker.util.Strings;
import com.kadet.kadetBroker.viewModel.UpdateCustomerViewModel;
import com.kadet.kadetBroker.viewModel.ViewModel;

/**
 * Date: 19.05.14
 * Time: 13:43
 *
 * @author SarokaA
 */
public class UpdateCustomerController implements Controller {

    private UpdateCustomerViewModel viewModel;

    @Override
    public void setViewModel (ViewModel viewModel) {
        this.viewModel = (UpdateCustomerViewModel) viewModel;
    }

    @Override
    public ViewModel getViewModel () {
        return viewModel;
    }


    public void updateCustomer () {

		try {
			
			Command command = RegistryManager.getInstance().getCommand(RMIUtils.RMI_UPDATE_CUSTOMER);
	        command.setTO(viewModel.getNewCustomerTO());
			command.execute();
            CustomerTO customerTO = (CustomerTO) command.getResult();
            Dispatcher.getInstance().updateCustomerTO(customerTO);

		} catch (KadetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


}

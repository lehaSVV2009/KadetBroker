package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.fwk.DTOContainer;
import com.kadet.kadetBroker.fwk.PropertyChangingType;

public interface View extends DTOContainer {

	public void refresh ();
    public void refresh (PropertyChangingType propertyChangingType, Object changedObject);

}

package com.kadet.kadetBroker.view;

import com.kadet.kadetBroker.dto.DTO;
import com.kadet.kadetBroker.entity.Customer;
import com.kadet.kadetBroker.fwk.PropertyChangingType;

import javax.swing.*;

/**
 * Date: 16.05.14
 * Time: 8:03
 *
 * @author SarokaA
 */
public class EmptyView extends JPanel implements View {

    @Override
    public void refresh () {

    }

    @Override
    public void refresh (PropertyChangingType changingType, Object changedObject) {

    }


    @Override
    public void setModel (DTO model) {

    }

    @Override
    public DTO getModel () {
        return null;
    }
}

package com.kadet.kadetBroker.controller;

import com.kadet.kadetBroker.dto.DTO;

/**
 * Date: 16.05.14
 * Time: 8:35
 *
 * @author SarokaA
 */
public class EmptyController implements Controller {
    @Override
    public void setModel (DTO model) {

    }

    @Override
    public DTO getModel () {
        return null;
    }
}

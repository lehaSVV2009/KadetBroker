package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.to.TO;

import java.io.Serializable;

/**
 * Date: 22.05.14
 * Time: 0:39
 *
 * @author SarokaA
 */
public interface Command extends Serializable {

    public TO getResult ();
    public void execute ();

}

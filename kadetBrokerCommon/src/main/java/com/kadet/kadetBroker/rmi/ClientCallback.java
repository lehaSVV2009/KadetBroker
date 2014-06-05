package com.kadet.kadetBroker.rmi;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.TO;

import java.rmi.Remote;

/**
 * Date: 31.05.14
 * Time: 16:14
 *
 * @author SarokaA
 */
public interface ClientCallback extends Remote {

    public void answerClient (TO answer, String commandName) throws KadetException;

}

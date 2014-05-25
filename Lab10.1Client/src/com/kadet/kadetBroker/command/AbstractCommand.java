package com.kadet.kadetBroker.command;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.TO;

/**
 * Date: 22.05.14
 * Time: 1:43
 *
 * @author SarokaA
 */
public abstract class AbstractCommand implements Command {

    private static final long serialVersionUID = 1L;

    protected KadetException exception;

    protected TO toServer;
    protected TO fromServer;

    public void setToServer(TO toServer) {
        this.toServer = toServer;
    }

    @Override
    public TO getResult () {
        return fromServer;
    }
}

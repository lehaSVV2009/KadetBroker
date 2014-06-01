package com.kadet.kadetBroker.server;

/**
 * Date: 22.05.14
 * Time: 4:49
 *
 * @author SarokaA
 */
public abstract class AbstractToServerSender {



    abstract public void preSendingToServer (Object sendingObject);

    abstract public void preAnswerFromServer ();

    abstract public void postAnswerFromServer (Object answer);

}

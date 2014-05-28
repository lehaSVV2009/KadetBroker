package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.rmi.Session;

/**
 * Date: 28.05.14
 * Time: 4:32
 *
 * @author SarokaA
 */
public class SessionFactory {

    private final static SessionFactory instance = new SessionFactory();

    public static SessionFactory getInstance () {
        return instance;
    }

    private SessionFactory() {}

    public Session createSession (String sessionClassName) {
        try {
            return (Session) Class.forName(sessionClassName).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate" + sessionClassName);
        }
    }


}

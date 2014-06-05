package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.session.Session;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 31.05.14
 * Time: 18:25
 *
 * @author SarokaA
 */
public class SessionFactory {

    private final static SessionFactory instance = new SessionFactory();

    public static SessionFactory getInstance () {
        return instance;
    }

    private SessionFactory() {}

    public static Session createSession (String className) {
        try {
            return (Session) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(Strings.UNABLE_TO_INSTANTIATE + className);
        }
    }


}

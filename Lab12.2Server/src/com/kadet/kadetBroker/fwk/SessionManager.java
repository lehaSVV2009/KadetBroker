package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.session.ClientSession;
import com.kadet.kadetBroker.session.Session;
import com.kadet.kadetBroker.util.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 31.05.14
 * Time: 18:23
 *
 * @author SarokaA
 */
public class SessionManager {

    private static Logger logger = Logger.getLogger(SessionManager.class.getName());

    private final static SessionManager instance = new SessionManager();

    public static SessionManager getInstance () {
        return instance;
    }

    private SessionManager() {}


    private Map<String, Session> sessions = new HashMap<String, Session>();

    public Session getSession (String key) {
        return sessions.get(key);
    }

    public Session newClientSession (String key) {
        if (sessions.containsKey(key)) {
            sessions.remove(key);
        }
        Session newSession = SessionFactory.createSession(ClientSession.class.getName());
        sessions.put(key, newSession);
        logger.log(Level.INFO, Strings.NEW_SESSION_WAS_CREATED, newSession);
        return newSession;
    }


}

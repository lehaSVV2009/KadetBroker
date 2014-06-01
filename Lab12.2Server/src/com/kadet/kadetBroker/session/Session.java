package com.kadet.kadetBroker.session;

import com.kadet.kadetBroker.to.TO;

/**
 * Date: 31.05.14
 * Time: 18:24
 *
 * @author SarokaA
 */
public interface Session {

    public TO getLastRequestResult(String request);
    public void addSessionCacheItem(SessionCacheItem sessionCacheItem);

}

package com.kadet.kadetBroker.session;

import com.kadet.kadetBroker.to.TO;
import com.kadet.kadetBroker.util.Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 31.05.14
 * Time: 18:28
 *
 * @author SarokaA
 */
public class ClientSession implements Session {

    private static Logger logger = Logger.getLogger(ClientSession.class.getName());

    private List<SessionCacheItem> sessionCacheItems = new ArrayList<SessionCacheItem>();

    /**
     * During this time period info in cache is fresh
     */
    public static int freshInfoTimePeriod = 10000;

    @Override
    public TO getLastRequestResult(String request) {
        for (SessionCacheItem cacheItem : sessionCacheItems) {
            if (request.equals(cacheItem.getRequest())) {
                TO to = cacheItem.getResultByFreshness(freshInfoTimePeriod);
                if (to != null) {
                    logger.log(Level.INFO, Strings.DATA_WAS_RECEIVED_FROM_CACHE);
                }
                return to;
            }
        }
        return null;
    }

    @Override
    public void addSessionCacheItem(SessionCacheItem sessionCacheItem) {
        sessionCacheItems.add(sessionCacheItem);
    }
}

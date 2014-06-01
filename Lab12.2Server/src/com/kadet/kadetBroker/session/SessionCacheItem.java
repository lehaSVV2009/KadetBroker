package com.kadet.kadetBroker.session;

import com.kadet.kadetBroker.to.TO;

import java.util.Calendar;
import java.util.Date;

/**
 * Date: 31.05.14
 * Time: 18:47
 *
 * @author SarokaA
 */
public class SessionCacheItem {

    private String request;
    private TO result;
    private Date date;

    public SessionCacheItem(String request, TO result, Date date) {
        this.request = request;
        this.result = result;
        this.date = date;
    }

    public String getRequest() {
        return request;
    }

    public TO getResultByDate (Date requiredDate) {
        return date.after(requiredDate) ? result : null;
    }

    public TO getResultByFreshness (int freshness) {
        return date.after(
                new Date(Calendar.getInstance().getTimeInMillis() - freshness))? result : null;
    }

}

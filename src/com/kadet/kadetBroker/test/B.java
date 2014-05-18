package com.kadet.kadetBroker.test;

import java.util.List;

/**
 * Date: 18.05.14
 * Time: 7:48
 *
 * @author SarokaA
 */
public class B {

    private List<C> cList;

    public B (List<C> cList) {
        this.cList = cList;
    }

    @Override
    public String toString () {
        return "B{" +
                "cList=" + cList +
                '}';
    }
}

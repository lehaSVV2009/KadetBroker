package com.kadet.kadetBroker.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 18.05.14
 * Time: 7:48
 *
 * @author SarokaA
 */
public class A {

    private List<C> cList;

    public A (List<C> cList) {
        this.cList = cList;
    }

    public void changeList () {
        cList.remove(0);
    }

    @Override
    public String toString () {
        return "A{" +
                "cList=" + cList +
                '}';
    }
}

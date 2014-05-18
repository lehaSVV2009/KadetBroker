package com.kadet.kadetBroker.test;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 18.05.14
 * Time: 7:50
 *
 * @author SarokaA
 */
public class Test {

    public static void main (String[] args) {

        List<C> cList = new ArrayList<C>();
        cList.add(new C("`123"));
        cList.add(new C("`456"));
        cList.add(new C("`789"));
        cList.add(new C("`234"));

        A a = new A(cList);

        B b = new B(cList);

        a.changeList();

        System.out.println("a: " + a + "b: " + b);

    }

}

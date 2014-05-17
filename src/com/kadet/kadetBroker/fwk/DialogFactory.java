package com.kadet.kadetBroker.fwk;

/**
 * Date: 17.05.14
 * Time: 7:12
 *
 * @author SarokaA
 */
public class DialogFactory {


    private final static DialogFactory instance = new DialogFactory();

    public static DialogFactory getInstance () {
        return instance;
    }

    private DialogFactory () {}



}

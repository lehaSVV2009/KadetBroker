package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.view.View;

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

    public static View createDialog (String className) {
        try {
            return (View) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException("Unable to instantiate" + className);
        }
    }

}

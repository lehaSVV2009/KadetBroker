package com.kadet.kadetBroker.fwk;

import com.rits.cloning.Cloner;

/**
 * Date: 16.05.14
 * Time: 5:15
 *
 * @author Кадет
 */
public class ProxyManager {

    private final static ProxyManager instance = new ProxyManager();

    public static ProxyManager getInstance () {
        return instance;
    }

    private ProxyManager() {}

    private Cloner cloner = new Cloner();

    public Object deepClone (Object clonedObject) {
        return cloner.deepClone(clonedObject);
    }
    
}

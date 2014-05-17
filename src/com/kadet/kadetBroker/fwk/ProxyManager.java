package com.kadet.kadetBroker.fwk;

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

    public Object deepClone (Object clonedObject) {
        return clonedObject;
    }
    
}

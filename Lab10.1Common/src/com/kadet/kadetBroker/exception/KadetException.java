package com.kadet.kadetBroker.exception;

import java.io.Serializable;

/**
 * Date: 22.05.14
 * Time: 1:52
 *
 * @author SarokaA
 */
public class KadetException extends Exception implements Serializable {

    public KadetException (String message) {
        super(message);
    }
}

package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.transaction.TransactionManager;
import com.kadet.kadetBroker.util.Strings;

/**
 * Date: 31.05.14
 * Time: 18:25
 *
 * @author SarokaA
 */
public class TransactionFactory {

    private final static TransactionFactory instance = new TransactionFactory();

    public static TransactionFactory getInstance () {
        return instance;
    }

    private TransactionFactory() {}

    public static TransactionManager createTransaction(String className) {
        try {
            return (TransactionManager) Class.forName(className).newInstance();
        } catch (Exception e) {
            throw new IllegalArgumentException(Strings.UNABLE_TO_INSTANTIATE + className);
        }
    }


}

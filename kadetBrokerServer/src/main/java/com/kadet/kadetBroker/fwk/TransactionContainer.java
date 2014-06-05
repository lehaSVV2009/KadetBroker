package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.transaction.ClientTransactionManager;
import com.kadet.kadetBroker.transaction.TransactionManager;
import com.kadet.kadetBroker.util.Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Date: 31.05.14
 * Time: 18:23
 *
 * @author SarokaA
 */
public class TransactionContainer {

    private static Logger logger = Logger.getLogger(TransactionContainer.class.getName());

    private final static TransactionContainer instance = new TransactionContainer();

    public static TransactionContainer getInstance () {
        return instance;
    }

    private TransactionContainer() {}


    private Map<String, TransactionManager> transactions = new HashMap<String, TransactionManager>();


    public TransactionManager getTransaction (String key) {
        return transactions.get(key);
    }


    public TransactionManager newClientTransaction (String key) {
        if (transactions.containsKey(key)) {
            transactions.remove(key);
        }
        TransactionManager newTransactionManager = TransactionFactory.createTransaction(ClientTransactionManager.class.getName());
        transactions.put(key, newTransactionManager);
        logger.log(Level.INFO, Strings.NEW_TRANSACTION_WAS_CREATED, newTransactionManager);
        return newTransactionManager;
    }


}

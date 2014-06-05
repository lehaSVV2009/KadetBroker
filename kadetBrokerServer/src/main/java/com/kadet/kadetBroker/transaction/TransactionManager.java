package com.kadet.kadetBroker.transaction;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.DBAnswer;

import java.util.List;

/**
 * Date: 31.05.14
 * Time: 19:07
 *
 * @author SarokaA
 */
public interface TransactionManager {

    public DBAnswer executeTransaction (SqlOperation sqlOperation) throws KadetException;

}

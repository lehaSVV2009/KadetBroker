package com.kadet.kadetBroker.sqlBuilder;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.to.TO;

/**
 * Date: 20.05.14
 * Time: 0:23
 *
 * @author Кадет
 */
public interface SqlBuilder {

    public String build (TO to) throws KadetException;

}

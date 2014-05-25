package com.kadet.kadetBroker.dao;

import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.fwk.DBAnswer;
import com.kadet.kadetBroker.to.TO;

import java.sql.ResultSet;

/**
 * Date: 20.05.14
 * Time: 0:25
 *
 * @author Кадет
 */
public interface DAO {

    public TO getTOFromDBAnswer (ResultSet resultSet) throws KadetException;

}

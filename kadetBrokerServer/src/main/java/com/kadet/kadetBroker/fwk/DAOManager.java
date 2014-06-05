package com.kadet.kadetBroker.fwk;

import com.kadet.kadetBroker.dao.DAO;
import com.kadet.kadetBroker.exception.KadetException;
import com.kadet.kadetBroker.util.Strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Date: 20.05.14
 * Time: 0:49
 *
 * @author Кадет
 */
public class DAOManager {

    private static DAOManager instance = new DAOManager();

    public static DAOManager getInstance () {
        return instance;
    }

    private DAOManager () {}

    private List<DAO> daos = new ArrayList<DAO>();

    public DAO getDAO (String daoClassName) throws KadetException {
        for (DAO dao : daos) {
            if (dao.getClass().getName().equals(daoClassName)) {
                return dao;
            }
        }
        try {
            DAO dao = (DAO)Class.forName(daoClassName).newInstance();
            return dao;
        } catch (InstantiationException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (IllegalAccessException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        throw new KadetException(Strings.NOT_CORRECT_CLASS_NAME + daoClassName);
    }

    
}

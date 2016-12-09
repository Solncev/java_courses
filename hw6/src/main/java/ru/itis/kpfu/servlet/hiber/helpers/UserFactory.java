package ru.itis.kpfu.servlet.hiber.helpers;

import ru.itis.kpfu.servlet.hiber.dao.UserDao;
import ru.itis.kpfu.servlet.hiber.daoImpl.UserDaoImpl;

/**
 * Created by Марат on 09.12.2016.
 */
public class UserFactory {
    private static UserDao userDAO = null;
    private static UserFactory instance = null;

    public static synchronized UserFactory getInstance() {
        if (instance == null) {
            instance = new UserFactory();
        }
        return instance;
    }

    public UserDao getUserDao() {
        if (userDAO == null) {
            userDAO = (UserDao) new UserDaoImpl();
        }
        return userDAO;
    }
}

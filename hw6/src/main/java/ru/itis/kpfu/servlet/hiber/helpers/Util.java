package ru.itis.kpfu.servlet.hiber.helpers;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by Марат on 09.12.2016.
 */
public class Util {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}

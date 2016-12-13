package dao.impl.hibernate;

import dao.CVDao;
import dao.factory.HibernateConnectionFactory;
import model.CV;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class CVDaoHibernateImpl implements CVDao {
    public CV getCvById(Long cvId) {
        //TODO: 5 get cv by id, using hibernate
        Session session = null;
        CV cv = new CV();
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            cv = session.get(CV.class, cvId);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }

        return cv;
    }

    public List<CV> cvList() {
        //TODO: 3. get list of cvs by hibernate
        Session session = null;
        List list = new ArrayList();
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            list = session.createCriteria(CV.class).list();
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }

    public void add(CV cv) {
        //TODO: 12. add new CV to db by hibernate

        Session session = null;
        try {
            session = HibernateConnectionFactory.getSessionFactory().openSession();
            session.save(cv);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}

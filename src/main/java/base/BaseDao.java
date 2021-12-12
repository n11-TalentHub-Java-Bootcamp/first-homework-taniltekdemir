package base;

import hibernate.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class BaseDao {

    private SessionFactory sessionFactory;

    public BaseDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    protected Session getCurrentSession() {
        return sessionFactory.openSession();
    }
}

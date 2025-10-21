package dao;

import entities.Machine;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.HibernateUtil;

import java.util.Date;
import java.util.List;

public class MachineDao extends DaoImpl<Machine> {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    protected Class<?> getEntityClass() {
        return Machine.class;
    }

    public List<Machine> findBetweenDate(Date d1, Date d2) {
        Session session = sessionFactory.openSession();
        try {
            return session.getNamedQuery("findBetweenDate")
                    .setParameter("d1", d1)
                    .setParameter("d2", d2)
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
}


package dao.impl;

import dao.admin_dao;
import models.admin;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class admin_dao_impl implements admin_dao {

    @Override
    public void create(admin _admin) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(_admin);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("admin_create Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void update(admin _admin) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(_admin);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("admin_update Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void delete(admin _admin) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(_admin);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("admin_delete Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public admin read_by_id(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        admin _admin = session.get(admin.class, id);
        session.close();
        return _admin;
    }

    @Override
    public admin read_by_login(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<admin> query = session.createQuery("FROM admin WHERE admin_login = :param", admin.class)
                .setParameter("param", login);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }
}

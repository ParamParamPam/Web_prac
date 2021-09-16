package dao.impl;

import dao.customer_dao;
import models.product;
import models.customer;
import models.orders;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;


public class customer_dao_impl implements customer_dao{

    public void create(customer _customer) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(_customer);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("customer_create Exception thrown: " + e.getMessage());
        }
    }

    public void update(customer _customer) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(_customer);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("customer_update Exception thrown: " + e.getMessage());
        }
    }

    public void delete(customer _customer) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(_customer);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("customer_delete Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public customer read_by_id(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<customer> query = session.createQuery("FROM customer WHERE id = :param", customer.class)
                .setParameter("param", id);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }

    @Override
    public customer read_by_login(String login) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<customer> query = session.createQuery("FROM customer WHERE customer_login = :param", customer.class)
                .setParameter("param", login);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }

    @Override
    public List<customer> read_customers() {

        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<customer> query = session.createQuery("FROM customer", customer.class);
        return query.getResultList();
    }

}

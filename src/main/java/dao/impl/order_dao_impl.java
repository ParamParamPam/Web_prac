package dao.impl;

import dao.order_dao;
import models.product;
import models.customer;
import models.orders;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;

public class order_dao_impl implements order_dao{

    public void create(orders _order) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(_order);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("order_create Exception thrown: " + e.getMessage());
        }
    }

    public void update(orders _order) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(_order);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("order_update Exception thrown: " + e.getMessage());
        }
    }

    public void delete(orders _order) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(_order);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("order_delete Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public orders read_by_id(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        orders _order = session.get(orders.class, id);
        session.close();
        return _order;
    }

    @Override
    public List<orders> read_by_customer(customer customer) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<orders> query = session.createQuery("FROM orders WHERE customer_id = :param", orders.class)
                .setParameter("param", customer);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList();
    }

    @Override
    public List<orders> read_orders() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        CriteriaQuery<orders> criteria = session.getCriteriaBuilder().createQuery(orders.class);
        criteria.from(orders.class);
        List<orders> data = session.createQuery(criteria).getResultList();
        session.close();
        return data;
        /*Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<order> query = session.createQuery("FROM order", order.class);
        return query.getResultList();*/
        /*List<order> orders = new ArrayList<>();
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query<order> query = session.createQuery("FROM order", order.class);
        orders = (List<order>) query.list();
        session.getTransaction().commit();
        session.close();
        return orders;*/
    }
}

package dao.impl;

import dao.product_dao;
import models.product;
import models.customer;
import utils.HibernateSessionFactoryUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class product_dao_impl implements product_dao{

    @Override
    public void create(product _product) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.save(_product);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("product_create Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void update(product _product) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.update(_product);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("product_update Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public void delete(product _product) {
        try {
            Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
            Transaction tx1 = session.beginTransaction();
            session.delete(_product);
            tx1.commit();
            session.close();
        } catch (Exception e) {
            System.out.println("product_delete Exception thrown: " + e.getMessage());
        }
    }

    @Override
    public product read_by_id(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<product> query = session.createQuery("FROM product WHERE id = :param", product.class)
                .setParameter("param", id);
        if (query.getResultList().size() == 0) {
            return null;
        }
        return query.getResultList().get(0);
    }

    @Override
    public List<product> read_list_by_type(String type) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<product> query = session.createQuery("FROM product WHERE type = :param", product.class)
                .setParameter("param", type);
        return query.getResultList();
    }

    @Override
    public List<product> read_list_by_title(String title) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<product> query = session.createQuery("FROM product WHERE title = :param", product.class)
                .setParameter("param", title);
        return query.getResultList();
    }

    @Override
    public List<product> read_list_by_company(String company) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<product> query = session.createQuery("FROM product WHERE company = :param", product.class)
                .setParameter("param", company);
        return query.getResultList();
    }

    @Override
    public List<product> read_list_by_characteristics(String characteristics) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<product> query = session.createQuery("FROM product WHERE characteristics = :param", product.class)
                .setParameter("param", characteristics);
        return query.getResultList();
    }

    @Override
    public int product_amount(product _product) {
        return _product.get_amount();
    }

    @Override
    public double product_price(product _product) {
        return _product.get_price();
    }

    @Override
    public List<product> all_products() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Query<product> query = session.createQuery("FROM product", product.class);
        return query.getResultList();
    }
}

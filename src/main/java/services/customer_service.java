package services;

import dao.customer_dao;
import dao.impl.customer_dao_impl;
import models.customer;
import models.orders;
import java.util.List;

public class customer_service {

    private customer_dao _customer_dao = new customer_dao_impl();

    public void create_customer(customer _customer) {
        _customer_dao.create(_customer);
    }

    public void update_customer(customer _customer) {
        _customer_dao.update(_customer);
    }

    public void delete_customer(customer _customer) {
        _customer_dao.delete(_customer);
    }

    public customer read_customer_by_id(int id) {
        return _customer_dao.read_by_id(id);
    }

    public customer read_customer_by_login(String login) {
        return _customer_dao.read_by_login(login);
    }

    public List<customer> read_customers() {
        return _customer_dao.read_customers();
    }

}

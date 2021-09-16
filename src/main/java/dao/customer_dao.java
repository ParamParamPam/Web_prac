package dao;

import models.customer;
import models.orders;

import java.util.List;

public interface customer_dao {
    void create(customer _customer);
    void update(customer _customer);
    void delete(customer _customer);
    customer read_by_id(int id);
    customer read_by_login(String login);
    List<customer> read_customers();
}

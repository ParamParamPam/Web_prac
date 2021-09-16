package dao;

import models.customer;
import models.orders;

import java.util.List;

public interface order_dao {
    void create(orders _order);
    void update(orders _order);
    void delete(orders _order);
    orders read_by_id(int id);
    List<orders> read_by_customer(customer _customer);
    List<orders> read_orders();
}

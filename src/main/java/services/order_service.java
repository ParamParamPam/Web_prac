package services;

import dao.impl.order_dao_impl;
import dao.order_dao;
import models.product;
import models.customer;
import models.orders;
import java.util.List;

public class order_service {

    private order_dao _order_dao = new order_dao_impl();

    public void create_order(orders _order) {
        _order_dao.create(_order);
    }

    public void update_order(orders _order) {
        _order_dao.update(_order);
    }

    public void delete_order(orders _order) {
        _order_dao.delete(_order);
    }

    public orders read_order_by_id(int id) {
        return _order_dao.read_by_id(id);
    }

    public List<orders> read_order_by_customer_id(customer _customer) {
        return _order_dao.read_by_customer(_customer);
    }

    public List<orders> read_orders() {
        return _order_dao.read_orders();
    }

}

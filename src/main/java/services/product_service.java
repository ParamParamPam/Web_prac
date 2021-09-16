package services;

import dao.product_dao;
import dao.impl.product_dao_impl;
import models.product;
import models.customer;
import java.util.List;

public class product_service {

    private product_dao _product_dao = new product_dao_impl();

    public void create_product(product _product) {
        _product_dao.create(_product);
    }

    public void update_product(product _product) {
        _product_dao.update(_product);
    }

    public void delete_product(product _product) {
        _product_dao.delete(_product);
    }

    public product read_product_by_id(int id) {
        return _product_dao.read_by_id(id);
    }

    public List<product> read_product_list_by_type(String type) {
        return _product_dao.read_list_by_type(type);
    }

    public List<product> read_product_list_by_company(String company) {
        return _product_dao.read_list_by_company(company);
    }

    public List<product> read_product_list_by_title(String title) {
        return _product_dao.read_list_by_title(title);
    }

    public List<product> read_product_list_by_characteristics(String characteristics) {
        return _product_dao.read_list_by_characteristics(characteristics);
    }

    public List<product> read_all_products() {
        return _product_dao.all_products();
    }

}

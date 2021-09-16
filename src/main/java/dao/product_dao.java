package dao;

import models.product;
import models.customer;

import java.util.List;

public interface product_dao {
    void create(product _product);
    void update(product _product);
    void delete(product _product);
    product read_by_id(int id);
    List<product> read_list_by_type(String type);
    List<product> read_list_by_title(String title);
    List<product> read_list_by_company(String company);
    List<product> read_list_by_characteristics(String characteristics);
    int product_amount(product _product);
    double product_price(product _product);
    List<product> all_products();
}

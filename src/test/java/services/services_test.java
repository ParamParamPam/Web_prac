package services;

import models.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class services_test {
    private admin_service _admin_service = new admin_service();
    private customer_service _customer_service = new customer_service();
    private product_service _product_service = new product_service();
    private order_service _order_service = new order_service();


    @Test
    public void test_create_admin() {
        admin new_admin = new admin("admin_TestCreate", "psswd");
        _admin_service.create_admin(new_admin);

        admin check_admin = _admin_service.read_admin_by_id(new_admin.get_id());

        Assert.assertEquals(new_admin, check_admin);

        _admin_service.delete_admin(new_admin);
    }

    @Test
    public void test_create_customer() {
        customer new_customer = new customer("customer_TestCreate", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);

        customer check_customer = _customer_service.read_customer_by_id(new_customer.get_id());

        Assert.assertEquals(new_customer, check_customer);

        _customer_service.delete_customer(new_customer);
    }

    @Test
    public void test_create_product() {
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);

        product check_product = _product_service.read_product_by_id(new_product.get_id());

        Assert.assertEquals(new_product, check_product);

        _product_service.delete_product(new_product);
    }

    @Test
    public void test_create_order() {
        customer new_customer = new customer("customer_TestCreate", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);


        orders new_order = new orders(new_customer,  new_product, "test_address", java.sql.Date.valueOf("2021-01-01"), java.sql.Date.valueOf("2021-01-01"), "String status", 100);

        _order_service.create_order(new_order);
        orders check_order = _order_service.read_order_by_id(new_order.get_id());
        Assert.assertEquals(new_order, check_order);
        _order_service.delete_order(new_order);
        _customer_service.delete_customer(new_customer);
        _product_service.delete_product(new_product);
    }

    @Test
    public void test_update_admin() {
        admin new_admin = new admin("admin_TestUpdate", "psswd");
        _admin_service.create_admin(new_admin);
        admin check_admin = _admin_service.read_admin_by_id(new_admin.get_id());
        Assert.assertEquals(new_admin, check_admin);

        new_admin.set_psswd("newpsswd");
        _admin_service.update_admin(new_admin);
        check_admin = _admin_service.read_admin_by_id(new_admin.get_id());
        Assert.assertEquals(new_admin, check_admin);

        _admin_service.delete_admin(new_admin);
    }

    @Test
    public void test_update_customer() {
        customer new_customer = new customer("customer_TestUpdate", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);

        customer check_customer = _customer_service.read_customer_by_id(new_customer.get_id());
        Assert.assertEquals(new_customer, check_customer);

        new_customer.set_psswd("newpsswd");
        _customer_service.update_customer(new_customer);
        check_customer = _customer_service.read_customer_by_id(new_customer.get_id());
        Assert.assertEquals(new_customer, check_customer);

        _customer_service.delete_customer(new_customer);
    }

    @Test
    public void test_update_product() {
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);
        product check_product = _product_service.read_product_by_id(new_product.get_id());
        Assert.assertEquals(new_product, check_product);

        new_product.set_type("new_test_type");
        _product_service.update_product(new_product);
        check_product = _product_service.read_product_by_id(new_product.get_id());
        Assert.assertEquals(new_product, check_product);
        _product_service.delete_product(new_product);
    }

    @Test
    public void test_update_order() {
        customer new_customer = new customer("customer_TestCreate", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);


        orders new_order = new orders(new_customer,  new_product, "test_address", java.sql.Date.valueOf("2021-01-01"), java.sql.Date.valueOf("2021-01-01"), "String status", 100);

        _order_service.create_order(new_order);
        orders check_order = _order_service.read_order_by_id(new_order.get_id());
        Assert.assertEquals(new_order, check_order);

        new_order.set_address("new_test_address");
        _order_service.update_order(new_order);

        check_order = _order_service.read_order_by_id(new_order.get_id());
        Assert.assertEquals(new_order, check_order);
        _order_service.delete_order(new_order);
        _customer_service.delete_customer(new_customer);
        _product_service.delete_product(new_product);
    }


    @Test
    public void test_delete_admin() {
        admin new_admin = new admin("admin_TestDelete", "psswd");
        _admin_service.create_admin(new_admin);
        admin check_admin = _admin_service.read_admin_by_id(new_admin.get_id());
        Assert.assertEquals(new_admin, check_admin);

        _admin_service.delete_admin(new_admin);
        check_admin = _admin_service.read_admin_by_id(new_admin.get_id());
        Assert.assertNull(check_admin);
    }

    @Test
    public void test_delete_customer() {
        customer new_customer = new customer("customer_TestDelete", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);
        customer check_customer = _customer_service.read_customer_by_id(new_customer.get_id());
        Assert.assertEquals(new_customer, check_customer);

        _customer_service.delete_customer(new_customer);
        check_customer = _customer_service.read_customer_by_id(new_customer.get_id());
        Assert.assertNull(check_customer);
    }

    @Test
    public void test_delete_product() {
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);
        product check_product = _product_service.read_product_by_id(new_product.get_id());
        Assert.assertEquals(new_product, check_product);
        _product_service.delete_product(new_product);

        check_product = _product_service.read_product_by_id(new_product.get_id());
        Assert.assertNull(check_product);

    }

    @Test
    public void test_delete_order() {
        customer new_customer = new customer("customer_TestCreate", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);


        orders new_order = new orders(new_customer,  new_product, "test_address", java.sql.Date.valueOf("2021-01-01"), java.sql.Date.valueOf("2021-01-01"), "String status", 100);

        _order_service.create_order(new_order);
        orders check_order = _order_service.read_order_by_id(new_order.get_id());
        Assert.assertEquals(new_order, check_order);

        _order_service.delete_order(new_order);
        _customer_service.delete_customer(new_customer);
        _product_service.delete_product(new_product);
        check_order = _order_service.read_order_by_id(new_order.get_id());
        Assert.assertNull(check_order);
    }

    @Test
    public void test_read_admin_by_id() {
        admin new_admin = new admin("admin_TestReadAdminById", "psswd");
        _admin_service.create_admin(new_admin);
        admin check_admin = _admin_service.read_admin_by_id(new_admin.get_id());
        Assert.assertEquals(new_admin.get_id(), check_admin.get_id());
        _admin_service.delete_admin(new_admin);
    }

    @Test
    public void test_read_customer_by_id() {
        customer new_customer = new customer("customer_TestReadCustomerById", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);
        customer check_customer = _customer_service.read_customer_by_id(new_customer.get_id());

        Assert.assertEquals(new_customer.get_id(), check_customer.get_id());

        _customer_service.delete_customer(new_customer);
    }

    @Test
    public void test_read_product_by_id() {
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);
        product check_product = _product_service.read_product_by_id(new_product.get_id());
        Assert.assertEquals(new_product.get_id(), check_product.get_id());
        _product_service.delete_product(new_product);
    }


    @Test
    public void test_read_admin_by_login() {
        admin new_admin = new admin("admin_TestReadAdminByLogin", "psswd");
        _admin_service.create_admin(new_admin);
        admin check_admin = _admin_service.read_admin_by_login("admin_TestReadAdminByLogin");

        Assert.assertEquals("admin_TestReadAdminByLogin", check_admin.get_login());
        _admin_service.delete_admin(new_admin);
    }

    @Test
    public void test_read_customer_by_login() {
        customer new_customer = new customer("customer_TestReadCustomerByLogin", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);
        customer check_customer = _customer_service.read_customer_by_login("customer_TestReadCustomerByLogin");

        Assert.assertEquals("customer_TestReadCustomerByLogin", check_customer.get_login());
        _customer_service.delete_customer(check_customer);
    }

    @Test
    public void test_read_product_list_by_title() {
        product new_product = new product(100, 10, "test_type1", "test_title", "test_company1", "test_assemble_place",  "test_characteristics");
        product new_product1 = new product(100, 10, "test_type2", "test_title", "test_company2", "test_assemble_place",  "test_characteristics");
        product new_product2 = new product(100, 10, "test_type3", "test_title", "test_company3", "test_assemble_place",  "test_characteristics");
        product new_product3 = new product(100, 10, "test_type4", "test_title", "test_company4", "test_assemble_place",  "test_characteristics");
        product new_product4 = new product(100, 10, "test_type5", "test_title", "test_company5", "test_assemble_place",  "test_characteristics");
        List<product> expected_list= List.of(
                new product(100, 10, "test_type1", "test_title", "test_company1", "test_assemble_place",  "test_characteristics"),
                 new product(100, 10, "test_type2", "test_title", "test_company2", "test_assemble_place",  "test_characteristics"),
                 new product(100, 10, "test_type3", "test_title", "test_company3", "test_assemble_place",  "test_characteristics"),
                 new product(100, 10, "test_type4", "test_title", "test_company4", "test_assemble_place",  "test_characteristics"),
                 new product(100, 10, "test_type5", "test_title", "test_company5", "test_assemble_place",  "test_characteristics")
        );
        _product_service.create_product(new_product);
        _product_service.create_product(new_product1);
        _product_service.create_product(new_product2);
        _product_service.create_product(new_product3);
        _product_service.create_product(new_product4);

        List<product> list_of_products = _product_service.read_product_list_by_title("test_title");

        Assert.assertEquals(list_of_products.size(), expected_list.size());
        Assert.assertTrue(expected_list.contains(list_of_products.get(0)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(1)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(2)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(3)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(4)));

        _product_service.delete_product(new_product);
        _product_service.delete_product(new_product1);
        _product_service.delete_product(new_product2);
        _product_service.delete_product(new_product3);
        _product_service.delete_product(new_product4);
    }

    @Test
    public void test_read_product_list_by_type() {
        product new_product = new product(100, 10, "test_type", "test_title1", "test_company1", "test_assemble_place",  "test_characteristics");
        product new_product1 = new product(100, 10, "test_type", "test_title2", "test_company2", "test_assemble_place",  "test_characteristics");
        product new_product2 = new product(100, 10, "test_type", "test_title3", "test_company3", "test_assemble_place",  "test_characteristics");
        product new_product3 = new product(100, 10, "test_type", "test_title4", "test_company4", "test_assemble_place",  "test_characteristics");
        product new_product4 = new product(100, 10, "test_type", "test_title5", "test_company5", "test_assemble_place",  "test_characteristics");
        List<product> expected_list = List.of(
                new product(100, 10, "test_type", "test_title1", "test_company1", "test_assemble_place",  "test_characteristics"),
                 new product(100, 10, "test_type", "test_title2", "test_company2", "test_assemble_place",  "test_characteristics"),
                 new product(100, 10, "test_type", "test_title3", "test_company3", "test_assemble_place",  "test_characteristics"),
                new product(100, 10, "test_type", "test_title4", "test_company4", "test_assemble_place",  "test_characteristics"),
                new product(100, 10, "test_type", "test_title5", "test_company5", "test_assemble_place",  "test_characteristics")
        );
        _product_service.create_product(new_product);
        _product_service.create_product(new_product1);
        _product_service.create_product(new_product2);
        _product_service.create_product(new_product3);
        _product_service.create_product(new_product4);
        List<product> list_of_products = _product_service.read_product_list_by_type("test_type");
        Assert.assertEquals(list_of_products.size(), expected_list.size());
        Assert.assertTrue(expected_list.contains(list_of_products.get(0)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(1)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(2)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(3)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(4)));

        _product_service.delete_product(new_product);
        _product_service.delete_product(new_product1);
        _product_service.delete_product(new_product2);
        _product_service.delete_product(new_product3);
        _product_service.delete_product(new_product4);
    }

    @Test
    public void test_read_product_list_by_company() {
        product new_product = new product(100, 10, "test_type1", "test_title1", "test_company", "test_assemble_place",  "test_characteristics");
        product new_product1 = new product(100, 10, "test_type2", "test_title2", "test_company", "test_assemble_place",  "test_characteristics");
        product new_product2 = new product(100, 10, "test_type3", "test_title3", "test_company", "test_assemble_place",  "test_characteristics");
        product new_product3 = new product(100, 10, "test_type4", "test_title4", "test_company", "test_assemble_place",  "test_characteristics");
        product new_product4 = new product(100, 10, "test_type5", "test_title5", "test_company", "test_assemble_place",  "test_characteristics");
        List<product> expected_list = List.of(
                new product(100, 10, "test_type1", "test_title1", "test_company", "test_assemble_place",  "test_characteristics"),
                new product(100, 10, "test_type2", "test_title2", "test_company", "test_assemble_place",  "test_characteristics"),
                new product(100, 10, "test_type3", "test_title3", "test_company", "test_assemble_place",  "test_characteristics"),
                new product(100, 10, "test_type4", "test_title4", "test_company", "test_assemble_place",  "test_characteristics"),
                new product(100, 10, "test_type5", "test_title5", "test_company", "test_assemble_place",  "test_characteristics")
        );
        _product_service.create_product(new_product);
        _product_service.create_product(new_product1);
        _product_service.create_product(new_product2);
        _product_service.create_product(new_product3);
        _product_service.create_product(new_product4);
        List<product> list_of_products = _product_service.read_product_list_by_company("test_company");
        Assert.assertEquals(list_of_products.size(), expected_list.size());
        Assert.assertTrue(expected_list.contains(list_of_products.get(0)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(1)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(2)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(3)));
        Assert.assertTrue(expected_list.contains(list_of_products.get(4)));

        _product_service.delete_product(new_product);
        _product_service.delete_product(new_product1);
        _product_service.delete_product(new_product2);
        _product_service.delete_product(new_product3);
        _product_service.delete_product(new_product4);
    }

    @Test
    public void test_read_order_by_id() {
        customer new_customer = new customer("customer_TestCreate", "psswd", "test_last_name", "test_first_name", "test_address", "test_phone_number", "test_mail");
        _customer_service.create_customer(new_customer);
        product new_product = new product(100, 10, "test_type", "test_title", "test_company", "test_assemble_place",  "test_characteristics");
        _product_service.create_product(new_product);


        orders new_order = new orders(new_customer,  new_product, "test_address", java.sql.Date.valueOf("2021-01-01"), java.sql.Date.valueOf("2021-01-01"), "String status", 100);

        _order_service.create_order(new_order);
        orders check_order = _order_service.read_order_by_id(new_order.get_id());
        Assert.assertEquals(new_order.get_id(), check_order.get_id());
        _order_service.delete_order(new_order);
        _customer_service.delete_customer(new_customer);
        _product_service.delete_product(new_product);
    }
}

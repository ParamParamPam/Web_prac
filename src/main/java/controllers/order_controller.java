package controllers;

import models.admin;
import models.product;
import models.customer;
import models.orders;
import services.admin_service;
import services.product_service;
import services.customer_service;
import services.order_service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Controller
public class order_controller {
    product_service _product_service = new product_service();
    customer_service _customer_service = new customer_service();
    order_service _order_service = new order_service();
    admin_service _admin_service = new admin_service();

    @GetMapping("/product_buy")
    public String product_buy_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                              @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                              @RequestParam(name = "product_id", required = true) int product_id, Model model) {

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                model.addAttribute("product", _product);
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                model.addAttribute("customer", _customer);
                return "product_check_order";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                model.addAttribute("product", _product);
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                model.addAttribute("customer", _customer);
                return "product_check_order";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @GetMapping("/product_buy_edit")
    public String product_buy_edit_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                  @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                  @RequestParam(name = "product_id", required = true) int product_id, Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                model.addAttribute("product", _product);
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                model.addAttribute("customer", _customer);
                return "product_edit_check_order";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                model.addAttribute("product", _product);
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                model.addAttribute("customer", _customer);
                return "product_edit_check_order";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @PostMapping("/save_product_edit_order")
    public String save_product_edit_order_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                        @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                        //@RequestParam(name = "first_name") String first_name,
                                        //@RequestParam(name = "last_name") String last_name,
                                        @RequestParam(name = "address") String address,
                                        @RequestParam(name = "phone_number") String phone_number,
                                        @RequestParam(name = "mail") String mail,
                                        @RequestParam(name = "product_id", required = true) int product_id, Model model) {
        System.out.println(cookie_username);
        System.out.println(cookie_password);
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                model.addAttribute("product", _product);
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                //_customer.set_first_name(first_name);
                //_customer.set_last_name(last_name);
                _customer.set_address(address);
                _customer.set_phone_number(phone_number);
                _customer.set_mail(mail);

                model.addAttribute("customer", _customer);

                return "product_check_order";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        System.out.println(exist_customer.get_login());
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                model.addAttribute("product", _product);
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                //_customer.set_first_name(first_name);
                //_customer.set_last_name(last_name);
                _customer.set_address(address);
                _customer.set_phone_number(phone_number);
                _customer.set_mail(mail);

                model.addAttribute("customer", _customer);
                return "product_check_order";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";


    }

    @PostMapping("/product_making_order")
    public String save_product_making_order_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                          @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                          //@RequestParam(name = "customer_changed_firstName") String first_name,
                                          //@RequestParam(name = "customer_changed_lastName") String last_name,
                                          @RequestParam(name = "customer_changed_address") String address,
                                          @RequestParam(name = "customer_changed_phoneNumber") String phone_number,
                                          @RequestParam(name = "customer_changed_mail") String mail,
                                          @RequestParam(name = "product_id", required = true) int product_id, Model model) throws ParseException {

        order_service _order_service1 = new order_service();

        product _product = _product_service.read_product_by_id(product_id);
        if (_product.get_amount() == 0) {
            model.addAttribute("error", "Product is out of stock");
            return "error_show";
        }
        _product.set_amount(_product.get_amount() - 1);
        _product_service.update_product(_product);
        //model.addAttribute("product", product);

        LocalDate current_date = LocalDate.now();
        String c_date = current_date.toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Calendar _calendar = Calendar.getInstance();
        _calendar.setTime(sdf.parse(c_date));
        _calendar.add(Calendar.DATE, 7);  // number of days to add
        c_date = sdf.format(_calendar.getTime());  // c_date is now the new date

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                //_customer.set_first_name(first_name);
                //_customer.set_last_name(last_name);
                _customer.set_address(address);
                _customer.set_phone_number(phone_number);
                _customer.set_mail(mail);

                orders new_order = new orders(_customer, _product, address,
                        java.sql.Date.valueOf(c_date), java.sql.Date.valueOf(current_date), "Formed", _product.get_price());

                _order_service1.create_order(new_order);
                model.addAttribute("time", c_date);
                return "success_order";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                customer _customer = _customer_service.read_customer_by_login(cookie_username);
                //_customer.set_first_name(first_name);
                //_customer.set_last_name(last_name);
                _customer.set_address(address);
                _customer.set_phone_number(phone_number);
                _customer.set_mail(mail);

                orders new_order = new orders(_customer, _product, address,
                        java.sql.Date.valueOf(c_date), java.sql.Date.valueOf(current_date), "Formed", _product.get_price());

                _order_service1.create_order(new_order);
                model.addAttribute("time", c_date);
                return "order_success";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @GetMapping("/logged/orders")
    public String orders_customer_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                    @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                    @RequestParam(name = "customer_id", required = true) int customer_id, Model model) {

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                customer _customer = _customer_service.read_customer_by_id(customer_id);
                List<orders> orders = _order_service.read_order_by_customer_id(_customer);
                model.addAttribute("orders", orders);
                return "customer_orders";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                customer _customer = _customer_service.read_customer_by_id(customer_id);
                List<orders> orders = _order_service.read_order_by_customer_id(_customer);
                model.addAttribute("orders", orders);
                return "customer_orders";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";


    }

    @GetMapping("/orders")
    public String orders_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                             @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                             Model model) {

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                List<orders> orders = _order_service.read_orders();
                model.addAttribute("orders", orders);/**/
                return "orders";
            }
        }

        model.addAttribute("error", "Permission denied");
        return "error_show";


    }

    @GetMapping("/order_edit")
    public String customer_edit_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                   @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                   @RequestParam(name = "order_id", required = true) int order_id, Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                orders _order = _order_service.read_order_by_id(order_id);
                model.addAttribute("order", _order);
                return "order_edit";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @PostMapping("/save_edit_order")
    public String save_customer_edit_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                       @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                       @RequestParam(name = "address") String address,
                                       @RequestParam(name = "delivery_date") java.sql.Date delivery_date,
                                       @RequestParam(name = "status") String status,
                                       @RequestParam(name = "order_id", required = true) int order_id, Model model) {

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                orders _order = _order_service.read_order_by_id(order_id);
                _order.set_address(address);
                _order.set_delivery_date(delivery_date);
                _order.set_status(status);

                _order_service.update_order(_order);

                orders check_order = _order_service.read_order_by_id(_order.get_id());
                if (check_order == null) {
                    model.addAttribute("error", "Order update error");
                    return "error_show";
                }
                List<orders> orders = _order_service.read_orders();
                model.addAttribute("orders", orders);
                return "orders";
            }
        }

        model.addAttribute("error", "Permission denied");
        return "error_show";


    }

}

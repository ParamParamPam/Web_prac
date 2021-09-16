package controllers;

import models.admin;
import models.customer;
import models.orders;
import models.product;
import services.admin_service;
import services.customer_service;
import services.order_service;
import services.product_service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class customer_controller {

    customer_service _customer_service = new customer_service();
    admin_service _admin_service = new admin_service();
    product_service _product_service = new product_service();

    @GetMapping("/logged/personal")
    public String customer_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                               @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                               @RequestParam(name = "customer_id", required = true) int customer_id, Model model) {

        customer _customer = _customer_service.read_customer_by_id(customer_id);
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);

        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                model.addAttribute("customer", _customer);
                return "customer_admin";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                model.addAttribute("customer", _customer);
                return "customer";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @GetMapping("/customer_edit")
    public String customer_edit_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                   @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                   @RequestParam(name = "customer_id", required = true) int customer_id, Model model) {
        customer _customer = _customer_service.read_customer_by_id(customer_id);
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);

        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                model.addAttribute("customer", _customer);
                return "customer_edit";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                model.addAttribute("customer", _customer);
                return "customer_edit";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @GetMapping("/customer_delete")
    public String customer_delete_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                     @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                     @RequestParam(name = "customer_id", required = true) int customer_id, Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);

        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                customer _customer = _customer_service.read_customer_by_id(customer_id);
                if (_customer != null) {
                    _customer_service.delete_customer(_customer);
                }
                List<customer> customers = _customer_service.read_customers();
                model.addAttribute("customers", customers);
                return "customers";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @PostMapping("/save_edit_customer")
    public String save_customer_edit_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                       @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                       @RequestParam(name = "password") String password,
                                       @RequestParam(name = "first_name") String first_name,
                                       @RequestParam(name = "last_name") String last_name,
                                       @RequestParam(name = "address") String address,
                                       @RequestParam(name = "phone_number") String phone_number,
                                       @RequestParam(name = "mail") String mail,
                                       @RequestParam(name = "customer_id", required = true) int customer_id, Model model) {

        customer _customer = _customer_service.read_customer_by_id(customer_id);
        _customer.set_psswd(password);
        _customer.set_first_name(first_name);
        _customer.set_last_name(last_name);
        _customer.set_address(address);
        _customer.set_phone_number(phone_number);
        _customer.set_mail(mail);

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                _customer_service.update_customer(_customer);
                customer check_customer = _customer_service.read_customer_by_id(_customer.get_id());
                if (check_customer == null) {
                    model.addAttribute("error", "Customer update error");
                    return "error_show";
                }
                model.addAttribute("customer", _customer);
                return "customer_admin";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                _customer_service.update_customer(_customer);
                customer check_customer = _customer_service.read_customer_by_id(_customer.get_id());
                if (check_customer == null) {
                    model.addAttribute("error", "Customer update error");
                    return "error_show";
                }
                model.addAttribute("customer", _customer);
                return "customer";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";


    }

    @GetMapping("/customers")
    public String customers_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                             @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                             Model model) {

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                List<customer> customers = _customer_service.read_customers();
                model.addAttribute("customers", customers);
                return "customers";
            }
        }

        model.addAttribute("error", "Permission denied");
        return "error_show";

    }

    @GetMapping("/add_customer")
    public String add_customer_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                              @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                              Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                return "customer_add";
            }
        }

        model.addAttribute("error", "Permission denied");
        return "error_show";

    }

    @PostMapping("/customer_creation")
    public String check_registration_data (@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                         @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                         @RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password,
                                         @RequestParam(name = "first_name") String first_name,
                                         @RequestParam(name = "last_name") String last_name,
                                         @RequestParam(name = "address") String address,
                                         @RequestParam(name = "phone_number") String phone_number,
                                         @RequestParam(name = "mail") String mail,
                                         Model model) {
        customer new_customer;
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);

        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                customer exist_customer = _customer_service.read_customer_by_login(username);
                if (exist_customer != null) {
                    model.addAttribute("error", "This username is already taken! :(");
                    return "error_show";
                }

                try {
                    new_customer = new customer(username, password,
                            last_name, first_name, address, phone_number, mail);
                    _customer_service.create_customer(new_customer);

                } catch (Exception e) {
                    model.addAttribute("error", e.getMessage());
                    return "error_show";
                }

                customer check_customer = _customer_service.read_customer_by_id(new_customer.get_id());
                if (check_customer == null) {
                    model.addAttribute("error", "Account creation error");
                    return "error_show";
                }
                List<product> products = _product_service.read_all_products();
                model.addAttribute("product", products);
                return "index_admin";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

}

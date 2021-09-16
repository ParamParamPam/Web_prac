package controllers;

import models.admin;
import models.product;
import models.customer;
import services.admin_service;
import services.product_service;
import services.customer_service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class product_controller {

    product_service _product_service = new product_service();
    admin_service _admin_service = new admin_service();
    customer_service _customer_service = new customer_service();

    @GetMapping("/product")
    public String product_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                           @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                           @RequestParam(name = "product_id", required = true) int product_id, Model model) {
        product _product = _product_service.read_product_by_id(product_id);
        model.addAttribute("product", _product);

        if (_product == null) {
            model.addAttribute("error", "This product is no longer for sale");
            return "error_show";
        }

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                return "product_admin";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                return "product_customer";
            }
        }
        return "product";
    }

    @GetMapping("/product_edit")
    public String product_edit_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                               @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                               @RequestParam(name = "product_id", required = true) int product_id, Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                model.addAttribute("product", _product);
                return "product_edit";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";

    }

    @PostMapping("/save_edit_product")
    public String save_product_edit_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                   @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                   @RequestParam(name = "title") String title,
                                   @RequestParam(name = "company") String company,
                                   @RequestParam(name = "type") String type,
                                   @RequestParam(name = "assemble_place") String assemble_place,
                                   @RequestParam(name = "characteristics") String characteristics,
                                   @RequestParam(name = "price") double price,
                                   @RequestParam(name = "amount") int amount,
                                   @RequestParam(name = "product_id", required = true) int product_id, Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);

                _product.set_title(title);
                _product.set_company(company);
                _product.set_type(type);
                _product.set_assemble_place(assemble_place);
                _product.set_characteristics(characteristics);
                _product.set_price(price);
                _product.set_amount(amount);

                _product_service.update_product(_product);

                product check_product = _product_service.read_product_by_id(_product.get_id());
                if(check_product == null) {
                    model.addAttribute("error", "Product update error");
                    return "error_show";
                }
                model.addAttribute("product", _product);
                return "product_admin";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @GetMapping("/delete_product")
    public String product_delete_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                 @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                 @RequestParam(name = "product_id", required = true) int product_id, Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                product _product = _product_service.read_product_by_id(product_id);
                _product_service.delete_product(_product);
                List<product> products = _product_service.read_all_products();
                model.addAttribute("products", products);
                return "index_admin";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @GetMapping("/add_product")
    public String add_product_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                              @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password, Model model) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                return "product_add";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";

    }

    @PostMapping("/product_creation")
    public String check_registration_data (@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                         @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                         @RequestParam(name = "title") String title,
                                         @RequestParam(name = "company") String company,
                                         @RequestParam(name = "type") String type,
                                         @RequestParam(name = "assemble_place") String assemble_place,
                                         @RequestParam(name = "characteristics") String characteristics,
                                         @RequestParam(name = "price") double price,
                                         @RequestParam(name = "amount") int amount,
                                         Model model) {

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                product _product = new product(price, amount, type, title, company,
                        assemble_place, characteristics);
                _product_service.create_product(_product);
                List<product> products = _product_service.read_all_products();
                model.addAttribute("products", products);
                return "index_admin";
            }
        }
        model.addAttribute("error", "Permission denied");
        return "error_show";


    }
}

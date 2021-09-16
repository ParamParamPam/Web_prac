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

import javax.servlet.http.Cookie;
import java.util.List;

@Controller
public class main_page_controller {
    customer_service _customer_service = new customer_service();
    product_service _product_service = new product_service();
    admin_service _admin_service = new admin_service();

    @GetMapping("/")
    public String home(Model model, @CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                        @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password) {
        List<product> _products = _product_service.read_all_products();
        model.addAttribute("products", _products);

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                return "redirect:/logged";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                return "redirect:/logged";
            }
        }
        System.out.println(cookie_username);
        System.out.println(cookie_password);
        return "index";
    }

    @PostMapping("/filter")
    public String product_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                           @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                           @RequestParam(name = "title") String title,
                           @RequestParam(name = "company") String company,
                           @RequestParam(name = "type") String type,
                           Model model) {

        List<product> titles = _product_service.read_all_products();
        List<product> companies = _product_service.read_all_products();
        List<product> types = _product_service.read_all_products();

        if (title != "") {
            titles = _product_service.read_product_list_by_title(title);
        }

        if (company != "") {
            companies = _product_service.read_product_list_by_company(company);
        }

        if (type != "") {
            types = _product_service.read_product_list_by_type(type);
        }

        titles.retainAll(companies);
        titles.retainAll(types);

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                model.addAttribute("products", titles);
                return "index_admin";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                model.addAttribute("products", titles);
                model.addAttribute("customer_id", exist_customer.get_id());
                return "index_customer";
            }
        }

        model.addAttribute("products", titles);
        return "index";
    }
}

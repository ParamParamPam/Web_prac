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
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class access_controller {
    customer_service _customer_service = new customer_service();
    admin_service _admin_service = new admin_service();
    product_service _product_service = new product_service();

    @GetMapping("/logged")
    public String hello(Model model, @CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                        @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password) {
        List<product> products = _product_service.read_all_products();
        model.addAttribute("products", products);

        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            if (exist_admin.get_psswd().equals(cookie_password)) {
                return "index_admin";
            }
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                model.addAttribute("customer_id", exist_customer.get_id());
                return "index_customer";
            }
        }

        model.addAttribute("error", "Permission denied");
        return "error_show";
    }

    @GetMapping("/log_in")
    public String registration_page(Model model, @CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username) {
        admin exist_admin = _admin_service.read_admin_by_login(cookie_username);
        if (exist_admin != null) {
            model.addAttribute("error", "Permission denied");
            return "error_show";
        }

        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            model.addAttribute("error", "Permission denied");
            return "error_show";
        }
        return "log_in";
    }

    @GetMapping("/log_out")
    public String log_out(HttpServletResponse response) {
        Cookie cookie_username = new Cookie("login", "DefaultValueForCookieUsername");
        Cookie cookie_password = new Cookie("password", "DefaultValueForCookiePassword");
        response.addCookie(cookie_username);
        response.addCookie(cookie_password);
        return "redirect:/";
    }

    @PostMapping("/identification")
    public String check_registration_data (HttpServletResponse response,
                                         @RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password,
                                         Model model) {

        customer exist_customer = _customer_service.read_customer_by_login(username);
        admin exist_admin = _admin_service.read_admin_by_login(username);

        if (exist_customer != null) {
            if (!exist_customer.get_psswd().equals(password)) {
                model.addAttribute("error", "Username or password is incorrect.");
                return "error_show";
            } else {
                List<product> products = _product_service.read_all_products();
                model.addAttribute("products", products);

                Cookie cookie_username = new Cookie("login", username);
                Cookie cookie_password = new Cookie("password", password);
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);

                model.addAttribute("customer_id", exist_customer.get_id());
                return "index_customer";
            }
        }


        if (exist_admin != null) {
            if (!exist_admin.get_psswd().equals(password)) {
                model.addAttribute("error", "Username or password is incorrect.");
                return "error_show";
            } else {
                List<product> products = _product_service.read_all_products();
                model.addAttribute("products", products);

                Cookie cookie_username = new Cookie("login", username);
                Cookie cookie_password = new Cookie("password", password);
                response.addCookie(cookie_username);
                response.addCookie(cookie_password);

                model.addAttribute("admin_id", exist_admin.get_id());
                return "index_admin";
            }
        }

        model.addAttribute("error", "Username or password is incorrect.");
        return "error_show";
    }

    @GetMapping("/registration")
    public String registration_page(@CookieValue(value = "login", defaultValue = "DefaultValueForCookieUsername") String cookie_username,
                                   @CookieValue(value = "password", defaultValue = "DefaultValueForCookiePassword") String cookie_password,
                                   Model model) {
        customer exist_customer = _customer_service.read_customer_by_login(cookie_username);
        if (exist_customer != null) {
            if (exist_customer.get_psswd().equals(cookie_password)) {
                return "redirect:/logged";
            }
        }
        return "registration";
    }

    @PostMapping("/registered")
    public String check_registration_data (@RequestParam(name = "username") String username,
                                         @RequestParam(name = "password") String password,
                                         @RequestParam(name = "first_name") String first_name,
                                         @RequestParam(name = "last_name") String last_name,
                                         @RequestParam(name = "address") String address,
                                         @RequestParam(name = "phone_number") String phone_number,
                                         @RequestParam(name = "mail") String mail,
                                         Model model) {
        customer new_customer;
        System.out.println(username);
        System.out.println(password);
        System.out.println(first_name);
        System.out.println(last_name);

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
        if (check_customer.equals(new_customer)) {
            return "registration_success";
        }
        model.addAttribute("error", "Account creation error");
        return "error_show";
    }

}

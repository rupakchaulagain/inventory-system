package com.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author rupak ON 2020/07/15-10:27 AM
 */
@Controller
public class DashboardController {

    @GetMapping("/login")
    public String login(Model model){

        System.out.println("login page is called.....");

        return "login";
    }

    @GetMapping("/")
    public String index(Model model){

        System.out.println("index page is called.....");

        return "index";
    }

    @GetMapping("/product-category")
    public String productCategory(Model model){

        System.out.println("product-category page is called.....");

        return "product-category";
    }

    @GetMapping("/product-type")
    public String productType(Model model){

        System.out.println("product-type page is called.....");

        return "product-type";
    }

    @GetMapping("/product")
    public String product(Model model){

        System.out.println("product page is called.....");

        return "product";
    }

    @GetMapping("/supplier")
    public String supplier(Model model){

        System.out.println("supplier page is called.....");

        return "supplier";
    }

    @GetMapping("/test")
    public String test(Model model){

        System.out.println("test page is called.....");

        return "test";
    }

}

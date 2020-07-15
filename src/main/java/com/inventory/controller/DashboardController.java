package com.inventory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author rupak ON 2020/07/15-10:27 AM
 */
@Controller
public class DashboardController {

    @GetMapping("/")
    public String index(Model model){

        System.out.println("index page is called.....");

        return "index";



    }

}

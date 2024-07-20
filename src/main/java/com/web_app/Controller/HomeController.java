package com.web_app.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/First")
public class HomeController {
    @RequestMapping("/Home")

    public String greet(){
        return "Welcome to MSI";

    }
    @RequestMapping("/about")
    public String about(){
        return "This is the MSI Laptop";
    }

}

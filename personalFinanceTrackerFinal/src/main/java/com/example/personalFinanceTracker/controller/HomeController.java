package com.example.personalFinanceTracker.controller;

//public class HomeController {
//}
//package com.example.personalFinanceTracker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String showHomePage() {
        // This will return the home.html file from the templates directory
        return "home";
    }
}


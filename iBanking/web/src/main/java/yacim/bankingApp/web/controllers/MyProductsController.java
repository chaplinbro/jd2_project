package yacim.bankingApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyProductsController {

    @GetMapping("/myProducts")
    public String myProducts() {
        return "myProducts";
    }
}

package yacim.bankingApp.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/start")
    public String start(){
        return "start";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @GetMapping("/enter")
    public String enter() {
        return "enter";
    }

}
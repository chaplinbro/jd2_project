package yacim.bankingApp.web.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping({ "/", "/start"})
    public String start(){
        return "start";
    }

    @GetMapping("/news")
    public String news() {
        return "news";
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    @GetMapping("/enter")
    public String enter(Authentication authentication, Model model) {

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String getUsernameFromSecurity = userDetails.getUsername();
            model.addAttribute("username", getUsernameFromSecurity);
        }
        return "enter";
    }
}
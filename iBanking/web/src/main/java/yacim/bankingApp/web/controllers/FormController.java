package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yacim.bankingApp.data.model.RegistrationDto;
import yacim.bankingApp.service.UserService;

@Controller
public class FormController {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String registration() {
        return "form";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute("registrationDto") RegistrationDto registrationDto){
        userService.registration(registrationDto);
        return "redirect:/start";
    }

}

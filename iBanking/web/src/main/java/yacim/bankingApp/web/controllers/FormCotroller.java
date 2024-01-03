package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yacim.bankingApp.data.dao.UserDao;
import yacim.bankingApp.data.entity.User;

@Controller
public class FormCotroller {

    @Autowired
    UserDao userDao;

    @GetMapping("/form")
    public String registration(Model model) {
        model.addAttribute("use r", new User());
        return "form";
    }

    @PostMapping("/saveUser")
    public String saveNewUser(@ModelAttribute User user){
        userDao.saveUser(user);
        return "redirect:/enter";
    }

}

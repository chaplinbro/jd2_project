package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yacim.bankingApp.data.dao.UserDao;
import yacim.bankingApp.data.entity.User;

@Controller
public class AdminController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/delete")
    public String deleteUser(){
        return "delete";
    }

    @PostMapping("/delete")
    public void deleteUser(@RequestParam("id") String id){
        userDao.delete(User.class, id);
    }
}

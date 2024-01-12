package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yacim.bankingApp.data.dao.UserDao;
import yacim.bankingApp.data.entity.User;
import yacim.bankingApp.data.model.BankAccountDto;
import yacim.bankingApp.service.BankAccountService;

@Controller
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    @Autowired
    private UserDao userDao;

    @GetMapping("/createNewBankAccount")
    public String addCardAccountUrl() {
        return "createNewBankAccount";
    }

    @PostMapping("/createNewBankAccount")
    public String addCardAccount(Authentication authentication,
                                 @ModelAttribute("bankAccountDto") BankAccountDto bankAccountDto) {

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User user = (User) userDao.getByUsername(username);
            if (user != null) {
                String userId = user.getId();
                bankAccountService.createBankAccount(bankAccountDto, userId);
            }
        }
        return "redirect:/enter";
    }
}

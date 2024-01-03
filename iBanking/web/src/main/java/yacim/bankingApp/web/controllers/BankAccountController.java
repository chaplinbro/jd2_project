package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yacim.bankingApp.data.model.BankAccountDto;
import yacim.bankingApp.service.BankAccountService;

@Controller
public class BankAccountController {

    @Autowired
    BankAccountService bankAccountService;

    @GetMapping("/createNewBankAccount")
    public String addCardAccountUrl(Model model) {
        model.addAttribute("bankAccountDto", new BankAccountDto());
        return "createNewBankAccount";
    }

    @PostMapping("/createNewBankAccount")
    public String addCardAccount(@ModelAttribute("bankAccountDto") BankAccountDto bankAccountDto) {
        bankAccountService.createBankAccount(bankAccountDto);
        return "redirect:/enter";
    }
}

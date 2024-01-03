package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yacim.bankingApp.data.model.AccountTransactionDto;
import yacim.bankingApp.service.AccountTransactionService;

@Controller
public class AccountTransactionController {

    @Autowired
    private AccountTransactionService accountTransactionService;

    @GetMapping("/deposit")
    public String replenishmentController(Model model) {
        model.addAttribute("accountTransaction", new AccountTransactionDto());
        return "deposit";
    }

    @PostMapping("/replenishmentProcess")
    public String replenishmentProcess(@ModelAttribute("accountTransaction") AccountTransactionDto accountTransactionDto) {
        accountTransactionService.doTransactionForReplenish(accountTransactionDto);
        return "redirect:/enter";
    }

    @GetMapping("/credit")
    public String creditController(Model model) {
        model.addAttribute("accountTransaction", new AccountTransactionDto());
        return "credit";
    }

    @PostMapping("/creditProcess")
    public String creditProcess (@ModelAttribute("accountTransaction") AccountTransactionDto accountTransactionDto){
        accountTransactionService.doTransactionForCredit(accountTransactionDto);
        return "redirect:/enter";
    }
}

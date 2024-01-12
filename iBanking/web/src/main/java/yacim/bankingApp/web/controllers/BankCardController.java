package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yacim.bankingApp.data.model.BankCardDto;
import yacim.bankingApp.service.BankCardService;

@Controller
public class BankCardController {

    @Autowired
    private BankCardService bankCardService;

    @GetMapping("/createNewCard")
    public String addBankCardUrl() {
        return "createNewCard";
    }

    @PostMapping("/createNewCard")
    public String addBankCard(@ModelAttribute("bankCardDto") BankCardDto bankCardDto,
                              @RequestParam("accountNumber") String accountNumber) {
        bankCardService.createBankCard(bankCardDto, accountNumber);
        return "redirect:/enter";
    }
}

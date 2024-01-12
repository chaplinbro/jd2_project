package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import yacim.bankingApp.data.model.TransferTransactionDto;
import yacim.bankingApp.service.AccountTransactionService;

@Controller
public class TransferTransactionController {

    @Autowired
    private AccountTransactionService accountTransactionService;

    @GetMapping("/transfer")
    public String transferController() {
        return "/transfer";
    }

    @PostMapping("/transferProcess")
    public String transferProcess(@ModelAttribute("transferTransaction") TransferTransactionDto transferTransactionDto) {
        accountTransactionService.doTransferTransaction(transferTransactionDto);
        return "redirect:/enter";
    }
}

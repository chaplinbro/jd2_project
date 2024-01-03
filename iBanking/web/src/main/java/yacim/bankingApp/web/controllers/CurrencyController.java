package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import yacim.bankingApp.data.dao.CurrencyDao;
import yacim.bankingApp.data.entity.Currency;

import java.util.List;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyDao currencyDao;

    @GetMapping("/currency")
    public String currencyExchangeRate(Model model){
        List<Currency> currencies = currencyDao.getAllCurrency();
        model.addAttribute("currenciesList", currencies);
        return "currency";
    }
}

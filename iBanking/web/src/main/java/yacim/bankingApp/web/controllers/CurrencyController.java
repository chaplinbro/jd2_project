package yacim.bankingApp.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import yacim.bankingApp.data.dao.CurrencyDao;
import yacim.bankingApp.data.entity.Currency;

import java.util.List;

@Controller
public class CurrencyController {

    @Autowired
    CurrencyDao currencyDao;

    @GetMapping("/currency")
    public String currencyExchangeRate(Model model,
                                       @RequestParam(value = "page", defaultValue = "0") Integer page,
                                       @RequestParam(value = "size", defaultValue = "10") Integer size) {

        int startIndex = page * size;
        List<Currency> currencies = currencyDao.getAllForPagination(startIndex, size);
        int total = currencyDao.getTotalCurrencyCount();

        model.addAttribute("currenciesList", currencies);
        model.addAttribute("totalPages", Math.ceil((double) total / size));
        return "currency";
    }
}

package yacim.bankingApp.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import yacim.bankingApp.data.dao.BankAccountDao;
import yacim.bankingApp.data.dao.BankCardDao;
import yacim.bankingApp.data.dao.UserDao;
import yacim.bankingApp.data.entity.BankAccount;
import yacim.bankingApp.data.entity.BankCard;
import yacim.bankingApp.data.entity.User;
import yacim.bankingApp.data.model.MyProductsBankAccountDto;
import yacim.bankingApp.data.model.MyProductsBankCardDto;
import yacim.bankingApp.data.model.MyProductsUserDto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyProductsRestController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BankAccountDao bankAccountDao;

    @Autowired
    private BankCardDao bankCardDao;

    @GetMapping("/myProducts")
    public ResponseEntity<MyProductsUserDto> myProducts(Authentication authentication) {

        MyProductsUserDto myProducts = new MyProductsUserDto();

        if (authentication != null) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            User user = userDao.getByUsername(username);

            myProducts.setUsername(user.getUsername());
            myProducts.setName(user.getName());
            myProducts.setSurname(user.getSurname());

            List<BankAccount> bankAccounts = bankAccountDao.getBankAccountsByUserId(user.getId());
            List<MyProductsBankAccountDto> myBankAccount = new ArrayList<>();

            for (BankAccount bankAccount : bankAccounts) {
                MyProductsBankAccountDto myBankAccountDto = new MyProductsBankAccountDto();
                myBankAccountDto.setAccountNumber(bankAccount.getAccountNumber());
                myBankAccountDto.setAccountBalance(bankAccount.getAccountBalance());
                myBankAccountDto.setAccountCurrency(bankAccount.getAccountCurrency());

                List<BankCard> bankCards = bankCardDao.getBankCardsByBankAccountId(bankAccount.getId());
                List<MyProductsBankCardDto> myBankCard = getMyProductsBankCardDtos(bankCards);
                myBankAccountDto.setBankCards(myBankCard);
                myBankAccount.add(myBankAccountDto);
            }
            myProducts.setBankAccount(myBankAccount);
        }
        return new ResponseEntity<>(myProducts, HttpStatus.OK);
    }

    private static List<MyProductsBankCardDto> getMyProductsBankCardDtos(List<BankCard> bankCards) {
        List<MyProductsBankCardDto> myBankCard = new ArrayList<>();

        if (bankCards != null) {
            for (BankCard bankCard : bankCards) {
                MyProductsBankCardDto myBankCardDto = new MyProductsBankCardDto();
                myBankCardDto.setCardNumber(bankCard.getCardNumber());
                myBankCardDto.setCardholderName(bankCard.getCardholderName());
                myBankCardDto.setCardBalance(bankCard.getCardBalance());
                myBankCardDto.setCardCurrency(bankCard.getCardCurrency());
                myBankCard.add(myBankCardDto);
            }
        }
        return myBankCard;
    }
}

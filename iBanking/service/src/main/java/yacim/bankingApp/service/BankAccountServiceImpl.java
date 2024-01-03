package yacim.bankingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yacim.bankingApp.data.dao.BankAccountDao;
import yacim.bankingApp.data.entity.BankAccount;
import yacim.bankingApp.data.model.BankAccountDto;

import java.util.Random;

@Service
public class BankAccountServiceImpl implements BankAccountService {

    @Autowired
    private BankAccountDao bankAccountDao;

    @Override
    public void createBankAccount(BankAccountDto bankAccountDto) {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setAccountNumber(randomAccountNumber());
        bankAccount.setAccountBalance(0.0);
        bankAccount.setAccountCurrency(bankAccountDto.getAccountCurrency());
        bankAccountDao.createBankAccount(bankAccount);
    }

    private String randomAccountNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <16; i++) {
            if (i>0 && i%2 == 0){
                random.nextInt(9);
            }
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

}
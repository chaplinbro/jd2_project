package yacim.bankingApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yacim.bankingApp.data.dao.BankCardDao;
import yacim.bankingApp.data.entity.BankCard;
import yacim.bankingApp.data.model.BankCardDto;

import java.util.Random;

@Service
public class BankCardServiceImpl implements BankCardService {

    @Autowired
    private BankCardDao bankCardDao;

    @Override
    public void createBankCard(BankCardDto bankCardDto) {
        BankCard bankCard = new BankCard();
        bankCard.setCardNumber(randomCardNumber());
        bankCard.setCardholderName(bankCardDto.getCardholderName());
        bankCard.setCard_balance(0.0);
        bankCard.setCvv(randomCvv());
        bankCard.setCardCurrency(bankCardDto.getCardCurrency());
        bankCardDao.createBankCard(bankCard);
    }

    private String randomCardNumber() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 16; i++) {
            if (i > 0 && i % 4 == 0) {
                sb.append(" ");
            }
            sb.append(random.nextInt(9));
        }
        return sb.toString();
    }

    private int randomCvv() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <3; i++) {
            sb.append(random.nextInt(10));
        }
        return Integer.parseInt(sb.toString());
    }

}

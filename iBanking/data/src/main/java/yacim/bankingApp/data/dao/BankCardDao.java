package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.entity.BankCard;

public interface BankCardDao {

    void createBankCard(BankCard bankCard);

    BankCard getBankCardById(String id);

    void updateBankCard(BankCard bankCard);

    boolean deleteBankCard(BankCard bankCard);

    BankCard getBankCardByCardNumber(String cardNumber);
}

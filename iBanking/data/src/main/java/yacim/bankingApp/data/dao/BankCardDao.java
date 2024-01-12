package yacim.bankingApp.data.dao;

import yacim.bankingApp.data.dao.common.BaseDao;
import yacim.bankingApp.data.entity.BankCard;

import java.util.List;

public interface BankCardDao extends BaseDao<BankCard> {

    List<BankCard> getAllCards();

    List<BankCard> getBankCardsByBankAccountId (String bankAccountId);
}

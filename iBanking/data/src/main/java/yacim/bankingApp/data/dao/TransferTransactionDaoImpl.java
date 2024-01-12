package yacim.bankingApp.data.dao;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import yacim.bankingApp.data.dao.common.BaseDaoImpl;
import yacim.bankingApp.data.entity.TransferTransaction;

@Repository
public class TransferTransactionDaoImpl extends BaseDaoImpl<TransferTransaction> implements TransferTransactionDao {
    public TransferTransactionDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}

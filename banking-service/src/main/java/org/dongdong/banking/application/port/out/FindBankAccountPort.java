package org.dongdong.banking.application.port.out;

import org.dongdong.banking.adapter.out.persistence.bankaccount.BankAccountJpaEntity;

public interface FindBankAccountPort {

  BankAccountJpaEntity findBankAccountById(Long id);
}

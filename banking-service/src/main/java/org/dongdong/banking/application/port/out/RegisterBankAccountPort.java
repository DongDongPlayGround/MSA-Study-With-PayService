package org.dongdong.banking.application.port.out;

import org.dongdong.banking.adapter.out.persistence.bankaccount.BankAccountJpaEntity;
import org.dongdong.banking.domain.BankAccount;

public interface RegisterBankAccountPort {

  BankAccountJpaEntity createBankAccount(
    BankAccount.MembershipId membershipId,
    BankAccount.BankName bankName,
    BankAccount.BankAccountNumber bankAccountNumber,
    BankAccount.LinkedStatusIsValid linkedStatusIsValid);
}

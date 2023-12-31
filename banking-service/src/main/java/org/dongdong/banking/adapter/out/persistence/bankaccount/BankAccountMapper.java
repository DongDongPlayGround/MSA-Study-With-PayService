package org.dongdong.banking.adapter.out.persistence.bankaccount;

import org.dongdong.banking.domain.BankAccount;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

  public BankAccount mapToDomainEntity(BankAccountJpaEntity bankAccountJpaEntity) {
    if (bankAccountJpaEntity == null) {
      return null;
    }
    return BankAccount.create(
      new BankAccount.BankAccountId(bankAccountJpaEntity.getBankAccountId()),
      new BankAccount.MembershipId(bankAccountJpaEntity.getMembershipId()),
      new BankAccount.BankName(bankAccountJpaEntity.getBankName()),
      new BankAccount.BankAccountNumber(bankAccountJpaEntity.getBankAccountNumber()),
      new BankAccount.LinkedStatusIsValid(bankAccountJpaEntity.getLinkedStatusIsValid())
    );
  }
}

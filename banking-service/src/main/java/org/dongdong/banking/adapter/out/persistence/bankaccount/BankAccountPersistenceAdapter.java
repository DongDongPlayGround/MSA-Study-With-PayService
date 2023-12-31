package org.dongdong.banking.adapter.out.persistence.bankaccount;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.application.port.out.FindBankAccountPort;
import org.dongdong.banking.application.port.out.RegisterBankAccountPort;
import org.dongdong.banking.domain.BankAccount;
import org.dongdong.common.PersistenceAdapter;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class BankAccountPersistenceAdapter implements RegisterBankAccountPort, FindBankAccountPort {

  private final SpringDataBankAccountRepository bankAccountRepository;

  @Override
  public BankAccountJpaEntity createBankAccount(
    BankAccount.MembershipId membershipId,
    BankAccount.BankName bankName,
    BankAccount.BankAccountNumber bankAccountNumber,
    BankAccount.LinkedStatusIsValid linkedStatusIsValid
  ) {
    return Optional.of(
      new BankAccountJpaEntity(
        membershipId.getMembershipId(),
        bankName.getBankName(),
        bankAccountNumber.getBankAccountNumber(),
        linkedStatusIsValid.getLinkedStatusIsValid()
      ))
      .map(bankAccountRepository::save)
      .get();
  }

  @Override
  public BankAccountJpaEntity findBankAccountById(Long id) {
    return bankAccountRepository.findById(id).orElse(null);
  }

}

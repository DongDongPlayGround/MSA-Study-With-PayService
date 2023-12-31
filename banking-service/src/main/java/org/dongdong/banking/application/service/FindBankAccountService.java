package org.dongdong.banking.application.service;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.adapter.out.persistence.bankaccount.BankAccountJpaEntity;
import org.dongdong.banking.adapter.out.persistence.bankaccount.BankAccountMapper;
import org.dongdong.banking.application.port.in.FindBankAccountUseCase;
import org.dongdong.banking.application.port.out.FindBankAccountPort;
import org.dongdong.banking.domain.BankAccount;
import org.dongdong.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class FindBankAccountService implements FindBankAccountUseCase {

  private final FindBankAccountPort findBankAccountPort;
  private final BankAccountMapper mapper;

  @Override
  public BankAccount getBankAccountById(Long id) {
    BankAccountJpaEntity bankAccountJpaEntity = findBankAccountPort.findBankAccountById(id);
    return mapper.mapToDomainEntity(bankAccountJpaEntity);
  }
}

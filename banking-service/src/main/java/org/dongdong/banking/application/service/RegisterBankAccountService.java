package org.dongdong.banking.application.service;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.adapter.out.external.bank.ExternalBankAccountResult;
import org.dongdong.banking.adapter.out.persistence.bankaccount.BankAccountJpaEntity;
import org.dongdong.banking.adapter.out.persistence.bankaccount.BankAccountMapper;
import org.dongdong.banking.application.port.in.RegisterBankAccountCommand;
import org.dongdong.banking.application.port.in.RegisterBankAccountUseCase;
import org.dongdong.banking.application.port.out.RegisterBankAccountPort;
import org.dongdong.banking.application.port.out.RequestBankAccountInfoPort;
import org.dongdong.banking.domain.BankAccount;
import org.dongdong.common.UseCase;

@UseCase
@RequiredArgsConstructor
public class RegisterBankAccountService implements RegisterBankAccountUseCase {

  private final RegisterBankAccountPort registerBankAccountPort;
  private final RequestBankAccountInfoPort requestBankAccountInfoPort;
  private final BankAccountMapper bankAccountMapper;
  @Override
  public BankAccount registerBankAccount(RegisterBankAccountCommand command) {

    // 은행 계좌를 등록해야하는 서비스(비즈니스 로직)

    // Todo: 추후 유효한 멤버인지 확인(2023.12.06)
    // (멤버서비스도 확인) => 추후 통신 쪽 배우면 확인해보자

    // 1. 등록된 계좌인지 확인
    // 외부 은행에 이 계좌가 정상인지? 확인을 해야함
    // biz logic -> external system (port -> adapter)
    ExternalBankAccountResult bankAccountInfo = requestBankAccountInfoPort.getBankAccountInfo(
      command.getBankName(),
      command.getBankAccountNumber()
    );
    if(bankAccountInfo.getIsValid()){
      BankAccountJpaEntity bankAccount = registerBankAccountPort.createBankAccount(
        new BankAccount.MembershipId(command.getMembershipId()),
        new BankAccount.BankName(command.getBankName()),
        new BankAccount.BankAccountNumber(command.getBankAccountNumber()),
        new BankAccount.LinkedStatusIsValid(command.getLinkedStatusIsValid())
      );
      return bankAccountMapper.mapToDomainEntity(bankAccount);
    }

    // 2. 등록 가능한 계좌라면 등록(성공 시 성공한 등록 정보를 리턴)
    // 2-1. 등록가능하지 않은 계좌라면 에러를 리턴
    throw new RuntimeException();
  }
}

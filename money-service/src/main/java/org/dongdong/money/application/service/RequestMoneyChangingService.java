package org.dongdong.money.application.service;

import lombok.RequiredArgsConstructor;
import org.dongdong.common.UseCase;
import org.dongdong.money.adapter.out.persistence.MoneyChangingRequestMapper;
import org.dongdong.money.application.port.in.DecreaseMoneyCommand;
import org.dongdong.money.application.port.in.IncreaseMoneyCommand;
import org.dongdong.money.application.port.in.RequestMoneyChangingUseCase;
import org.dongdong.money.application.port.out.RequestMoneyChangingPort;
import org.dongdong.money.domain.MemberMoney;
import org.dongdong.money.domain.MoneyChangingRequest;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RequestMoneyChangingService implements RequestMoneyChangingUseCase {

  private final RequestMoneyChangingPort moneyChangingPort;
  private final MoneyChangingRequestMapper moneyChangingRequestMapper;

  @Override
  public MoneyChangingRequest increase(IncreaseMoneyCommand command) {

    // 머니의 증액 과정

    // 1. 고객 정보가 유효한지 확인(멤버)

    // 2. 고객의 연동된 계좌가 있는지, 그 계좌에 잔액이 충분한지(뱅킹)

    // 3. 법인 계좌 상태도 정상인지(뱅킹)

    // 4. 증액을 위한 "기록", 요청 상태로 MoneyChangingRequest 를 생성(머니)

    // 5. 펌뱅킹을 수행하고 (고객의 연동된 계좌 -> 패캠 법인 계좌)(뱅킹)

    // 6-1. 결과가 정상이면 성공으로 MoneyChangingRequest 상태표시 바꾸고, 실제 고객 money 증액 하고 리턴 (여기서 성공이라고 가정)
    moneyChangingPort.increaseMoney(
      new MemberMoney.MembershipId(command.getTargetMembershipId()),
      new MemberMoney.LinkedBankAccountId(0L), // 2번에서 나오는 bankAccountId 가 0 이라 가정
      command.getChangingMoneyAmount()
    );
    return moneyChangingRequestMapper.mapToDomainEntity(moneyChangingPort.saveIncreasingMoney(
      new MoneyChangingRequest.TargetMembershipId(command.getTargetMembershipId()),
      new MoneyChangingRequest.MoneyChangingTypes(MoneyChangingRequest.MoneyChangingType.INCREASE),
      new MoneyChangingRequest.ChangingMoneyAmount(command.getChangingMoneyAmount()),
      new MoneyChangingRequest.MoneyChangingStatuses(MoneyChangingRequest.MoneyChangingStatus.SUCCEEDED)
    ));

    // 6-2. 결과가 비정상이면 실패로 MoneyChangingRequest 상태표시 바꾸고 리턴
  }

  @Override
  public MoneyChangingRequest decrease(DecreaseMoneyCommand command) {
    return null;
  }
}

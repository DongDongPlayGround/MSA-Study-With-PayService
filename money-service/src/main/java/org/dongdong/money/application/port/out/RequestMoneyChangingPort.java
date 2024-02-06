package org.dongdong.money.application.port.out;

import org.dongdong.money.adapter.out.persistence.MemberMoneyJpaEntity;
import org.dongdong.money.adapter.out.persistence.MoneyChangingRequestJpaEntity;
import org.dongdong.money.domain.MemberMoney;
import org.dongdong.money.domain.MoneyChangingRequest;

public interface RequestMoneyChangingPort {

  MoneyChangingRequestJpaEntity saveIncreasingMoney(
    MoneyChangingRequest.TargetMembershipId targetMembershipId,
    MoneyChangingRequest.MoneyChangingTypes moneyChangingTypes,
    MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
    MoneyChangingRequest.MoneyChangingStatuses moneyChangingStatuses
  );

  MemberMoneyJpaEntity increaseMoney(
    MemberMoney.MembershipId membershipId,
    MemberMoney.LinkedBankAccountId linkedBankAccountId,
    Long increaseAmount
  );

  MoneyChangingRequestJpaEntity saveDecreasingMoney(
    MoneyChangingRequest.TargetMembershipId targetMembershipId,
    MoneyChangingRequest.MoneyChangingTypes moneyChangingTypes,
    MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
    MoneyChangingRequest.MoneyChangingStatuses moneyChangingStatuses
  );
}

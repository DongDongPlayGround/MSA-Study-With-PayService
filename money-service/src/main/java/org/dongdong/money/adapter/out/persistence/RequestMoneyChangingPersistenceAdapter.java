package org.dongdong.money.adapter.out.persistence;

import lombok.RequiredArgsConstructor;
import org.dongdong.common.PersistenceAdapter;
import org.dongdong.money.application.port.out.RequestMoneyChangingPort;
import org.dongdong.money.domain.MemberMoney;
import org.dongdong.money.domain.MoneyChangingRequest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class RequestMoneyChangingPersistenceAdapter implements RequestMoneyChangingPort {

  private final MoneyChangingRequestJpaRepository moneyChangingRequestJpaRepository;
  private final MemberMoneyJpaRepository memberMoneyJpaRepository;

  @Override
  public MoneyChangingRequestJpaEntity saveIncreasingMoney(
    MoneyChangingRequest.TargetMembershipId targetMembershipId,
    MoneyChangingRequest.MoneyChangingTypes moneyChangingTypes,
    MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
    MoneyChangingRequest.MoneyChangingStatuses moneyChangingStatuses) {

    MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity = MoneyChangingRequestJpaEntity.create(
      targetMembershipId.getTargetMembershipId(),
      moneyChangingTypes.getMoneyChangingType(),
      changingMoneyAmount.getChangingMoneyAmount(),
      moneyChangingStatuses.getMoneyChangingStatus()
    );
    return moneyChangingRequestJpaRepository.save(moneyChangingRequestJpaEntity);
  }

  @Override
  @Transactional
  public MemberMoneyJpaEntity increaseMoney(
    MemberMoney.MembershipId membershipId,
    MemberMoney.LinkedBankAccountId linkedBankAccountId,
    Long increaseAmount
  ) {
    Optional<MemberMoneyJpaEntity> optionalMemberMoneyJpaEntity =
      memberMoneyJpaRepository.findAllByMembershipIdAndLinkedBankAccountId(
        membershipId.getMembershipId(), linkedBankAccountId.getLinkedBankAccountId());
    if(optionalMemberMoneyJpaEntity.isPresent()){
      return optionalMemberMoneyJpaEntity.get().increaseMoney(increaseAmount);
    }
    return memberMoneyJpaRepository.save(
        MemberMoneyJpaEntity.create(
          membershipId.getMembershipId(),
          linkedBankAccountId.getLinkedBankAccountId(),
          increaseAmount));
  }

  @Override
  public MoneyChangingRequestJpaEntity saveDecreasingMoney(
    MoneyChangingRequest.TargetMembershipId targetMembershipId,
    MoneyChangingRequest.MoneyChangingTypes moneyChangingTypes,
    MoneyChangingRequest.ChangingMoneyAmount changingMoneyAmount,
    MoneyChangingRequest.MoneyChangingStatuses moneyChangingStatuses) {
    MoneyChangingRequestJpaEntity moneyChangingRequestJpaEntity = MoneyChangingRequestJpaEntity.create(
      targetMembershipId.getTargetMembershipId(),
      moneyChangingTypes.getMoneyChangingType(),
      changingMoneyAmount.getChangingMoneyAmount(),
      moneyChangingStatuses.getMoneyChangingStatus()
    );
    return moneyChangingRequestJpaRepository.save(moneyChangingRequestJpaEntity);
  }
}

package org.dongdong.money.adapter.out.persistence;

import org.dongdong.money.adapter.in.web.MoneyChangingResultDetail;
import org.dongdong.money.domain.MoneyChangingRequest;
import org.springframework.stereotype.Component;

@Component
public class MoneyChangingRequestMapper {

  public MoneyChangingRequest mapToDomainEntity(MoneyChangingRequestJpaEntity jpaEntity) {
    return MoneyChangingRequest.create(
      new MoneyChangingRequest.MoneyChangingRequestId(jpaEntity.getId()),
      new MoneyChangingRequest.TargetMembershipId(jpaEntity.getTargetMembershipId()),
      new MoneyChangingRequest.MoneyChangingTypes(jpaEntity.getMoneyChangingType()),
      new MoneyChangingRequest.ChangingMoneyAmount(jpaEntity.getChangingMoneyAmount()),
      new MoneyChangingRequest.MoneyChangingStatuses(jpaEntity.getMoneyChangingStatus()),
      new MoneyChangingRequest.MoneyChangingUUID(jpaEntity.getUuid()),
      new MoneyChangingRequest.MoneyChangingCreatedAt(jpaEntity.getCreatedAt())
    );
  }

  public MoneyChangingResultDetail mapToResultDetail(
    MoneyChangingRequest moneyChangingRequest
  ) {
    return new MoneyChangingResultDetail(
      moneyChangingRequest.getMoneyChangingRequestId(),
      moneyChangingRequest.getMoneyChangingType(),
      moneyChangingRequest.getChangingMoneyAmount(),
      moneyChangingRequest.getMoneyChangingStatus()
    );
  }
}

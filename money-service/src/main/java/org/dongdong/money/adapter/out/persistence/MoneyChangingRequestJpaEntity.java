package org.dongdong.money.adapter.out.persistence;

import lombok.*;
import org.dongdong.money.domain.MoneyChangingRequest;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "money_change_request")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequestJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long targetMembershipId;

  // 요청이 증액인지 감액인지
  @Enumerated(EnumType.STRING)
  private MoneyChangingRequest.MoneyChangingType moneyChangingType;

  // 증액 또는 감액 요청의 금액
  private Long changingMoneyAmount;

  // 머니 변액 요청에 대한 상태
  @Enumerated(EnumType.STRING)
  private MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus;

  // firmBanking 에 있던 uuid 와 비슷
  private String uuid;

  private LocalDateTime createdAt;

  public static MoneyChangingRequestJpaEntity create(
    Long targetMembershipId,
    MoneyChangingRequest.MoneyChangingType moneyChangingType,
    Long changingMoneyAmount,
    MoneyChangingRequest.MoneyChangingStatus moneyChangingStatus
  ) {
    return MoneyChangingRequestJpaEntity.builder()
      .targetMembershipId(targetMembershipId)
      .moneyChangingType(moneyChangingType)
      .changingMoneyAmount(changingMoneyAmount)
      .moneyChangingStatus(moneyChangingStatus)
      .uuid(UUID.randomUUID().toString())
      .createdAt(LocalDateTime.now())
      .build();
  }
}

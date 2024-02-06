package org.dongdong.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MoneyChangingRequest {

  private final Long moneyChangingRequestId;

  // 어떤 고객의 증액/감액 요청인지
  private final Long targetMembershipId;

  // 요청이 증액인지 감액인지
  private final MoneyChangingType moneyChangingType;

  // 증액 또는 감액 요청의 금액
  private final Long changingMoneyAmount;

  // 머니 변액 요청에 대한 상태
  private final MoneyChangingStatus moneyChangingStatus;

  // firmBanking 에 있던 uuid 와 비슷
  private final String uuid;

  private final LocalDateTime createdAt;

  public enum MoneyChangingType {
    INCREASE, DECREASE
  }

  public enum MoneyChangingStatus {
    REQUESTED,
    SUCCEEDED,
    FAILED,
    FAILED_NOT_ENOUGH_MONEY, // 잔액 부족
    FAILED_NOT_EXIST_MEMBERSHIP, // 회원 검증 실패
    FAILED_NOT_EXIST_MONEY_CHANGING_REQUEST, // 변액 검증 실패
    CANCELED
  }

  public static MoneyChangingRequest create(MoneyChangingRequestId id,
                                            TargetMembershipId targetMembershipId,
                                            MoneyChangingTypes moneyChangingTypes,
                                            ChangingMoneyAmount changingMoneyAmount,
                                            MoneyChangingStatuses moneyChangingStatuses,
                                            MoneyChangingUUID uuid,
                                            MoneyChangingCreatedAt createdAt) {
    return new MoneyChangingRequest(
      id.moneyChangingRequestId,
      targetMembershipId.targetMembershipId,
      moneyChangingTypes.moneyChangingType,
      changingMoneyAmount.changingMoneyAmount,
      moneyChangingStatuses.moneyChangingStatus,
      uuid.uuid,
      createdAt.createdAt
    );
  }

  @Value
  public static class MoneyChangingRequestId {
    Long moneyChangingRequestId;

    public MoneyChangingRequestId(Long moneyChangingRequestId){
      this.moneyChangingRequestId = moneyChangingRequestId;
    }
  }

  @Value
  public static class TargetMembershipId {
    Long targetMembershipId;

    public TargetMembershipId(Long targetMembershipId){
      this.targetMembershipId = targetMembershipId;
    }
  }

  @Value
  public static class MoneyChangingTypes {
    MoneyChangingType moneyChangingType;

    public MoneyChangingTypes(MoneyChangingType moneyChangingType){
      this.moneyChangingType = moneyChangingType;
    }
  }

  @Value
  public static class ChangingMoneyAmount {
    Long changingMoneyAmount;

    public ChangingMoneyAmount(Long changingMoneyAmount){
      this.changingMoneyAmount = changingMoneyAmount;
    }
  }

  @Value
  public static class MoneyChangingStatuses {
    MoneyChangingStatus moneyChangingStatus;

    public MoneyChangingStatuses(MoneyChangingStatus moneyChangingStatus){
      this.moneyChangingStatus = moneyChangingStatus;
    }
  }

  @Value
  public static class MoneyChangingUUID {
    String uuid;

    public MoneyChangingUUID(String uuid){
      this.uuid = uuid;
    }
  }

  @Value
  public static class MoneyChangingCreatedAt {
    LocalDateTime createdAt;

    public MoneyChangingCreatedAt(LocalDateTime createdAt){
      this.createdAt = createdAt;
    }
  }
}

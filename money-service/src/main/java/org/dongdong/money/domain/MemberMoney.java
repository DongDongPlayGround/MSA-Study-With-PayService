package org.dongdong.money.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoney {

  private Long memberMoneyId;

  // 어떤 고객의 머니인지
  private Long membershipId;

  // 어떤 계좌에 연동된 머니인지
  private Long linkedBankAccountId;

  private Long balance;


  public static MemberMoney create(MemberMoneyId memberMoneyId,
                                   MembershipId membershipId,
                                   LinkedBankAccountId linkedBankAccountId,
                                   Balance balance) {
    return new MemberMoney(
      memberMoneyId.memberMoneyId,
      membershipId.membershipId,
      linkedBankAccountId.linkedBankAccountId,
      balance.balance
    );
  }

  public MemberMoney increase(Long increaseAmount) {
    this.balance += increaseAmount;
    return this;
  }

  @Value
  public static class MemberMoneyId {
    Long memberMoneyId;

    public MemberMoneyId(Long memberMoneyId) {
      this.memberMoneyId = memberMoneyId;
    }
  }

  @Value
  public static class MembershipId {
    Long membershipId;

    public MembershipId(Long targetMembershipId) {
      this.membershipId = targetMembershipId;
    }
  }

  @Value
  public static class LinkedBankAccountId {
    Long linkedBankAccountId;

    public LinkedBankAccountId(Long linkedBankAccountId) {
      this.linkedBankAccountId = linkedBankAccountId;
    }
  }

  @Value
  public static class Balance {
    Long balance;

    public Balance(Long balance) {
      this.balance = balance;
    }
  }
}

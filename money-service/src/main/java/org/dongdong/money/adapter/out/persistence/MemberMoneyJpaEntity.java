package org.dongdong.money.adapter.out.persistence;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "member_money")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MemberMoneyJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  // 어떤 고객의 머니인지
  private Long membershipId;

  // 어떤 계좌에 연동된 머니인지
  private Long linkedBankAccountId;

  private Long balance;


  public static MemberMoneyJpaEntity create(Long memberMoneyId,
                                            Long linkedBankAccountId,
                                            Long balance) {
    return MemberMoneyJpaEntity.builder()
      .membershipId(memberMoneyId)
      .linkedBankAccountId(linkedBankAccountId)
      .balance(balance)
      .build();
  }

  public MemberMoneyJpaEntity increaseMoney(Long increaseAmount) {
    this.balance += increaseAmount;
    return this;
  }
}

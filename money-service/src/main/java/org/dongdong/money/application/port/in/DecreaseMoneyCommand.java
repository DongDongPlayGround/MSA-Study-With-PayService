package org.dongdong.money.application.port.in;

import lombok.Getter;
import org.dongdong.common.SelfValidating;
import org.dongdong.money.domain.MoneyChangingRequest;

import javax.validation.constraints.NotNull;

@Getter
public class DecreaseMoneyCommand extends SelfValidating<DecreaseMoneyCommand> {


  // 어떤 고객의 증액/감액 요청인지
  @NotNull
  private Long targetMembershipId;

  // 증액 또는 감액 요청의 금액
  @NotNull
  private Long changingMoneyAmount;


  public DecreaseMoneyCommand(Long targetMembershipId,
                              Long changingMoneyAmount) {
    this.targetMembershipId = targetMembershipId;
    this.changingMoneyAmount = changingMoneyAmount;
    this.validateSelf();
  }
}

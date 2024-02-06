package org.dongdong.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dongdong.money.domain.MoneyChangingRequest;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DecreaseMoneyRequest {

  // 어떤 고객의 증액/감액 요청인지
  private Long targetMembershipId;

  // 증액 또는 감액 요청의 금액
  private Long changingMoneyAmount;
}

package org.dongdong.money.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dongdong.money.domain.MoneyChangingRequest;
import org.springframework.context.annotation.Primary;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MoneyChangingResultDetail {

  private Long moneyChangingRequestId;

  private MoneyChangingRequest.MoneyChangingType moneyChangingType;

  private Long amount;

  private MoneyChangingRequest.MoneyChangingStatus status;

}

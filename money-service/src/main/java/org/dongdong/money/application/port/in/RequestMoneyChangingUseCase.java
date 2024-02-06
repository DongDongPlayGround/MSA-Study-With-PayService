package org.dongdong.money.application.port.in;

import org.dongdong.money.domain.MoneyChangingRequest;

public interface RequestMoneyChangingUseCase {

  MoneyChangingRequest increase(IncreaseMoneyCommand command);
  MoneyChangingRequest decrease(DecreaseMoneyCommand command);
}

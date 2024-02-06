package org.dongdong.money.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.dongdong.common.WebAdapter;
import org.dongdong.money.adapter.out.persistence.MoneyChangingRequestMapper;
import org.dongdong.money.application.port.in.DecreaseMoneyCommand;
import org.dongdong.money.application.port.in.IncreaseMoneyCommand;
import org.dongdong.money.application.port.in.RequestMoneyChangingUseCase;
import org.dongdong.money.domain.MoneyChangingRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestMoneyChangingController {

  private final RequestMoneyChangingUseCase requestMoneyChangingUseCase;
  private final MoneyChangingRequestMapper moneyChangingRequestMapper;

  @PostMapping("/money/increase")
  public MoneyChangingResultDetail increaseMoneyRequest(@RequestBody IncreaseMoneyRequest increaseMoneyRequest){
    IncreaseMoneyCommand command = new IncreaseMoneyCommand(
      increaseMoneyRequest.getTargetMembershipId(),
      increaseMoneyRequest.getChangingMoneyAmount()
    );

    MoneyChangingRequest increase = requestMoneyChangingUseCase.increase(command);
    return moneyChangingRequestMapper.mapToResultDetail(increase);
  }

  @PostMapping("/money/decrease")
  public MoneyChangingResultDetail decreaseMoneyRequest(@RequestBody DecreaseMoneyRequest decreaseMoneyRequest){
    DecreaseMoneyCommand command = new DecreaseMoneyCommand(
      decreaseMoneyRequest.getTargetMembershipId(),
      decreaseMoneyRequest.getChangingMoneyAmount()
    );

    MoneyChangingRequest decrease = requestMoneyChangingUseCase.decrease(command);
    return moneyChangingRequestMapper.mapToResultDetail(decrease);
  }
}

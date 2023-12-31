package org.dongdong.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.application.port.in.RegisterBankAccountCommand;
import org.dongdong.banking.application.port.in.RegisterBankAccountUseCase;
import org.dongdong.banking.domain.BankAccount;
import org.dongdong.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RegisterBankAccountController {

  private final RegisterBankAccountUseCase registerBankAccountUseCase;

  @PostMapping("/banking/account/register")
  public BankAccount register(@RequestBody RegisterBankAccountRequest request){

    RegisterBankAccountCommand command = RegisterBankAccountCommand.builder()
      .membershipId(request.getMembershipId())
      .bankName(request.getBankName())
      .bankAccountNumber(request.getBankAccountNumber())
      .linkedStatusIsValid(request.getLinkedStatusIsValid()).build();

    return registerBankAccountUseCase.registerBankAccount(command);
  }
}

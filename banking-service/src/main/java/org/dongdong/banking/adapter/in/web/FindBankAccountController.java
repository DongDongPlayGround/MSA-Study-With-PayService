package org.dongdong.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.application.port.in.FindBankAccountUseCase;
import org.dongdong.banking.domain.BankAccount;
import org.dongdong.common.WebAdapter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class FindBankAccountController {

  private final FindBankAccountUseCase findBankAccountUseCase;

  @GetMapping("/banking/account/{id}")
  public BankAccount getBankAccount(@PathVariable(name = "id") Long id){

    return findBankAccountUseCase.getBankAccountById(id);
  }
}

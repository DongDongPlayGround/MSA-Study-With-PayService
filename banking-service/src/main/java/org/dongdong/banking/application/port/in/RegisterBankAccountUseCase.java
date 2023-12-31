package org.dongdong.banking.application.port.in;

import org.dongdong.banking.domain.BankAccount;

public interface RegisterBankAccountUseCase {

  BankAccount registerBankAccount(RegisterBankAccountCommand command);
}

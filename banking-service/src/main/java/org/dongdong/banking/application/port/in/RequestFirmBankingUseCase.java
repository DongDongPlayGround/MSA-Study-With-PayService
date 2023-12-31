package org.dongdong.banking.application.port.in;

import org.dongdong.banking.domain.BankAccount;
import org.dongdong.banking.domain.FirmBankingRequest;

public interface RequestFirmBankingUseCase {

  FirmBankingRequest registerBankAccount(RequestFirmBankingCommand command);
}

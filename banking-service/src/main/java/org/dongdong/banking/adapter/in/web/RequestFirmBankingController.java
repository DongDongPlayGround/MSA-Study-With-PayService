package org.dongdong.banking.adapter.in.web;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.application.port.in.RequestFirmBankingCommand;
import org.dongdong.banking.application.port.in.RequestFirmBankingUseCase;
import org.dongdong.banking.domain.FirmBankingRequest;
import org.dongdong.common.WebAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@WebAdapter
@RestController
@RequiredArgsConstructor
public class RequestFirmBankingController {

  private final RequestFirmBankingUseCase requestFirmBankingUseCase;


  @PostMapping("/banking/firm-banking/request")
  public FirmBankingRequest requestFirmBanking(@RequestBody RequestFirmBankingRequest firmBankingRequest){

    RequestFirmBankingCommand command =
      new RequestFirmBankingCommand(
        firmBankingRequest.getFromBankName(),
        firmBankingRequest.getFromBankAccountNumber(),
        firmBankingRequest.getToBankName(),
        firmBankingRequest.getToBankAccountNumber(),
        firmBankingRequest.getAmount(),
        firmBankingRequest.getStatus()
      );
    return requestFirmBankingUseCase.registerBankAccount(command);
  }
}

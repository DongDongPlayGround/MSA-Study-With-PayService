package org.dongdong.banking.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongdong.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import org.dongdong.banking.adapter.out.external.bank.ExternalFirmBankingResult;
import org.dongdong.banking.adapter.out.persistence.firmbanking.FirmBankingRequestJpaEntity;
import org.dongdong.banking.adapter.out.persistence.firmbanking.FirmBankingRequestMapper;
import org.dongdong.banking.application.port.in.RequestFirmBankingCommand;
import org.dongdong.banking.application.port.in.RequestFirmBankingUseCase;
import org.dongdong.banking.application.port.out.RequestExternalFirmBankingPort;
import org.dongdong.banking.application.port.out.RequestFirmBankingPort;
import org.dongdong.banking.domain.FirmBankingRequest;
import org.dongdong.banking.domain.FirmBankingStatus;
import org.dongdong.common.UseCase;
import org.springframework.transaction.annotation.Transactional;


@UseCase
@RequiredArgsConstructor
@Slf4j
public class RequestFirmBankingService implements RequestFirmBankingUseCase {

  private final RequestFirmBankingPort requestFirmBankingPort;
  private final FirmBankingRequestMapper firmBankingRequestMapper;
  private final RequestExternalFirmBankingPort externalFirmBankingPort;

  @Transactional
  @Override
  public FirmBankingRequest registerBankAccount(RequestFirmBankingCommand command) {

    //biz logic
    // 1. a ->  b 계좌 펌뱅킹 요청 저장
    FirmBankingRequestJpaEntity firmBankingRequest = requestFirmBankingPort.createFirmBankingRequest(
      new FirmBankingRequest.FromBankName(command.getFromBankName()),
      new FirmBankingRequest.FromBankAccount(command.getFromBankAccountNumber()),
      new FirmBankingRequest.ToBankName(command.getToBankName()),
      new FirmBankingRequest.ToBankAccount(command.getToBankAccountNumber()),
      new FirmBankingRequest.Amount(command.getAmount()),
      new FirmBankingRequest.FirmBankingStatusValue(FirmBankingStatus.REQUESTED)
    );

    // 2. 외부 은행에 펌뱅킹 요청
    ExternalFirmBankingResult externalFirmBankingResult = externalFirmBankingPort.requestExternalFirmBanking(
      new ExternalFirmBankingRequest(
        command.getFromBankName(),
        command.getFromBankAccountNumber(),
        command.getToBankName(),
        command.getToBankAccountNumber(),
        command.getAmount(),
        command.getStatus()
      )
    );
    // 3. 결과에 따라 1번의 데이터를 update
    switch (externalFirmBankingResult.getResultCode()) {
      case "200" -> firmBankingRequest.complete();
      case "500" -> firmBankingRequest.fail();
      default -> log.info("[RequestFirmBankingService] not defined result code!");
    }

    // 4. 결과 리턴
    return firmBankingRequestMapper.mapToDomainEntity(firmBankingRequest);
  }
}

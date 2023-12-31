package org.dongdong.banking.adapter.out.persistence.firmbanking;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.application.port.out.RequestFirmBankingPort;
import org.dongdong.banking.domain.FirmBankingRequest;
import org.dongdong.banking.domain.FirmBankingStatus;
import org.dongdong.common.PersistenceAdapter;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@PersistenceAdapter
@RequiredArgsConstructor
public class FirmBankingRequestPersistenceAdapter implements RequestFirmBankingPort {

  private final SpringDataFirmBankingRequestRepository firmBankingRequestRepository;


  @Override
  public FirmBankingRequestJpaEntity createFirmBankingRequest(
    FirmBankingRequest.FromBankName fromBankName,
    FirmBankingRequest.FromBankAccount fromBankAccount,
    FirmBankingRequest.ToBankName toBankName,
    FirmBankingRequest.ToBankAccount toBankAccount,
    FirmBankingRequest.Amount amount,
    FirmBankingRequest.FirmBankingStatusValue status
  ) {
    return Optional.of(
        FirmBankingRequestJpaEntity.create(
          fromBankName.getFromBankName(),
          fromBankAccount.getFromBankAccount(),
          toBankName.getToBankName(),
          toBankAccount.getToBankAccount(),
          amount.getAmount(),
          status.getStatus()
        ))
      .map(firmBankingRequestRepository::save)
      .get();
  }
}

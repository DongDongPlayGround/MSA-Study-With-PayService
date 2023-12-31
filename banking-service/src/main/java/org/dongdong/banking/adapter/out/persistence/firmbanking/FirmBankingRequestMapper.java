package org.dongdong.banking.adapter.out.persistence.firmbanking;

import org.dongdong.banking.domain.FirmBankingRequest;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FirmBankingRequestMapper {

  public FirmBankingRequest mapToDomainEntity(FirmBankingRequestJpaEntity firmBankingRequestJpaEntity) {
    if (firmBankingRequestJpaEntity == null) {
      return null;
    }
    return FirmBankingRequest.create(
      new FirmBankingRequest.FirmBankingRequestId(firmBankingRequestJpaEntity.getFirmBankingRequestId()),
      new FirmBankingRequest.FromBankName(firmBankingRequestJpaEntity.getFromBankName()),
      new FirmBankingRequest.FromBankAccount(firmBankingRequestJpaEntity.getFromBankAccount()),
      new FirmBankingRequest.ToBankName(firmBankingRequestJpaEntity.getToBankName()),
      new FirmBankingRequest.ToBankAccount(firmBankingRequestJpaEntity.getToBankAccount()),
      new FirmBankingRequest.Amount(firmBankingRequestJpaEntity.getAmount()),
      new FirmBankingRequest.FirmBankingStatusValue(firmBankingRequestJpaEntity.getStatus()),
      firmBankingRequestJpaEntity.getUuid()
    );
  }
}

package org.dongdong.banking.application.port.out;

import org.dongdong.banking.adapter.out.persistence.firmbanking.FirmBankingRequestJpaEntity;
import org.dongdong.banking.domain.FirmBankingRequest;

/*
 * 외부 은행에 유효한 계좌인지 정보를 요구하는 포트
 * */
public interface RequestFirmBankingPort {

  FirmBankingRequestJpaEntity createFirmBankingRequest(
    FirmBankingRequest.FromBankName fromBankName,
    FirmBankingRequest.FromBankAccount fromBankAccount,
    FirmBankingRequest.ToBankName toBankName,
    FirmBankingRequest.ToBankAccount toBankAccount,
    FirmBankingRequest.Amount amount,
    FirmBankingRequest.FirmBankingStatusValue status
  );
}

package org.dongdong.banking.adapter.out.external.bank;

import lombok.RequiredArgsConstructor;
import org.dongdong.banking.application.port.out.RequestBankAccountInfoPort;
import org.dongdong.banking.application.port.out.RequestExternalFirmBankingPort;
import org.dongdong.common.ExternalSystemAdapter;

@ExternalSystemAdapter
@RequiredArgsConstructor
public class ExternalBankAccountAdapter implements RequestBankAccountInfoPort, RequestExternalFirmBankingPort {
  @Override
  public ExternalBankAccountResult getBankAccountInfo(String bankName,
                                                      String bankAccountNumber) {
    return new ExternalBankAccountResult(bankName, bankAccountNumber, true);
  }

  @Override
  public ExternalFirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request) {

    // 외부 은행에 http 콜을 통해 펌뱅킹을 요청
    // 그 결과를 FirmBankingResult 로 파싱

    // 지금은 항상 참이라 가정
    return new ExternalFirmBankingResult("200");
  }
}

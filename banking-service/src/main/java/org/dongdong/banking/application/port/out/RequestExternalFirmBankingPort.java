package org.dongdong.banking.application.port.out;

import org.dongdong.banking.adapter.out.external.bank.ExternalFirmBankingRequest;
import org.dongdong.banking.adapter.out.external.bank.ExternalFirmBankingResult;

/*
* 외부 은행에 펌뱅킹 요청이 잘 이루어졌는지 확인하는 포트
* */
public interface RequestExternalFirmBankingPort {

  ExternalFirmBankingResult requestExternalFirmBanking(ExternalFirmBankingRequest request);
}

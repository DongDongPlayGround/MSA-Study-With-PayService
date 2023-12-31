package org.dongdong.banking.application.port.out;

import org.dongdong.banking.adapter.out.external.bank.ExternalBankAccountResult;

/*
* 외부 은행에 유효한 계좌인지 정보를 요구하는 포트
* */
public interface RequestBankAccountInfoPort {

  ExternalBankAccountResult getBankAccountInfo(String bankName, String bankAccountNumber);
}

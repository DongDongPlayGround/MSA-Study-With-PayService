package org.dongdong.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dongdong.banking.domain.FirmBankingStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestFirmBankingRequest {

  // a -> b 실물계좌로 요청을 하기 위한 Request
  private String fromBankName;
  private String fromBankAccountNumber;

  private String toBankName;
  private String toBankAccountNumber;

  private Integer amount;
  private FirmBankingStatus status;
}

package org.dongdong.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalFirmBankingResult {

  private String resultCode; // 성공 or 실패

  /*
  * 성공 : 200
  * 실패 : 500
  * 으로 가정
  * */
}

package org.dongdong.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dongdong.banking.domain.FirmBankingStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalFirmBankingRequest {
  private String fromBankName;
  private String fromBankAccountNumber;

  private String toBankName;
  private String toBankAccountNumber;

  private Integer amount;
  private FirmBankingStatus status;
}

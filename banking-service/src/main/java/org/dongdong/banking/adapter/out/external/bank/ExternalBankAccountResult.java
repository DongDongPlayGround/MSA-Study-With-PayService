package org.dongdong.banking.adapter.out.external.bank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExternalBankAccountResult {

  private String bankName;
  private String bankAccountNumber;
  private Boolean isValid;
}

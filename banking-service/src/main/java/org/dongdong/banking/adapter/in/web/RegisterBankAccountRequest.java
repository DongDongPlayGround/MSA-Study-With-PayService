package org.dongdong.banking.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterBankAccountRequest {

  private Long membershipId;

  private String bankName;

  private String bankAccountNumber;

  private Boolean linkedStatusIsValid;
}

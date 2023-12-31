package org.dongdong.banking.application.port.in;

import lombok.*;
import org.dongdong.common.SelfValidating;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
* 해당 클래스는 Register 용으로 필요한 데이터를 감싸는 클래스
 * 따라서 bankAccountId 는 없다
 * */
@Builder
@Getter
@ToString
@EqualsAndHashCode(callSuper = true)
public class RegisterBankAccountCommand extends SelfValidating<RegisterBankAccountCommand> {

  @NotNull
  private final Long membershipId;

  @NotNull
  @NotBlank
  private final String bankName;

  @NotNull
  @NotBlank
  private final String bankAccountNumber;

  @NotNull
  private final Boolean linkedStatusIsValid;

  public RegisterBankAccountCommand(Long membershipId,
                                    String bankName,
                                    String bankAccountNumber,
                                    Boolean linkedStatusIsValid){
    this.membershipId = membershipId;
    this.bankName = bankName;
    this.bankAccountNumber= bankAccountNumber;
    this.linkedStatusIsValid =linkedStatusIsValid;

    this.validateSelf();
  }
}

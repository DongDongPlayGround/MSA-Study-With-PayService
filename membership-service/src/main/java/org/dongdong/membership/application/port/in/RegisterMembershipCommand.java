package org.dongdong.membership.application.port.in;

import common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class RegisterMembershipCommand extends SelfValidating<RegisterMembershipCommand> {

  @NotNull
  private String name;

  @NotNull
  private String address;

  @NotNull
  @NotBlank
  private String email;

  @AssertTrue
  private Boolean isValid; // 항상 true 라고 개발단에서부터 가정

  private Boolean isCorp;

  public RegisterMembershipCommand(String name,
                                   String address,
                                   String email,
                                   Boolean isValid,
                                   Boolean isCorp) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.isValid = isValid;
    this.isCorp = isCorp;

    this.validateSelf();
  }

}

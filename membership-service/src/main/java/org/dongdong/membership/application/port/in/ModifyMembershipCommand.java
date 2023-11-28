package org.dongdong.membership.application.port.in;

import org.dongdong.common.SelfValidating;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@EqualsAndHashCode(callSuper = true)
@Builder
@Data
public class ModifyMembershipCommand extends SelfValidating<ModifyMembershipCommand> {

  @NotNull
  private Long id;

  @NotNull
  private String name;

  @NotNull
  private String address;

  @NotNull
  @NotBlank
  private String email;

  private Boolean isValid; // 항상 true 라고 개발단에서부터 가정

  private Boolean isCorp;

  public ModifyMembershipCommand(Long id,
                                 String name,
                                 String address,
                                 String email,
                                 Boolean isValid,
                                 Boolean isCorp) {
    this.id = id;
    this.name = name;
    this.address = address;
    this.email = email;
    this.isValid = isValid;
    this.isCorp = isCorp;

    this.validateSelf();
  }

}

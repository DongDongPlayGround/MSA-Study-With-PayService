package org.dongdong.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModifyMembershipRequest {

  private Long id;
  private String name;
  private String address;
  private String email;
  private Boolean isValid;
  private Boolean isCorp;
}

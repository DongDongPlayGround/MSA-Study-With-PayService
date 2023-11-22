package org.dongdong.membership.adapter.in.web;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterMembershipRequest {

  private String name;
  private String address;
  private String email;
  private Boolean isCorp;
}

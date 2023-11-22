package org.dongdong.membership.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "membership")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MembershipJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long membershipId;

  private String name;

  private String email;

  private String address;

  private Boolean isValid;

  private Boolean isCorp;

  public MembershipJpaEntity(String name,
                             String email,
                             String address,
                             Boolean isValid,
                             Boolean isCorp) {
    this.name = name;
    this.address = address;
    this.email = email;
    this.isValid = isValid;
    this.isCorp = isCorp;
  }
}

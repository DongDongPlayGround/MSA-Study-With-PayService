package org.dongdong.banking.adapter.out.persistence.bankaccount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long bankAccountId;

  private Long membershipId;

  private String bankName;

  private String bankAccountNumber;

  private Boolean linkedStatusIsValid;

  public BankAccountJpaEntity(Long membershipId,
                              String bankName,
                              String bankAccountNumber,
                              Boolean linkedStatusIsValid) {
    this.membershipId = membershipId;
    this.bankName = bankName;
    this.bankAccountNumber = bankAccountNumber;
    this.linkedStatusIsValid = linkedStatusIsValid;
  }
}

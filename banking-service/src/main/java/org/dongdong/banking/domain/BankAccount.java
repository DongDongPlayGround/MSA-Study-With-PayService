package org.dongdong.banking.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class BankAccount {

  private final Long bankAccountId;
  private final Long membershipId;
  private final String bankName;
  private final String bankAccountNumber;
  private final Boolean linkedStatusIsValid;

  public static BankAccount create(BankAccountId id,
                                   MembershipId membershipId,
                                   BankName bankName,
                                   BankAccountNumber bankAccountNumber,
                                   LinkedStatusIsValid isValid) {
    return new BankAccount(
      id.bankAccountId,
      membershipId.membershipId,
      bankName.bankName,
      bankAccountNumber.bankAccountNumber,
      isValid.linkedStatusIsValid);
  }

  @Value
  public static class BankAccountId {

    Long bankAccountId;

    public BankAccountId(Long bankAccountId) {
      this.bankAccountId = bankAccountId;
    }
  }

  @Value
  public static class MembershipId {

    Long membershipId;

    public MembershipId(Long membershipId) {
      this.membershipId = membershipId;
    }
  }

  @Value
  public static class BankName {

    String bankName;

    public BankName(String bankName) {
      this.bankName = bankName;
    }
  }

  @Value
  public static class BankAccountNumber {

    String bankAccountNumber;

    public BankAccountNumber(String bankAccountNumber) {
      this.bankAccountNumber = bankAccountNumber;
    }
  }

  @Value
  public static class LinkedStatusIsValid {

    Boolean linkedStatusIsValid;

    public LinkedStatusIsValid(Boolean linkedStatusIsValid) {
      this.linkedStatusIsValid = linkedStatusIsValid;
    }
  }
}

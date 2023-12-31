package org.dongdong.banking.domain;

import lombok.*;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.UUID;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FirmBankingRequest {

  private Long firmBankingRequestId;
  private String fromBankName;
  private String fromBankAccount;
  private String toBankName;
  private String toBankAccount;
  private Integer amount;
  @Enumerated(EnumType.STRING)
  private FirmBankingStatus status;
  private String uuid;


  public static FirmBankingRequest create(
    FirmBankingRequestId requestId,
    FromBankName fromBankName,
    FromBankAccount fromBankAccount,
    ToBankName toBankName,
    ToBankAccount toBankAccount,
    Amount amount,
    FirmBankingStatusValue status,
    String uuid
  ) {
    FirmBankingRequest firmBankingRequest = new FirmBankingRequest();
    firmBankingRequest.firmBankingRequestId = requestId.getFirmBankingRequestId();
    firmBankingRequest.fromBankName = fromBankName.getFromBankName();
    firmBankingRequest.fromBankAccount = fromBankAccount.getFromBankAccount();
    firmBankingRequest.toBankName = toBankName.getToBankName();
    firmBankingRequest.toBankAccount = toBankAccount.getToBankAccount();
    firmBankingRequest.amount = amount.getAmount();
    firmBankingRequest.status = status.getStatus();
    firmBankingRequest.uuid = uuid;

    return firmBankingRequest;
  }

  @Value
  public static class FirmBankingRequestId {

    Long firmBankingRequestId;

    public FirmBankingRequestId(Long firmBankingRequestId){
      this.firmBankingRequestId = firmBankingRequestId;
    }
  }


  @Value
  public static class FromBankName {

    String fromBankName;

    public FromBankName(String fromBankName){
      this.fromBankName = fromBankName;
    }
  }

  @Value
  public static class FromBankAccount {

    String fromBankAccount;

    public FromBankAccount(String fromBankAccount){
      this.fromBankAccount = fromBankAccount;
    }
  }

  @Value
  public static class ToBankName {

    String toBankName;

    public ToBankName(String toBankName){
      this.toBankName = toBankName;
    }
  }

  @Value
  public static class ToBankAccount {

    String toBankAccount;

    public ToBankAccount(String toBankAccount){
      this.toBankAccount = toBankAccount;
    }
  }

  @Value
  public static class Amount {

    Integer amount;

    public Amount(Integer amount){
      this.amount = amount;
    }
  }

  @Value
  public static class FirmBankingStatusValue {

    FirmBankingStatus status;

    public FirmBankingStatusValue(FirmBankingStatus status){
      this.status = status;
    }
  }
}

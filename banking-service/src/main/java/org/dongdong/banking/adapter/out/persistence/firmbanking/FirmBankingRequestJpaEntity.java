package org.dongdong.banking.adapter.out.persistence.firmbanking;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.dongdong.banking.domain.FirmBankingStatus;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Getter
@Table(name = "FirmBankingRequest")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class FirmBankingRequestJpaEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long firmBankingRequestId;
  private String fromBankName;
  private String fromBankAccount;
  private String toBankName;
  private String toBankAccount;
  private Integer amount;
  @Enumerated(EnumType.STRING)
  private FirmBankingStatus status;
  private String uuid;

  public static FirmBankingRequestJpaEntity create(
    String fromBankName,
    String fromBankAccount,
    String toBankName,
    String toBankAccount,
    Integer amount,
    FirmBankingStatus status
  ){
    FirmBankingRequestJpaEntity entity = new FirmBankingRequestJpaEntity();
    entity.fromBankName = fromBankName;
    entity.fromBankAccount = fromBankAccount;
    entity.toBankName = toBankName;
    entity.toBankAccount = toBankAccount;
    entity.amount = amount;
    entity.status = status;
    entity.uuid = UUID.randomUUID().toString();
    return entity;
  }

  public FirmBankingRequestJpaEntity complete(){
    this.status = FirmBankingStatus.COMPLETED;
    return this;
  }

  public FirmBankingRequestJpaEntity fail(){
    this.status = FirmBankingStatus.FAILED;
    return this;
  }
}

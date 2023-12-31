package org.dongdong.banking.application.port.in;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dongdong.banking.domain.FirmBankingRequest;
import org.dongdong.banking.domain.FirmBankingStatus;
import org.dongdong.common.SelfValidating;

@Data
@NoArgsConstructor
public class RequestFirmBankingCommand extends SelfValidating<RequestFirmBankingCommand> {

  private String fromBankName;
  private String fromBankAccountNumber;

  private String toBankName;
  private String toBankAccountNumber;

  private Integer amount;
  private FirmBankingStatus status;

  public RequestFirmBankingCommand(
    String fromBankName,
    String fromBankAccountNumber,
    String toBankName,
    String toBankAccountNumber,
    Integer amount,
    FirmBankingStatus status
  ) {

    this.fromBankName = fromBankName;
    this.fromBankAccountNumber = fromBankAccountNumber;
    this.toBankName = toBankName;
    this.toBankAccountNumber = toBankAccountNumber;
    this.amount = amount;
    this.status = status;

    this.validateSelf();
  }
}

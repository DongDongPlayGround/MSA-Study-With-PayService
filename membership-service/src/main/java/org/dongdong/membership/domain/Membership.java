package org.dongdong.membership.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Value;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Membership {

  private final Long membershipId;
  private final String name;
  private final String email;
  private final String address;
  private final Boolean isValid; // 유효한 고객인지
  private final Boolean isCorp; // 법인인지

  /*도메인은 진짜 오염되면 안 되는 클래스
  * 따라서 클래스 생성 접근제어자도 private, 즉 이 클래스에서만 가능하도록 한다*/

  public static Membership create(MembershipId membershipId,
                                  MembershipName membershipName,
                                  MembershipEmail membershipEmail,
                                  MembershipAddress membershipAddress,
                                  MembershipIsValid membershipIsValid,
                                  MembershipIsCorp membershipIsCorp){
    return new Membership(
      membershipId.membershipId,
      membershipName.name,
      membershipEmail.email,
      membershipAddress.address,
      membershipIsValid.isValid,
      membershipIsCorp.isCorp
    );
  }

  /* 해당 static 클래스를 활용해서만 Id 를 만들 수 있도로 강제성 부여
  * 클린 아키텍쳐를 위해 setter 를 제외하고 유일한 생성 통로를 만들어 준다*/
  @Value
  public static class MembershipId {

    Long membershipId;
    public MembershipId(Long value){
      this.membershipId = value;
    }
  }

  @Value
  public static class MembershipName {
    String name;
    public MembershipName(String name){
      this.name = name;
    }
  }
  @Value
  public static class MembershipEmail {
    String email;
    public MembershipEmail(String email){
      this.email = email;
    }
  }
  @Value
  public static class MembershipAddress {
    String address;
    public MembershipAddress(String address){
      this.address = address;
    }
  }
  @Value
  public static class MembershipIsValid {
    Boolean isValid;
    public MembershipIsValid(Boolean isValid){
      this.isValid = isValid;
    }
  }

  @Value
  public static class MembershipIsCorp {
    Boolean isCorp;
    public MembershipIsCorp(Boolean isCorp){
      this.isCorp = isCorp;
    }
  }
}

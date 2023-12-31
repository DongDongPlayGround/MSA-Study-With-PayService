package org.dongdong.membership.adapter.out.persistence;

import org.dongdong.membership.domain.Membership;
import org.springframework.stereotype.Component;

@Component
public class MembershipMapper {

  public Membership mapToDomainEntity(MembershipJpaEntity membershipJpaEntity){
    return Membership.create(
      new Membership.MembershipId(membershipJpaEntity.getMembershipId()),
      new Membership.MembershipName(membershipJpaEntity.getName()),
      new Membership.MembershipEmail(membershipJpaEntity.getEmail()),
      new Membership.MembershipAddress(membershipJpaEntity.getAddress()),
      new Membership.MembershipIsValid(membershipJpaEntity.getIsValid()),
      new Membership.MembershipIsCorp(membershipJpaEntity.getIsCorp())
    );
  }
}

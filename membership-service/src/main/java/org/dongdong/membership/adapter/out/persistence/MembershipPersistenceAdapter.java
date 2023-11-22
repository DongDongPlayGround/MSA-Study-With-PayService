package org.dongdong.membership.adapter.out.persistence;

import common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.dongdong.membership.application.port.out.FindMembershipPort;
import org.dongdong.membership.application.port.out.RegisterMembershipPort;
import org.dongdong.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort {

  private final MembershipJpaRepository jpaRepository;

  @Override
  public MembershipJpaEntity createMembership(Membership.MembershipName membershipName,
                               Membership.MembershipEmail membershipEmail,
                               Membership.MembershipAddress membershipAddress,
                               Membership.MembershipIsValid membershipIsValid,
                               Membership.MembershipIsCorp membershipIsCorp) {
    return jpaRepository.save(
      new MembershipJpaEntity(
        membershipName.getName(),
        membershipEmail.getEmail(),
        membershipAddress.getAddress(),
        membershipIsValid.getIsValid(),
        membershipIsCorp.getIsCorp()
      )
    );
  }

  @Override
  public MembershipJpaEntity findMembership(Membership.MembershipId id) {
    Long membershipId = id.getMembershipId();
    return jpaRepository.findById(membershipId).orElse(null);
  }
}

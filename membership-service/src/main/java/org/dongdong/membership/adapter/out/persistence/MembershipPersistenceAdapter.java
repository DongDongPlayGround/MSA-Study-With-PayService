package org.dongdong.membership.adapter.out.persistence;

import org.dongdong.common.PersistenceAdapter;
import lombok.RequiredArgsConstructor;
import org.dongdong.membership.application.port.out.FindMembershipPort;
import org.dongdong.membership.application.port.out.ModifyMembershipPort;
import org.dongdong.membership.application.port.out.RegisterMembershipPort;
import org.dongdong.membership.domain.Membership;

@PersistenceAdapter
@RequiredArgsConstructor
public class MembershipPersistenceAdapter implements RegisterMembershipPort, FindMembershipPort, ModifyMembershipPort {

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

  @Override
  public MembershipJpaEntity modifyMembership(
    Membership.MembershipId membershipId,
    Membership.MembershipName membershipName,
    Membership.MembershipEmail membershipEmail,
    Membership.MembershipAddress membershipAddress,
    Membership.MembershipIsValid membershipIsValid,
    Membership.MembershipIsCorp membershipIsCorp
  ) {
    MembershipJpaEntity entity = jpaRepository.getById(membershipId.getMembershipId());
    entity.setName(membershipName.getName());
    entity.setEmail(membershipEmail.getEmail());
    entity.setAddress(membershipAddress.getAddress());
    entity.setIsValid(membershipIsValid.getIsValid());
    entity.setIsCorp(membershipIsCorp.getIsCorp());

    return jpaRepository.save(entity);
  }
}

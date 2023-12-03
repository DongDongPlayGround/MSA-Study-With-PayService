package org.dongdong.membership.application.port.out;

import org.dongdong.membership.adapter.out.persistence.MembershipJpaEntity;
import org.dongdong.membership.domain.Membership;

public interface RegisterMembershipPort {

  MembershipJpaEntity createMembership(
    Membership.MembershipName membershipName,
    Membership.MembershipEmail membershipEmail,
    Membership.MembershipAddress membershipAddress,
    Membership.MembershipIsValid membershipIsValid,
    Membership.MembershipIsCorp membershipIsCorp);
}

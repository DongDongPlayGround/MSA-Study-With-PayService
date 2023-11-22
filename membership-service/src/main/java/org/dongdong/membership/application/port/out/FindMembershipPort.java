package org.dongdong.membership.application.port.out;

import org.dongdong.membership.adapter.out.persistence.MembershipJpaEntity;
import org.dongdong.membership.domain.Membership;

public interface FindMembershipPort {

  MembershipJpaEntity findMembership(Membership.MembershipId id);
}

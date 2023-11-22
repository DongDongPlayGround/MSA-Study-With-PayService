package org.dongdong.membership.application.port.in;

import org.dongdong.membership.domain.Membership;

public interface FindMembershipUseCase {

  Membership findMembership(Long id);

}

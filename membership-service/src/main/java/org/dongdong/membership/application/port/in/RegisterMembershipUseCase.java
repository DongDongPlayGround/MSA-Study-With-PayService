package org.dongdong.membership.application.port.in;

import org.dongdong.membership.domain.Membership;

public interface RegisterMembershipUseCase {

  Membership registerMembership(RegisterMembershipCommand command);
}

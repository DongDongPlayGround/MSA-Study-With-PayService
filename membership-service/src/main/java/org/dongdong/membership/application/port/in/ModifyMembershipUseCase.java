package org.dongdong.membership.application.port.in;

import org.dongdong.membership.domain.Membership;

public interface ModifyMembershipUseCase {

  Membership modifyMembership(Long id, ModifyMembershipCommand command);

}

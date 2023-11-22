package org.dongdong.membership.application.service;

import common.UseCase;
import lombok.RequiredArgsConstructor;
import org.dongdong.membership.adapter.out.persistence.MembershipJpaEntity;
import org.dongdong.membership.adapter.out.persistence.MembershipMapper;
import org.dongdong.membership.application.port.in.RegisterMembershipCommand;
import org.dongdong.membership.application.port.in.RegisterMembershipUseCase;
import org.dongdong.membership.application.port.out.RegisterMembershipPort;
import org.dongdong.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
public class RegisterMembershipService implements RegisterMembershipUseCase {

  private final RegisterMembershipPort registerMembershipPort;
  private final MembershipMapper mapper;
  @Override
  public Membership registerMembership(RegisterMembershipCommand command) {
    // db에 저장을 해야함 -> db는 외부서비스! port 와 adapter out 을 사용하자!
    MembershipJpaEntity entity = registerMembershipPort.createMembership(
      new Membership.MembershipName(command.getName()),
      new Membership.MembershipEmail(command.getEmail()),
      new Membership.MembershipAddress(command.getAddress()),
      new Membership.MembershipIsValid(command.getIsValid()),
      new Membership.MembershipIsCorp(command.getIsCorp())
    );
    return mapper.mapToDomainEntity(entity);
  }
}

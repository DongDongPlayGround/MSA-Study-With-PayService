package org.dongdong.membership.application.service;

import org.dongdong.common.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongdong.membership.adapter.out.persistence.MembershipJpaEntity;
import org.dongdong.membership.adapter.out.persistence.MembershipMapper;
import org.dongdong.membership.application.port.in.ModifyMembershipCommand;
import org.dongdong.membership.application.port.in.ModifyMembershipUseCase;
import org.dongdong.membership.application.port.out.FindMembershipPort;
import org.dongdong.membership.application.port.out.ModifyMembershipPort;
import org.dongdong.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
@Slf4j
public class ModifyMembershipService implements ModifyMembershipUseCase {

  private final FindMembershipPort findMembershipPort;
  private final ModifyMembershipPort modifyMembershipPort;
  private final MembershipMapper mapper;
  public Membership findMembership(Long id){

    MembershipJpaEntity membership = findMembershipPort.findMembership(new Membership.MembershipId(id));
    log.info("membership : {}", membership);
    return mapper.mapToDomainEntity(membership);
  }

  @Override
  public Membership modifyMembership(Long id, ModifyMembershipCommand command) {
    MembershipJpaEntity membershipJpaEntity = modifyMembershipPort.modifyMembership(
      new Membership.MembershipId(command.getId()),
      new Membership.MembershipName(command.getName()),
      new Membership.MembershipEmail(command.getEmail()),
      new Membership.MembershipAddress(command.getAddress()),
      new Membership.MembershipIsValid(command.getIsValid()),
      new Membership.MembershipIsCorp(command.getIsCorp()));
    return mapper.mapToDomainEntity(membershipJpaEntity);
  }
}

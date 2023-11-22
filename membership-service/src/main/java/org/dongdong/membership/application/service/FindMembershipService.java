package org.dongdong.membership.application.service;

import common.UseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.dongdong.membership.adapter.out.persistence.MembershipJpaEntity;
import org.dongdong.membership.adapter.out.persistence.MembershipMapper;
import org.dongdong.membership.application.port.in.FindMembershipUseCase;
import org.dongdong.membership.application.port.out.FindMembershipPort;
import org.dongdong.membership.domain.Membership;
import org.springframework.transaction.annotation.Transactional;

@UseCase
@RequiredArgsConstructor
@Transactional
@Slf4j
public class FindMembershipService implements FindMembershipUseCase {

  private final FindMembershipPort findMembershipPort;
  private final MembershipMapper mapper;
  public Membership findMembership(Long id){

    MembershipJpaEntity membership = findMembershipPort.findMembership(new Membership.MembershipId(id));
    log.info("membership : {}", membership);
    return mapper.mapToDomainEntity(membership);
  }
}

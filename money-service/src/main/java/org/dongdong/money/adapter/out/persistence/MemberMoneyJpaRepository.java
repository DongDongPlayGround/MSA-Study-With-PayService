package org.dongdong.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberMoneyJpaRepository extends JpaRepository<MemberMoneyJpaEntity, Long> {

  Optional<MemberMoneyJpaEntity> findAllByMembershipIdAndLinkedBankAccountId(Long membershipId, Long linkedBankAccountId);
}

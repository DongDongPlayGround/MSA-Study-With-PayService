package org.dongdong.money.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MoneyChangingRequestJpaRepository extends JpaRepository<MoneyChangingRequestJpaEntity, Long> {
}
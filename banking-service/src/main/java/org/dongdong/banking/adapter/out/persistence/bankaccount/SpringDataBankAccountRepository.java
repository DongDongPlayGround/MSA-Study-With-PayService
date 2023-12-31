package org.dongdong.banking.adapter.out.persistence.bankaccount;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataBankAccountRepository extends JpaRepository<BankAccountJpaEntity, Long> {
}

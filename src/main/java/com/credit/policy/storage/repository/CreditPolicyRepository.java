package com.credit.policy.storage.repository;

import com.credit.policy.storage.model.CreditPolicy;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

@Repository
public interface CreditPolicyRepository extends JpaRepository<CreditPolicy, UUID> {
}

package com.smt.repository;

import com.smt.entity.SmtSubscription;
import com.tr.core.repository.repository.jpa.EntityJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmtSubscriptionRepository extends EntityJpaRepository<SmtSubscription> {

}
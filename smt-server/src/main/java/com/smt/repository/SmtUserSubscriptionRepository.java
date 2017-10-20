package com.smt.repository;

import com.smt.entity.SmtUserSubscription;
import com.tr.core.repository.repository.jpa.EntityJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmtUserSubscriptionRepository extends EntityJpaRepository<SmtUserSubscription> {

}
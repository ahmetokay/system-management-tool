package com.smt.repository;

import com.smt.entity.SmtUser;
import com.tr.core.repository.repository.jpa.EntityJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmtUserRepository extends EntityJpaRepository<SmtUser> {

}
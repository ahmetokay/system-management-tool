package com.smt.repository;

import com.smt.entity.SmtUserRole;
import com.tr.core.repository.repository.jpa.EntityJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SmtUserRoleRepository extends EntityJpaRepository<SmtUserRole> {

}
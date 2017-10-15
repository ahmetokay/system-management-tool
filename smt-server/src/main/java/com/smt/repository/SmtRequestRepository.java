package com.smt.repository;

import com.smt.entity.SmtRequest;
import com.tr.core.repository.repository.jpa.EntityJpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by bocal on 8/8/17.
 */
@Repository
public interface SmtRequestRepository extends EntityJpaRepository<SmtRequest> {

}
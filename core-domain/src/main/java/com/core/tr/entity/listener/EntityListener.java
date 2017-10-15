package com.core.tr.entity.listener;

import com.core.tr.entity.BaseEntity;

import javax.persistence.PrePersist;

/**
 * @author bocal
 */

public class EntityListener {

    @PrePersist
    public void prePersist(BaseEntity baseEntity) {
        baseEntity.setIsActive(true);
    }

}

package com.core.tr.entity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

/**
 * @author bocal
 */

@MappedSuperclass
public interface EntityRule extends Serializable {

    Long getPkid();

    void setPkid(Long pkid);

}

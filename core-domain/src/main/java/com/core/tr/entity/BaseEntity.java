package com.core.tr.entity;

import com.core.tr.entity.listener.EntityListener;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

/**
 * @author bocal
 */

@MappedSuperclass
@EntityListeners(EntityListener.class)
public abstract class BaseEntity implements EntityRule, Comparable<BaseEntity> {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "pkid", updatable = false)
  private Long pkid;

  @Column(name = "isactive")
  @NotNull
  private Boolean isActive;

  public BaseEntity() {
  }

  @Override
  public Long getPkid() {
    return pkid;
  }

  @Override
  public void setPkid(Long pkid) {
    this.pkid = pkid;
  }

  public Boolean getIsActive() {
    return isActive;
  }

  public void setIsActive(Boolean isActive) {
    this.isActive = isActive;
  }

  @Override
  public int compareTo(BaseEntity o) {
    return Integer.compare(this.hashCode(), o.hashCode());
  }

}

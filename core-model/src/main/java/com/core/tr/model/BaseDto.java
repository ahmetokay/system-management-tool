package com.core.tr.model;

/**
 * JSON yapisinda kullanilabilecek ve Serializable nesnedir.
 *
 * @author bocal
 */

public class BaseDto implements DtoRule {

  private Long pkid;

  private Boolean isactive;

  public BaseDto() {
  }

  @Override
  public Long getPkid() {
    return pkid;
  }

  @Override
  public void setPkid(Long pkid) {
    this.pkid = pkid;
  }

  public Boolean getIsactive() {
    return isactive;
  }

  public void setIsactive(Boolean isactive) {
    this.isactive = isactive;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BaseDto baseDto = (BaseDto) o;
    return isactive == baseDto.isactive && (pkid != null ? pkid.equals(baseDto.pkid)
        : baseDto.pkid == null);
  }

  @Override
  public int hashCode() {
    return pkid != null ? pkid.hashCode() : 0;
  }
}

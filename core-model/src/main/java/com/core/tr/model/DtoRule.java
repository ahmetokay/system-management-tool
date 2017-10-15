package com.core.tr.model;

import java.io.Serializable;

/**
 * Tasima ve gosterme islemleri icin kullanilan nesnelerin(Dto) en temel sinifidir.
 *
 * @author bocal
 */

public interface DtoRule extends Serializable {


  Long getPkid();

  void setPkid(Long pkid);

}

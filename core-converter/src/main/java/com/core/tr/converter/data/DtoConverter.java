package com.core.tr.converter.data;


import com.core.tr.entity.BaseEntity;
import com.core.tr.model.BaseDto;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Dto sinifilari icin kullanilan donusturucu arayuzudur.
 *
 * @author bocal
 */

public interface DtoConverter<D extends BaseDto, E extends BaseEntity> {

  /**
   * Verilen {@link BaseEntity} nesne listesini {@link Set<BaseDto>}'e cevirmektedir.
   *
   * @param entityList {@link BaseEntity} listesi
   * @return Set
   */
  Set<D> convertToDtoSet(Collection<E> entityList);

  /**
   * Verilen {@link BaseEntity} nesne listesini {@link List<BaseDto>}'e cevirmektedir.
   *
   * @param entityList {@link BaseEntity} listesi
   * @return List
   */
  List<D> convertToDtoList(Collection<E> entityList);

  /**
   * Verilen {@link BaseEntity} nesnesini {@link BaseDto} nesnesine cevirme islemini
   * yapmaktadir.
   *
   * @param entity {@link BaseEntity}
   * @return D
   */
  D convertToDto(E entity);
}

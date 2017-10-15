package com.core.tr.converter.data;


import com.core.tr.entity.BaseEntity;
import com.core.tr.model.BaseDto;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Entity sinifilari icin kullanilan donusturucu arayuzudur.
 *
 * @author bocal
 */

public interface EntityConverter<D extends BaseDto, E extends BaseEntity> {

  /**
   * Verilen {@link BaseDto} nesne listesini {@link Set<BaseEntity>}'e cevirmektedir.
   *
   * @param dtoList {@link BaseDto} listesi
   * @return Set
   */
  Set<E> convertToEntitySet(Collection<D> dtoList);

  /**
   * Verilen {@link BaseDto} nesne listesini {@link List<BaseEntity>}'e cevirmektedir.
   *
   * @param dtoList {@link BaseDto} listesi
   * @return List
   */
  List<E> convertToEntityList(Collection<D> dtoList);

  /**
   * Verilen {@link BaseDto} nesnesini {@link BaseEntity} nesnesine cevirme islemini yapmaktadir.
   *
   * @param dto {@link BaseDto}
   * @return E
   */
  E convertToEntity(D dto);

}

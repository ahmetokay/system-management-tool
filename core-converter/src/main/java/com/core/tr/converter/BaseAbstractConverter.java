package com.core.tr.converter;

import com.core.tr.converter.data.DtoConverter;
import com.core.tr.converter.data.EntityConverter;
import com.core.tr.entity.BaseEntity;
import com.core.tr.model.BaseDto;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.util.ReflectionUtils;

/**
 * {@link BaseDto} ve {@link BaseEntity} nesneleri arasinda donusturme islemleri yapilmaktadir.
 * Donusturuculer icin olusturulmus en temel siniftir. Bu sinifta temel nesnelerde olan id ve
 * deleted alanlari atanmaktadir. Bu yuzden gelistirme aninda elle bunlarin setlenmesine gerek
 * yoktur.
 *
 * @author bocal
 */

public abstract class BaseAbstractConverter<D extends BaseDto, E extends BaseEntity> implements
    DtoConverter<D, E>, EntityConverter<D, E> {

  private Class<D> dtoClass;

  private Class<E> entityClass;

  public BaseAbstractConverter() {
    this.dtoClass = (Class<D>) (((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[0]);
    this.entityClass = (Class<E>) (((ParameterizedType) getClass().getGenericSuperclass())
        .getActualTypeArguments()[1]);
  }

  /**
   * Entity nesnesini Dto nesnesine donusturmektedir.
   *
   * @param dto Data Transfer Object
   * @param entity Entity
   */
  protected abstract void doConvertToDto(D dto, E entity);

  /**
   * Dto nesnesini Entity nesnesine donusturmektedir.
   *
   * @param entity Entity
   * @param dto Data Transfer Object
   */
  protected abstract void doConvertToEntity(E entity, D dto);

  /**
   * Entity kumesini Dto kumesine donusturmektedir.
   *
   * @param entitySet Entity kumesi
   * @return Set
   */
  public Set<D> convertToDtoSet(Collection<E> entitySet) {
    return entitySet == null ? null
        : entitySet.stream().map(this::convertToDto).collect(Collectors.toSet());
  }

  /**
   * Entity listesini Dto listesine donusturmektedir.
   *
   * @param entityList Entity Listesi
   * @return List
   */
  public List<D> convertToDtoList(Collection<E> entityList) {
    return entityList == null ? null
        : entityList.stream().map(this::convertToDto).collect(Collectors.toList());
  }

  /**
   * Entity nesnesini Dto nesnesine donusturmektedir.
   *
   * @param entity Entity
   */
  public D convertToDto(E entity) {
    if (entity == null) {
      return null;
    }

    D dto = createDto();
    doConvertToDto(dto, entity);
    dto.setPkid(entity.getPkid());
    dto.setIsactive(entity.getIsActive());
    return dto;
  }

  /**
   * Dto kumesini Entity kumesine donusturmektedir.
   *
   * @param dtoSet Dto kumesi
   * @return Set
   */
  public Set<E> convertToEntitySet(Collection<D> dtoSet) {
    return dtoSet == null ? null
        : dtoSet.stream().map(this::convertToEntity).collect(Collectors.toSet());
  }

  /**
   * Dto listesini Entity listesine donusturmektedir.
   *
   * @param dtoList Entity Listesi
   * @return List
   */
  public List<E> convertToEntityList(Collection<D> dtoList) {
    return dtoList == null ? null
        : dtoList.stream().map(this::convertToEntity).collect(Collectors.toList());
  }

  /**
   * Dto nesnesini Entity nesnesine donusturmektedir.
   *
   * @param dto Data Transfer Object
   */
  public E convertToEntity(D dto) {
    if (dto == null) {
      return null;
    }

    E entity = createEntity();
    doConvertToEntity(entity, dto);
    entity.setPkid(dto.getPkid());
    entity.setIsActive(dto.getIsactive());
    return entity;
  }

  /*
   * Reflection ile Dto nesnesi olusturulur. Boylelikle id ve deleted alanlari bu sinifta atanir.
   */
  private D createDto() {
    try {
      Constructor<D> ctor = dtoClass.getDeclaredConstructor();
      ReflectionUtils.makeAccessible(ctor);
      return ctor.newInstance();
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

  /*
   * Reflection ile Entity nesnesi olusturulur. Boylelikle id ve deleted alanlari bu sinifta atanir.
   */
  private E createEntity() {
    try {
      Constructor<E> ctor = entityClass.getDeclaredConstructor();
      ReflectionUtils.makeAccessible(ctor);
      return ctor.newInstance();
    } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      throw new RuntimeException(e);
    }
  }

}

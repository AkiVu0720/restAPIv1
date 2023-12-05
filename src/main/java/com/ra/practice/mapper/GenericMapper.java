package com.ra.practice.mapper;

public interface GenericMapper<E,T,U> {
    E toEntity(T t);
    U toResponse(E e);

}

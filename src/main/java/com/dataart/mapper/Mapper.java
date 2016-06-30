package com.dataart.mapper;

public interface Mapper<T, TDto> {

    T fromDto(TDto tDto);

    TDto toDto(T t);

}

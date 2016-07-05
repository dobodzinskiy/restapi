package com.dataart.dao;

import java.util.List;

public interface Dao<T> {

    List<T> findAll();

    T find(int id);

    T create(T t);

    T update(T t);
}

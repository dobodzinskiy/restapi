package com.dataart.dao;

import java.util.List;

public interface Dao<T> {

    List<T> findAll();

    T find(int id);

    void create(T t);

    void update(T t);
}

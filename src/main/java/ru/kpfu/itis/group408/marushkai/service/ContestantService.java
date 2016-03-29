package ru.kpfu.itis.group408.marushkai.service;

import java.util.List;

/**
 * Created by unlim_000 on 29.03.2016.
 */
public interface ContestantService<T> {
    void add(T toAdd);

    void deleteById(Integer id) throws Exception;

    void deleteByName(String name);

    T getByName(String name);

    T getById(Integer id) throws Exception;

    List<T> listContestants();
}

package ru.kpfu.itis.group408.marushkai.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Created by unlim_000 on 19.03.2016.
 */
public interface DAO<T> extends Serializable {

    void add(T toAdd);

    void deleteById(Integer id) throws Exception;

    void deleteByName(String name);

    T getByName(String name);

    T getById(Integer id) throws Exception;

    List<T> listContestants();
}

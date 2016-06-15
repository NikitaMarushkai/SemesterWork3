package ru.kpfu.itis.group408.marushkai.service.interfaces;

import ru.kpfu.itis.group408.marushkai.form.EditTableForm;

import java.util.List;

/**
 * Created by unlim_000 on 29.03.2016.
 */
public interface StandingService<T> {
    void add(T toAdd);

    void deleteById(Integer id) throws Exception;

    void deleteByName(String name);

    T getByName(String name);

    T getById(Integer id) throws Exception;

    List<T> getWestSide();

    List<T> getEastSide();

    void update(EditTableForm form);
}
